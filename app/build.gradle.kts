plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

// Apply external script
apply(from = "$rootDir/config/version.gradle.kts")

android {
    namespace = "com.example.fintrack"
    compileSdk = extra["newCompileSdk"] as Int

    defaultConfig {
        applicationId = "com.example.fintrack"
        minSdk = extra["newMinSdk"] as Int
        targetSdk = extra["newTargetSdk"] as Int
        versionCode = extra["verCode"] as Int
        versionName = extra["verName"] as String
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        signingConfig = signingConfigs.getByName("debug")
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
        sourceCompatibility = extra["compileVersion"] as JavaVersion
        targetCompatibility = extra["compileVersion"] as JavaVersion
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

val extraProperties = extra

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.1")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose")

    //resp scrn size
    implementation ("com.intuit.ssp:ssp-android:${extraProperties["ssp"] as String}")
    implementation ("com.intuit.sdp:sdp-android:${extraProperties["sdp"] as String}")

    //Dagger - Hilt
    implementation ("com.google.dagger:hilt-android:${extraProperties["hilt"] as String}")
    kapt ("com.google.dagger:hilt-android-compiler:${extraProperties["hilt"] as String}")
    kapt ("androidx.hilt:hilt-compiler:${extraProperties["hilt_navigation_compose"] as String}")
    implementation ("androidx.hilt:hilt-navigation-compose:${extraProperties["hilt_navigation_compose"] as String}")

    //for charts
    implementation("com.patrykandpatrick.vico:compose-m3:${extraProperties["vico"] as String}")

    //app center
    implementation ("com.microsoft.appcenter:appcenter-analytics:${extraProperties["appCenterSdkVersion"]}")
    implementation ("com.microsoft.appcenter:appcenter-crashes:${extraProperties["appCenterSdkVersion"]}")

    //.env
    implementation("io.github.cdimascio:dotenv-kotlin:${extraProperties["dotenv"]}")


}