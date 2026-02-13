plugins {
    java
    kotlin("jvm") version "2.3.0"
    kotlin("plugin.serialization") version "2.3.0"
    `maven-publish`
}

group = "de.syncwork"
version = "0.0.12"

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

val ktorVersion = "3.4.0"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    // ktor
    implementation("io.ktor:ktor-client-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-java-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-auth-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-resources:$ktorVersion")
    implementation("io.ktor:ktor-client-logging-jvm:$ktorVersion")

    implementation("ch.qos.logback:logback-classic:1.5.25")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.6.4")

    testImplementation(kotlin("test"))
    testImplementation("io.ktor:ktor-client-mock:$ktorVersion")
    testImplementation("io.strikt:strikt-core:0.34.1")
    testImplementation("org.assertj:assertj-core:3.27.7")
    implementation(kotlin("reflect"))
}

tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = "hrworks-api-client-v2"
            version = project.version.toString()

            from(components["java"])
        }
    }
}
