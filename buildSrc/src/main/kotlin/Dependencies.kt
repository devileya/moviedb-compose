object Dependencies {

    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.kotlinKtx}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }

    // Dagger-Hilt DI
    const val daggerHiltVersion = "2.47"
    const val daggerHiltAndroid = "com.google.dagger:hilt-android:$daggerHiltVersion"
    const val daggerHiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:$daggerHiltVersion"

    // Hilt-Android DI
    private const val androidXHiltVersion = "1.2.0"
    const val androidXHiltCompiler = "androidx.hilt:hilt-compiler:$androidXHiltVersion"
    const val androidXHiltNavigation = "androidx.hilt:hilt-navigation-fragment:$androidXHiltVersion"
    const val androidXHiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$androidXHiltVersion"
    const val androidXHiltWork = "androidx.hilt:hilt-work:$androidXHiltVersion"

    // Retrofit
    private const val retrofitVersion = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.2"

    // Coroutines
    private const val coroutinesVersion = "1.6.4"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"

    // Chucker
    const val chucker = "com.github.chuckerteam.chucker:library:3.5.2"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:3.5.2"

    // Stetho
    private const val stethoVersion = "1.6.0"
    const val stetho = "com.facebook.stetho:stetho:$stethoVersion"
    const val stethoOkHttp = "com.facebook.stetho:stetho-okhttp3:$stethoVersion"

    // Moshi
    private const val moshiVersion = "1.14.0"
    const val moshi = "com.squareup.moshi:moshi-kotlin:$moshiVersion"
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"

    // Splashscreen
    val splashScreen by lazy { "androidx.core:core-splashscreen:1.0.1" }

    // Coil
    const val coil = "io.coil-kt:coil-compose:2.3.0"

    // Navigation
    private const val navVersion = "2.7.7"
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:$navVersion" }

    // Room
    private const val roomVersion = "2.6.0"
    const val roomKtx = "androidx.room:room-ktx:$roomVersion"
    const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    const val roomPaging = "androidx.room:room-paging:$roomVersion"

    // system ui controller
    const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:0.27.0"

    // Extended Icons
    const val extendedIcons = "androidx.compose.material:material-icons-extended"

    // Mock Test
    const val mockTest = "io.mockk:mockk:1.12.4"
}