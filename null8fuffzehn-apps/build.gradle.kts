buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0-alpha07")
    }
}

subprojects {
    repositories {
        maven {
            setUrl("$rootDir/../santa-repo")
        }
        jcenter()
        google()
    }
}