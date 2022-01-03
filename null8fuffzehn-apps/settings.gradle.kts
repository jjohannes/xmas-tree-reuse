pluginManagement {
    repositories.gradlePluginPortal()
    repositories.google()
}
dependencyResolutionManagement {
    repositories.maven("$rootDir/../santa-repo")
    repositories.mavenCentral()
    repositories.google()
}

include("null8fuffzehn-shared")
include("null8fuffzehn-desktop", "null8fuffzehn-android", "null8fuffzehn-gif")
