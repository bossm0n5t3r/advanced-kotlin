plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktlint)
}

group = "me.bossm0n5t3r"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.test)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.test)

    implementation(libs.junit.jupiter.api)

    implementation(libs.mockk)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(
        libs.versions.jdk.version
            .get()
            .toInt(),
    )
}

ktlint {
    version.set(
        libs.versions.ktlint.version
            .get(),
    )
}
