plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.normalrecyleview"
    compileSdk = 34
    buildFeatures {
        viewBinding= true
    }
    defaultConfig {
        applicationId = "com.example.normalrecyleview"
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
   // implementation ("com.chauthai.swipereveallayout:swipe-reveal-layout:1.4.2")
 //   implementation ("com.github.chthai64:SwipeRevealLayout:1.4.0")
   // implementation ("com.apachat.swipereveallayout-android:1.1.2'")
}