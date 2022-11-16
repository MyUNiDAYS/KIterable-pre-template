import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform") version "1.6.21"
    id("com.android.library")
    id("io.github.luca992.multiplatform-swiftpackage") version "2.0.5-arm64"
//    kotlin("native.cocoapods") version "1.6.21"
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    `maven-publish`
}

val MODULE_PACKAGE_NAME: String by project
val MODULE_NAME: String by project
val MODULE_VERSION_NUMBER: String by project

group = MODULE_PACKAGE_NAME
version = MODULE_VERSION_NUMBER

repositories {
    google()
    mavenCentral()
}

kotlin {
    android {
        publishAllLibraryVariants()
    }

    val xcf = XCFramework()
    iosSimulatorArm64 {
        binaries.framework {
            baseName = MODULE_NAME
            xcf.add(this)
        }
    }
    ios {
        binaries.framework {
            baseName = MODULE_NAME
            xcf.add(this)
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val iosMain by getting {}
        val iosSimulatorArm64Main by getting
        iosSimulatorArm64Main.dependsOn(iosMain)
        val iosTest by getting
        val iosSimulatorArm64Test by getting
        iosSimulatorArm64Test.dependsOn(iosTest)

        val androidMain by getting {
            dependencies {
                implementation("com.iterable:iterableapi:3.4.9")
                implementation("com.iterable:iterableapi-ui:3.4.9")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
    }
}

ktlint {
    version.set("0.43.0")
}

android {
    compileSdk = 31 // we have to set to 31 due to multiplatform settings dependancy having this at 31
    buildToolsVersion = "30.0.3"
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 23
        targetSdk = 31
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

multiplatformSwiftPackage {
    packageName(MODULE_NAME)
    swiftToolsVersion("5.4")
    targetPlatforms {
        iOS { v("13") }
    }
}
