import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin)
}

val sdkVersion: String by project

group = "cn.rtast"
version = sdkVersion

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(libs.gson)
    implementation(libs.okhttp)
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from("LICENSE")
}

tasks.compileKotlin {
    compilerOptions.jvmTarget = JvmTarget.JVM_11
}

tasks.compileJava {
    targetCompatibility = "11"
    sourceCompatibility = "11"
}