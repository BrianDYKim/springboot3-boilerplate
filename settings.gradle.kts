rootProject.name = "boilerplate"

pluginManagement {
    val kotlinVersion = "2.0.20"
    val springBootVersion = "3.3.3"
    val springDependencyManagementVersion = "1.1.5"

    val kLintVersion = "12.0.2"

    plugins {
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
        id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.noarg") version kotlinVersion
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.spring") version kotlinVersion
        kotlin("plugin.jpa") version kotlinVersion

        kotlin("kapt") version kotlinVersion

        // Kotlin Formatting
        id("org.jlleitschuh.gradle.ktlint") version kLintVersion
    }
}

// modules
include("common")
include("core", "core:domain")
include("application", "application:admin-api", "application:api", "application:batch")
