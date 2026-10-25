
plugins {
    id("java")
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "javafx.test.workspace"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

javafx {
    version = "25"
    modules = listOf("javafx.controls")
}

application {
    mainModule.set("javafx.test.workspace")
    mainClass.set("javafx.test.workspace.Main")

    applicationDefaultJvmArgs = listOf(
        "--enable-native-access=javafx.graphics"
    )
}

tasks.named<JavaExec>("run") {
    args("data=src/main/resources/mokepon.game")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.named<JavaExec>("run") {
    jvmArgs = listOf("--enable-native-access=javafx.graphics")
}