import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform") version "1.6.21"
    id("com.android.library")
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    `maven-publish`
    signing
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

    val xcf = XCFramework(MODULE_NAME)
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

ktlint {
    version.set("0.43.0")
}

fun SigningExtension.whenRequired(block: () -> Boolean) {
    setRequired(block)
}

val javadocJar by tasks.creating(Jar::class) {
    archiveClassifier.value("javadoc")
}

publishing {
    val OPEN_SOURCE_REPO: String by project
    val PUBLISH_NAME: String by project
    val PUBLISH_DESCRIPTION: String by project
    val PUBLISH_URL: String by project
    val PUBLISH_DEVELOPER_ID: String by project
    val PUBLISH_DEVELOPER_NAME: String by project
    val PUBLISH_DEVELOPER_EMAIL: String by project
    val PUBLISH_SCM_URL: String by project
    val PUBLISH_SCM_CONNECTION: String by project
    val PUBLISH_SCM_DEVELOPERCONNECTION: String by project

    repositories {
        maven {
            url = uri(OPEN_SOURCE_REPO)

            credentials {
                username = System.getenv("sonatypeUsernameEnv")
                password = System.getenv("sonatypePasswordEnv")
            }
        }
    }

    publications.all {
        this as MavenPublication

        artifact(javadocJar)

        pom {
            name.set(PUBLISH_NAME)
            description.set(PUBLISH_DESCRIPTION)
            url.set(PUBLISH_URL)

            licenses {
                license {
                    name.set("MIT License")
                    url.set("http://opensource.org/licenses/MIT")
                }
            }

            developers {
                developer {
                    id.set(PUBLISH_DEVELOPER_ID)
                    name.set(PUBLISH_DEVELOPER_NAME)
                    email.set(PUBLISH_DEVELOPER_EMAIL)
                }
            }

            scm {
                url.set(PUBLISH_SCM_URL)
                connection.set(PUBLISH_SCM_CONNECTION)
                developerConnection.set(PUBLISH_SCM_DEVELOPERCONNECTION)
            }
        }
    }
}

signing {
    whenRequired { gradle.taskGraph.hasTask("publish") }
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications)
}
