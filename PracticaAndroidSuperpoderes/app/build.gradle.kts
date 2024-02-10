plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android") // error: "Plugin [id: 'com.google.dagger.hilt.android'] was not found in any of the following sources:"
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs")
    kotlin ("kapt")
}

android {
    namespace = "com.gabrielcastro.practicaandroidsuperpoderes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.gabrielcastro.practicaandroidsuperpoderes"
        minSdk = 24
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation ("androidx.compose.material:material:1.4.3") // for rememberScaffoldState
    implementation ("androidx.compose.material:material-icons-extended:1.4.3")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha05") // to use viewModel function in favorite
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1") // added last

    implementation ("com.google.code.gson:gson:2.10.1")

    // Networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
    implementation("com.squareup.retrofit2:converter-scalars:2.1.0") // use for login
//    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshi_version") // https://stackoverflow.com/questions/73058197/convert-string-to-object-using-moshi
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.3' // not in class example")

    // Room
    implementation("androidx.room:room-runtime:2.5.1") // fm class
    implementation("androidx.room:room-ktx:2.5.1")
    testImplementation ("org.junit.jupiter:junit-jupiter")// fm class
    kapt("androidx.room:room-compiler:2.5.1") // fm class
    //    annotationProcessor 'androidx.room:room-compiler:2.5.1'

    // Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.45")
    kapt ("com.google.dagger:hilt-compiler:2.45")
    implementation ("androidx.compose.runtime:runtime-livedata:1.4.3")

    implementation ("androidx.navigation:navigation-compose:2.5.3")

    // Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Test
    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.13.5")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    testImplementation("com.google.truth:truth:1.0") //Alternativa: HAMCREST
    testImplementation("com.squareup.okhttp3:mockwebserver:4.2.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    testImplementation ("org.mockito:mockito-core:3.11.2")
    testImplementation ("org.mockito:mockito-inline:3.12.4")
}