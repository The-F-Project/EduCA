plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "org.thefproject.fedu"
    compileSdk = 35

    defaultConfig {
        applicationId = "org.thefproject.fedu"
        minSdk = 26
        targetSdk = 33
        versionCode = 590
        versionName = "0.9"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            multiDexEnabled = true
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
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
        viewBinding = true
      buildConfig = true
    }
}


dependencies {

// implementation 'com.android.support:multidex:1.0.3'
    implementation("com.android.support:multidex:1.0.3")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    implementation ("com.airbnb.android:lottie:6.5.2")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")
    implementation ("com.google.firebase:firebase-config-ktx:21.0.1")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.runner)
    implementation(libs.androidx.espresso.core)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}