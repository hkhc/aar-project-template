/*
 * Copyright (c) 2020. Herman Cheung
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

// Top-level build file where you can add configuration options common to all sub-projects/modules.



buildscript {

//    ext {
//
//        /* Platform and gradle plugin version */
//        kotlin_version = "1.3.61"
//        detekt_version = "1.3.1"
//        dokka_version = "0.10.1"
//
//        junit_version = "4.12"
//        coretesting_version = "2.1.0"
//
//        dagger_version = "2.25.4"
//        retrofit_version = "2.7.0"
//        okhttp_version = "3.14.4"
//
//        corektx_version = "1.1.0"
//        appcompat_version = "1.1.0"
//        lifecycle_version = "2.2.0"
//        constraintLayout_version = "2.0.0-beta4"
//        swiperefreshlayout_version = "1.0.0"
//        material_design_version = "1.1.0-rc02"
//        gson_version = "2.8.5"
//
//        rxjava_version = "2.2.16"
//        rxkotlin_version = "2.4.0"
//        rxandroid_version = "2.1.1"
//
//        lottie_version = "3.3.1"
//        jsonapi_converter_version = "0.10"
//
//        mockk_version = "1.9.3"
//        assertj_version = "3.11.1"
//        testing_core_version = "1.1.0"
//        arch_coretesting_version = "2.1.0"
//
//
//    }


//    ext.kotlin_version = "1.3.21"
//    ext.dokka_version = "0.9.17"
    repositories {
        mavenCentral()
        jcenter()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.71")
    }

}

plugins {
    id("io.hkhc.simplepublisher")  version "0.4.1"
    id("org.jlleitschuh.gradle.ktlint") version "9.2.1"
    id("io.gitlab.arturbosch.detekt") version "1.5.1"
    // for build script debugging
    id("com.dorongold.task-tree") version "1.5"
}

//group = "io.hkhc"
//version = "0.1"

subprojects {

    repositories {
        mavenCentral()
        jcenter()
        google()
    }

}

