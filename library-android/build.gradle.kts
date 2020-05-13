/*
 * Copyright (c) 2019. Herman Cheung
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

group = "io.hkhc"
version = "0.1"

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    // "io.hkhc.simplepublisher" must be after "com.android.library"
    // so that libraryVariants is configured before simplePublisher
    id("io.hkhc.simplepublisher")
    id("digital.wup.android-maven-publish") version "3.6.2"
    id("org.jlleitschuh.gradle.ktlint") 
    id("io.gitlab.arturbosch.detekt") 
    // for build script debugging
    id("com.dorongold.task-tree")
}

tasks {
    dokka {
        outputFormat = "html"
        outputDirectory = "$buildDir/dokka"
        // set true to omit intra-project dependencies
        disableAutoconfiguration = true
    }
}


android {
    compileSdkVersion(28)

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    testOptions {
        with(unitTests) {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }

}

android.libraryVariants.configureEach {
    val variantName = name

    if (variantName == "release") {
        simplyPublish {
            useGpg = true
            variant = variantName
            pubComponent = "android"
            sourcesPath = files(javaCompileProvider.get().source)
        }
    }
}

dependencies {

    implementation(kotlin("stdlib-jdk8", "1.3.71"))

    testImplementation("junit:junit:4.13")
    testImplementation("org.assertj:assertj-core:3.12.2")
    testImplementation("org.robolectric:robolectric:4.1")
    testImplementation("io.mockk:mockk:1.9.3")
}
