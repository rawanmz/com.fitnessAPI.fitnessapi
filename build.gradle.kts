val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val koinVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.7.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.7.10"
}

group = "com.fitnessAPI"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

//    val isDevelopment: Boolean = project.ext.has("development")
//    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}
//to deploy server
tasks.create("stage") {
    dependsOn("installDist")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("io.ktor:ktor-server-core:2.1.2")
    implementation("io.ktor:ktor-serialization-gson-jvm:2.1.2")
    implementation("io.ktor:ktor-server-netty:2.1.2")
    implementation("io.ktor:ktor-server-content-negotiation:2.1.2")
    implementation("ch.qos.logback:logback-classic:1.4.4")

//    implementation("io.ktor:ktor-server-call-logging:2.1.2")
    implementation("io.ktor:ktor-server-status-pages:2.1.2")
    implementation("io.ktor:ktor-server-default-headers:2.1.2")

    testImplementation("io.ktor:ktor-server-tests:2.1.2")
//    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")

    implementation("io.insert-koin:koin-ktor:3.2.2")
    implementation("io.insert-koin:koin-core:3.2.2")
    implementation("io.insert-koin:koin-logger-slf4j:3.2.2")




//    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")

    implementation("org.litote.kmongo:kmongo:4.7.1")
    implementation("org.litote.kmongo:kmongo-coroutine:4.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("io.ktor:ktor-client-core:2.1.2")
    implementation("it.skrape:skrapeit:1.2.2")

}