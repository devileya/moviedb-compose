import java.io.File
import java.io.FileInputStream
import java.util.Base64
import java.util.Properties

object PropHelper {
    private val envProp by lazy {
        Properties().apply {
            load(FileInputStream(File("env.properties")))
        }
    }

    private val buildProp by lazy {
        Properties().apply {
            load(FileInputStream(File("build.properties")))
        }
    }

    private val localProp by lazy {
        Properties().apply {
            load(FileInputStream(File("local.properties")))
        }
    }

    private val localPropFile by lazy {
        File("local.properties")
    }

    private val versionProp by lazy {
        Properties().apply {
            load(FileInputStream(File("version.properties")))
        }
    }

    private val versionPropFile by lazy {
        File("version.properties")
    }

    val defaultArch by lazy {
        "armeabi-v7a,arm64-v8a,x86,x86_64"
    }

    fun getEnvProp(key: String): String {
        return envProp.getProperty(key)
    }

    fun storeVersionProp() {
        versionProp.store(versionPropFile.writer(), null)
    }

    private fun storeLocalProp() {
        localProp.store(localPropFile.writer(), null)
    }

    fun setAndStoreLocalProp(key: String, value: String) {
        localProp.setProperty(key, value)
        storeLocalProp()
    }

    fun setVersionProp(key: String, value: String) {
        versionProp.setProperty(key, value)
    }

    fun setLocalProp(key: String, value: String) {
        localProp.setProperty(key, value)
    }

    fun setVersionName(value: String) {
        versionProp.setProperty("versionName", value)
    }

    fun setVersionCode(value: String) {
        versionProp.setProperty("versionCode", value)
    }

    fun getVersionName(): String {
        return versionProp.getProperty("versionName")
    }

    fun getVersionNameSuffix(): String? {
        return localProp.getProperty("versionNameSuffix")
    }

    fun getVersionCode(): Int {
        return versionProp.getProperty("versionCode").toInt()
    }

    fun getArchProp(): String? {
        return localProp.getProperty("arch")
    }

    fun getAndEncodeBuildProp(key: String): String {
        return Base64.getEncoder().encodeToString(buildProp.getProperty(key).toByteArray())
    }
}
