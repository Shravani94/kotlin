import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "com.tech"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}
val ktor_version: String by project
val logback_version:String by project

dependencies {
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-client-content-negotiation-jvm:2.2.3")
    implementation("com.mysql:mysql-connector-j:8.0.31")
    implementation("me.liuwj.ktorm:ktorm-core:3.1.0")
    implementation ("io.ktor:ktor-serialization:$ktor_version")
    implementation ("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
}