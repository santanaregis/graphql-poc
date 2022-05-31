import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "An example GraphQL Spring server"

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.spring") version "1.5.10"
    id("org.springframework.boot") version "2.5.5"
    id("com.expediagroup.graphql") version "5.1.1"
}

val springBootVersion: String = "2.5.5"
val reactorVersion: String = "3.4.9"

dependencies {
    implementation("com.expediagroup:graphql-kotlin-spring-server:5.4.1")
}
repositories {
    mavenCentral()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
