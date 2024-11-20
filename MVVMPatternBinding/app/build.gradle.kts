plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mvvmpatternbinding"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.mvvmpatternbinding"
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
  viewBinding{
      enable=true
  }
    dataBinding{
        enable=true
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

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.8.6")
    // LiveData
    implementation( "androidx.lifecycle:lifecycle-livedata:$2.8.6")

    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
}