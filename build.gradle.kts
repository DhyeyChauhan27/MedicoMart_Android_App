plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.medicomart"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.medicomart"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures{
        viewBinding = true
    }
}


dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.database)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.lottie)

    implementation(libs.firebase.ui.database)
    implementation(libs.circleimageview)
    implementation(libs.glide)

    //implementation "de.hdodenhof:circleimageview:3.1.0";
    implementation(libs.picasso)
    implementation("com.airbnb.android:lottie:6.1.0")
    implementation("com.firebaseui:firebase-ui-database:8.0.2")
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.squareup.picasso:picasso:2.8")

    //QR Generator
    implementation(libs.qrgenerator.v105)
    implementation ("com.github.androidmads:QRGenerator:1.0.1")
    
}