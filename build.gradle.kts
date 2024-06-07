buildscript {

    //region check arch.property exist or not for CI CD
    val archValue = PropHelper.getArchProp() ?: PropHelper.defaultArch
    PropHelper.setAndStoreLocalProp("arch", archValue)
    val availableArch by extra { PropHelper.getArchProp()?.split(',')?.map { it } ?: emptyList() }
    // endregion

    //region setup app version
    val appVersionName by extra(PropHelper.getVersionName())
    val appVersionCode by extra(PropHelper.getVersionCode())
    val appVersionNameSuffix by extra(PropHelper.getVersionNameSuffix() ?: "")
    //endregion

    val hiltVersion by extra(Dependencies.daggerHiltVersion)

    dependencies {
        classpath(BuildHelper.googleServicePlugin)
        classpath(BuildHelper.hiltPlugin)
    }
}

plugins {
    id(BuildHelper.androidGP) version(BuildHelper.agpVersion) apply false
    id(BuildHelper.libraryGP) version(BuildHelper.agpVersion) apply false
    id(BuildHelper.kotlinGP) version(BuildHelper.kotlinVersion) apply false
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}

tasks.register("arch") {
    var arch: String? = null
    val param = project.tasks.findByName("arch")?.name
    if (param == "task ':arch'") {
        //exit from unexpected param
        return@register
    }
    if (param == "all") {
        arch = PropHelper.defaultArch
    } else {
        //if param has more than 1, ex: x86,armeabi-v7a
        val paramList = param?.split(',')?.map { it } ?: emptyList()
        val defaultArchList = PropHelper.defaultArch.split(',').map { it }
        for (archValue in defaultArchList) {
            for (paramValue in paramList) {
                if (archValue == paramValue) {
                    arch = if (arch == null) paramValue else "$arch,$paramValue"
                    break
                }
            }
        }
    }

    if (arch == null) {
        println("unknown arch value is $arch returning")
        return@register
    }

    println("set arch value: $arch")

    PropHelper.setAndStoreLocalProp("arch", arch)
}

//region setup app version name, code and suffix
tasks.register("setAppVersion") {
    group = "build setup"
    description = "setup app version name, code and suffix"

    var versionPropsChanged = false

    if (project.hasProperty("versionName")) {
        PropHelper.setVersionName(project.property("versionName") as String)
        versionPropsChanged = true
    }
    if (project.hasProperty("versionCode")) {
        PropHelper.setVersionCode(project.property("versionCode") as String)
        versionPropsChanged = true
    }

    if (versionPropsChanged) {
        PropHelper.storeVersionProp()
    }

    if (project.hasProperty("suffix")) {
        if ((project.property("suffix") as String).isNotEmpty()) {
            PropHelper.setVersionProp("versionNameSuffix", "-${project.property("suffix")}")
        } else PropHelper.setVersionProp("versionNameSuffix", "")

        PropHelper.storeVersionProp()
    }
}
//endregion
