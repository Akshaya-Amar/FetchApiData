plugins {
     alias(libs.plugins.android.application)
     alias(libs.plugins.kotlin.android)
     alias(libs.plugins.kotlin.parcelize)
     alias(libs.plugins.kotlin.kapt)
     alias(libs.plugins.hilt.android)
}

android {
     namespace = "com.amar.practicemvvmretrofit"
     compileSdk = 35

     defaultConfig {
          applicationId = "com.amar.practicemvvmretrofit"
          minSdk = 24
          targetSdk = 35
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

     viewBinding {
          enable = true
     }

     kotlinOptions {
          jvmTarget = "11"
     }
}

dependencies {
     implementation(libs.androidx.core.ktx)
     implementation(libs.androidx.appcompat)
     implementation(libs.material)
     implementation(libs.androidx.activity)
     implementation(libs.androidx.constraintlayout)
     implementation(libs.retrofit)
     implementation(libs.converter.gson)
     implementation(libs.androidx.lifecycle.viewmodel.ktx)
     implementation(libs.androidx.navigation.fragment.ktx)
     implementation(libs.androidx.navigation.ui.ktx)
     implementation(libs.hilt.android)
     implementation(libs.glide)
     kapt(libs.hilt.compiler)
     testImplementation(libs.junit)
     androidTestImplementation(libs.androidx.junit)
     androidTestImplementation(libs.androidx.espresso.core)
}