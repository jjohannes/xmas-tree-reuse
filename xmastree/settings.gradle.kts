pluginManagement {
    includeBuild("gradle-build-logic")
    repositories.gradlePluginPortal()
    repositories.google()
}
dependencyResolutionManagement {
    repositories.maven("$rootDir/../santa-repo")
    repositories.google()
    repositories.mavenCentral()
}
include("tree-swing", "train-swing", "ornaments-swing", "lights-swing")
include("tree-android", "train-android", "ornaments-android", "lights-android")
include("tree-gif", "lights-gif")
