plugins {
    kotlin("jvm") version "1.9.23"
}

val sdk_version: String by project

group = "cn.rtast"
version = sdk_version

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    val gson_version: String by project
    val jupiter_version: String by project

    implementation("com.google.code.gson:gson:$gson_version")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$jupiter_version")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jupiter_version")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from("LICENSE")
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.compileJava {
    options.compilerArgs.addAll(listOf("-source", "1.8", "-target", "1.8"))
}