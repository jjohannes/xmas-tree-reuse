plugins {
    id("maven-publish")
}

if (isAndroid()) {
    apply(plugin = "com.android.library")
} else {
    apply(plugin = "java-library")
}

group = "com.santasoft.xmastree"
version = "2.0"

val platformSuffix = name.substring(name.lastIndexOf("-") + 1)

dependencies {
    if (!name.startsWith("tree-")) {
        add("api", "com.santasoft.xmastree:tree-$platformSuffix:$version")
    } else {
        constraints {
            listOf("lights", "ornaments", "train").forEach {
                add("api", "com.santasoft.xmastree:$it:$version")
            }
        }
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        if (isAndroid()) {
            afterEvaluate {
                from(components["all"])
            }
        } else {
            from(components["java"])
        }
    }
    repositories {
        maven("$rootDir/../santa-repo")
    }
}

fun Project.isAndroid() = name.endsWith("-android")
