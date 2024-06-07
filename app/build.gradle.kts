@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

var dimension = "default"
var flavor = "production"
android {
    namespace = "com.arif.moviedbcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.arif.moviedbcompose"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }

    // Setup Product Flavors
    flavorDimensions.add(dimension)
    productFlavors {
        create("staging") {
            flavor = "staging"
            applicationIdSuffix = ".dev"
        }
        create("production") {
            flavor = "production"
            applicationIdSuffix = ".dev"
        }
        all {
            buildConfigField(
                "String",
                "BASE_URL",
                String.format("\"%s\"",PropHelper.getEnvProp("baseUrl.$flavor"))
            )
            externalNativeBuild {
                cmake {
                    cppFlags(
                        String.format("-DAPI_KEY=\\\"%s\\\"",
                            PropHelper.getAndEncodeBuildProp("apiKey.$flavor"))
                    )
                }
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
    packaging {
        jniLibs {
            pickFirsts.add("lib/x86/libc++_shared.so")
            pickFirsts.add("lib/x86_64/libc++_shared.so")
            pickFirsts.add("lib/armeabi-v7a/libc++_shared.so")
            pickFirsts.add("lib/arm64-v8a/libc++_shared.so")

            resources {
                excludes += "META-INF/LICENSE.md" //junit-ktx
                excludes += "META-INF/LICENSE-notice.md" //junit-ktx
                excludes += "MANIFEST.MF" //mockk-android
            }
        }
    }
}

dependencies {

    implementation(Dependencies.coreKtx)
    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies.composeActivity)
    implementation(platform(Dependencies.composeBom))
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeToolingPreview)
    implementation(Dependencies.composeMaterial3)

    // Retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitMoshiConverter)
    implementation(Dependencies.retrofitGsonConverter)
    implementation(Dependencies.loggingInterceptor)

    // Coroutines
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)

    //hilt DI
    implementation(Dependencies.daggerHiltAndroid)
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    kapt(Dependencies.daggerHiltAndroidCompiler)
    kapt(Dependencies.androidXHiltCompiler)
    implementation(Dependencies.androidXHiltNavigation)
    implementation(Dependencies.androidXHiltNavigationCompose)
    implementation(Dependencies.androidXHiltWork)

    // Chucker
    debugImplementation(Dependencies.chucker)
    releaseImplementation(Dependencies.chuckerNoOp)

    // Moshi
    implementation(Dependencies.moshi)
    kapt(Dependencies.moshiCodegen)

    // SplashScreen
    implementation(Dependencies.splashScreen)

    // Coil
    implementation(Dependencies.coil)

    // Navigation
    implementation(Dependencies.navigationCompose)

    // Room
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
    implementation(Dependencies.roomPaging)

    // SystemUIController
    implementation(Dependencies.systemUiController)

    // Extended Icons
    implementation(Dependencies.extendedIcons)

    testImplementation(Dependencies.mockTest)
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

kapt {
    correctErrorTypes = true
}