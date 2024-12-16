import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin)
    id("maven-publish")
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

val sourceJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

artifacts {
    archives(sourceJar)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifact(sourceJar)
            artifactId = "qweathersdk"
        }
    }

    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/RTAkland/QWeatherSDK")
            credentials {
                username = "RTAkland"
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}