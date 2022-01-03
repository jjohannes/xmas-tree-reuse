plugins {
    `maven-publish`
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
    }
}

val publishVersion = "2.0"

subprojects {
    apply(plugin = "maven-publish")
    if (isAndroid()) {
        apply(plugin = "com.android.library")
    } else {
        apply(plugin = "java-library")
    }

    repositories {
        maven {
            setUrl("$rootDir/../santa-repo")
        }
        google()
        mavenCentral()
    }

    dependencies {
        val platformSuffix = if (isAndroid()) "android" else if (isGif()) "gif" else "swing"
        if (!name.startsWith("tree-")) {
            add("api", "com.santasoft.xmastree:tree-$platformSuffix:$publishVersion")
        } else {
            constraints {
                listOf("lights", "ornaments", "train").forEach {
                    add("api", "com.santasoft.xmastree:${it}:$publishVersion")
                }
            }

        }
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.santasoft.xmastree"
                artifactId = this@subprojects.name
                version = publishVersion
                if (isAndroid()) {
                    afterEvaluate {
                        from(components["all"])
                    }
                } else {
                    from(components["java"])
                }
            }
        }
        repositories {
            maven {
                url = uri("$rootDir/../santa-repo")
            }
        }
    }
}

fun Project.isAndroid() = name.endsWith("-android")
fun Project.isGif() = name.endsWith("-gif")
