plugins {
    kotlin("jvm")
}

group = "partners"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":application:domain:product-domain"))
    implementation(project(":application:domain:account-domain"))
    implementation(project(":application:domain:category-domain"))
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
