// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    id("com.android.application") version "8.1.2" apply false
//}
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.application:com.android.application.gradle.plugin:8.1.2")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            url = uri("https://maven.google.com/")
            name = "Google"
            maven { url = uri("https://jitpack.io") }
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}