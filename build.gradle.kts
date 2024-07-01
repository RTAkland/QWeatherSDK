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
    testImplementation(libs.jupiterEngine)
    testImplementation(libs.jupiterApi)
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from("LICENSE")
}

tasks.compileKotlin {
    compilerOptions.jvmTarget = JvmTarget.JVM_1_8
}

tasks.compileJava {
    targetCompatibility = "1.8"
    sourceCompatibility = "1.8"
}