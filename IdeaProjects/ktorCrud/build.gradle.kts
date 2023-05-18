val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.8.0"
    id("io.ktor.plugin") version "2.2.2"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}
dependencies {
    implementation ("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation ("io.ktor:ktor-server-tomcat-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation ("ch.qos.logback:logback-classic:$logback_version")
    testImplementation ("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation ("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    implementation("org.jetbrains.exposed:exposed-core:0.40.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.40.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.40.1")
    implementation("mysql:mysql-connector-java:8.0.31")
    implementation ("io.ktor:ktor-serialization:$ktor_version")
    implementation ("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation ("io.ktor:ktor-server-content-negotiation:$ktor_version")

}