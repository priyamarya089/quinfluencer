import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "org.quinfluencer"
version = "1.0-SNAPSHOT"

buildscript {

    val kotlinVersion = "1.8.0"
    val springBootVersion = "3.0.1"

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.bmuschko:gradle-docker-plugin:9.1.0")
    }
}

repositories {
    mavenCentral()
}

plugins {
    val springBootVersion = "3.0.1"
    val kotlinVersion = "1.8.0"
    kotlin("jvm") version kotlinVersion
    id("org.springframework.boot") version (springBootVersion)
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.noarg") version kotlinVersion
    id("com.bmuschko.docker-remote-api") version "9.1.0"
    id("com.patdouble.awsecr") version "0.7.0"
    id("org.sonarqube") version "4.2.1.3168"
    jacoco
    application
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-aop:3.0.1")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.jetbrains.exposed:exposed-spring-boot-starter:0.41.1")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.0.1")
    implementation("mysql:mysql-connector-java:8.0.31")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-joda")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.1")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("com.lastbrand.quinfluencer.ApplicationKt")
}

kotlin {
    jvmToolchain(17)
}