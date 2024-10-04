plugins {
    alias(libs.plugins.android.application)
    id("com.google.dagger.hilt.android")
    //id("kotlin-kapt")

}
android {
    namespace = "com.example.mymoviepaging"
    compileSdk = 34

   viewBinding{
       enable=true
   }


    defaultConfig {
        applicationId = "com.example.mymoviepaging"
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

}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Retrofit
      implementation (libs.retrofit)
    implementation (libs.gson)
    implementation (libs.converter.gson)
    // RxJava3 with retrofit
    implementation (libs.adapter.rxjava3)
    // Paging Library

    implementation (libs.paging.runtime)
    // optional - RxJava3 support
    implementation (libs.paging.rxjava3)




    // Hilt Dagger
    implementation (libs.hilt.android)
    annotationProcessor (libs.hilt.compiler)


    // Glide
    implementation (libs.glide)
    annotationProcessor (libs.compiler)


    // LIfeCycle

    // ViewModel
    implementation (libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation (libs.lifecycle.extensions)
}

