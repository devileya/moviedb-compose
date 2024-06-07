object BuildHelper {

    const val minSdk = 25
    const val targetSdk = 34

    // Plugins
    const val agpVersion = "8.2.0"
    const val kotlinVersion = "1.9.0"
    const val firebaseVersion = "2.9.9"

    const val androidGP = "com.android.application"
    const val libraryGP = "com.android.library"
    const val kotlinGP = "org.jetbrains.kotlin.android"
    const val firebaseGP = "com.google.firebase.crashlytics"

    const val googleServicePlugin = "com.google.gms:google-services:4.4.0"

    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Dependencies.daggerHiltVersion}"
}
