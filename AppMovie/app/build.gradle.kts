plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.appmovie"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appmovie"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dataBinding{
        enable=true
    }
}

dependencies {
    implementation(libs.converter.gson)
    implementation(libs.retrofit)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.databinding.runtime)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


    // Swipe-to-refresh Layout
    implementation(libs.swiperefreshlayout)

    // Glide
    implementation (libs.glide)
    annotationProcessor (libs.compiler)


    // Solving Duplicate Class Error
    implementation(libs.kotlin.bom)


}