plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.navigation.safe.args)
}

android {
    namespace = "com.ren.zarinacapital"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ren.zarinacapital"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation(libs.dagger.android)
    kapt(libs.dagger.android.processor)

    implementation(libs.bundles.navigation)

    // Theme
    implementation(project(":core:theme"))

    // Data
    implementation(project(":data:courses"))
    implementation(project(":data:menu"))
    implementation(project(":data:my-courses"))
    implementation(project(":data:sign-in"))
    implementation(project(":data:sign-up"))

    // Features
    implementation(project(":features:courses"))
    implementation(project(":features:menu"))
    implementation(project(":features:my-courses"))
    implementation(project(":features:sign-in"))
    implementation(project(":features:sign-up"))
}