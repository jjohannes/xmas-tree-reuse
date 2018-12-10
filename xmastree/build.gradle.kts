plugins {
    `maven-publish`
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0-alpha07")
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
        jcenter()
    }

    dependencies {
        val platformSuffix = if (isAndroid()) "android" else "swing"
        if (!name.startsWith("tree-")) {
            add("api", "com.santasoft.xmastree:tree-$platformSuffix:$publishVersion")
        } else {
            constraints {
                rootProject.subprojects.forEach {
                    if (it != this@subprojects && it.name.endsWith(platformSuffix)) {
                        add("api", "com.santasoft.xmastree:${it.name}:$publishVersion")
                    }
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
                    artifact("$buildDir/outputs/aar/${this@subprojects.name}-release.aar")
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
