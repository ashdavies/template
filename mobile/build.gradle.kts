@file:Suppress("UnstableApiUsage")

import eu.appcom.gradle.VersioningExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("com.google.android.gms.oss-licenses-plugin")
    id("com.github.ben-manes.versions")
    id("eu.appcom.gradle.android-versioning")

    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")

    id("androidx.navigation.safeargs.kotlin")
}

android {
    buildFeatures {
        // compose = true
        viewBinding = true
    }

    setCompileSdkVersion(29)

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    defaultConfig {
        applicationId = "io.ashdavies.playground"

        setMinSdkVersion(21)
        setTargetSdkVersion(29)

        val versioning: VersioningExtension = extensions
            .getByName("versioning")
            .let { it as VersioningExtension }

        versionCode = versioning.getVersionCode()
        versionName = versioning.getVersionName()

        vectorDrawables.useSupportLibrary = true
    }

    sourceSets {
        getByName("main")
            .java
            .srcDirs("src/main/kotlin")

        getByName("test")
            .java
            .srcDirs("src/test/kotlin")
    }
}

androidExtensions {
    features = setOf("parcelize")
}

configurations {
    create("ktlint")
}

dependencies {
    implementation(project(":mobile-ktx"))

    implementation("androidx.activity:activity-ktx:1.2.0-alpha07")
    implementation("androidx.annotation:annotation:1.2.0-alpha01")
    implementation("androidx.appcompat:appcompat:1.3.0-alpha01")
    implementation("androidx.cardview:cardview:1.0.0")
    // implementation("androidx.compose:compose-compiler:0.1.0-dev14")
    // implementation("androidx.compose:compose-runtime:0.1.0-dev14")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta8")
    implementation("androidx.core:core-ktx:1.5.0-alpha01")
    // implementation("androidx.datastore:datastore-core:1.0.0-SNAPSHOT")
    implementation("androidx.fragment:fragment-ktx:1.3.0-alpha07")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.0-alpha06")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0-alpha06")
    implementation("androidx.paging:paging-runtime:3.0.0-alpha03")
    implementation("androidx.room:room-ktx:2.3.0-alpha02")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.0")
    implementation("androidx.recyclerview:recyclerview:1.2.0-alpha05")
    // implementation("androidx.ui:ui-animation:0.1.0-dev14")
    // implementation("androidx.ui:ui-foundation:0.1.0-dev14")
    // implementation("androidx.ui:ui-framework:0.1.0-dev14")
    // implementation("androidx.ui:ui-layout:0.1.0-dev14")
    // implementation("androidx.ui:ui-material:0.1.0-dev14")
    // implementation("androidx.ui:ui-tooling:0.1.0-dev14")

    implementation("com.dropbox.mobile.store:store4:4.0.0-alpha06")
    implementation("com.google.android.gms:play-services-oss-licenses:17.0.0")
    implementation("com.google.android.material:material:1.3.0-alpha02")
    implementation("com.google.firebase:firebase-common-ktx:19.3.0")
    implementation("com.google.firebase:firebase-analytics:17.4.4")
    implementation("com.google.firebase:firebase-firestore-ktx:21.5.0")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.3.8")

    kapt("androidx.room:room-compiler:2.3.0-alpha02")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.3")

    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.71")
    testImplementation("junit:junit:4.13")

    // ktlint("com.pinterest:ktlint:0.36.0")
}

tasks
    .withType<KotlinCompile>()
    .configureEach {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

/*task("ktlint") {
    description = "Check Kotlin code style."
    main = "com.pinterest.ktlint.Main"
    classpath = configurations.ktlint
    args "src/**/*.kt"
}

(type: JavaExec, group: "verification") {
    description = "Check Kotlin code style."
    main = "com.pinterest.ktlint.Main"
    classpath = configurations.ktlint
    args "src/**/*.kt"
}

check.dependsOn ktlint
    task ktlintFormat(type: JavaExec, group: "formatting") {
    description = "Fix Kotlin code style deviations."
    main = "com.pinterest.ktlint.Main"
    classpath = configurations.ktlint
    args "-F", "src/**/*.kt"
}*/

apply(plugin = "com.google.gms.google-services")
