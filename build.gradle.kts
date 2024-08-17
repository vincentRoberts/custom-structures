import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.0"
    id("org.jetbrains.compose") version "1.6.0"
    id("org.jetbrains.dokka") version "1.8.20"
}

group = "ie.setu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")

    dependencies {
        implementation(compose.desktop.currentOs)
        implementation("org.jetbrains.compose.material3:material3-desktop:1.4.3")
        implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "sorting-searching-app"
            packageVersion = "1.0.0"
        }
    }
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
}
