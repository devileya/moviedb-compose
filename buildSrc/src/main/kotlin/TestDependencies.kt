import org.gradle.api.artifacts.dsl.Dependencies

object TestDependencies {

    const val mockkVersion = "1.12.0"
    const val mockk = "io.mockk:mockk:$mockkVersion"
    const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"

    private const val coreTestingVersion = "2.1.0"
    const val coreTesting = "androidx.arch.core:core-testing:$coreTestingVersion"

    private const val extJUnitVersion = "1.1.3"
    const val extJUnit = "androidx.test.ext:junit:$extJUnitVersion"
    const val extJUnitKtx = "androidx.test.ext:junit-ktx:$extJUnitVersion"

    private const val jUnit5Version = "5.9.1"
    const val jUnit5 = "org.junit.jupiter:junit-jupiter:$jUnit5Version"
    const val jUnit5Api = "org.junit.jupiter:junit-jupiter-api:$jUnit5Version"
    const val jUnit5Params = "org.junit.jupiter:junit-jupiter-params:$jUnit5Version"
    const val jUnit5Engine = "org.junit.jupiter:junit-jupiter-engine:$jUnit5Version"

    private const val espressoVersion = "3.5.1"
    const val espresso = "androidx.test.espresso:espresso-core:$espressoVersion"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:$espressoVersion"

    private const val mockWebServerVersion = "4.10.0"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$mockWebServerVersion"

    private const val coroutinesVersion = "1.6.4"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesVersion"

    const val liveDataTesting = "com.jraska.livedata:testing-ktx:1.2.0"

    private const val daggerHiltVersion = "2.44"
    const val daggerHiltTesting = "com.google.dagger:hilt-android-testing:$daggerHiltVersion"

    const val fragmetTesting = "androidx.fragment:fragment-testing:1.4.0"

    const val navigationTesting = "androidx.navigation:navigation-testing:2.5.2"

    const val testMonitor = "androidx.test:monitor:1.6.1"
    const val testRule = "androidx.test:rules:1.5.0"
}
