plugins {
    id("com.android.application")
}

android {
    compileSdkVersion(27)
    defaultConfig {
        applicationId = "com.null8fuffzehn.app"
        minSdkVersion(15)
        targetSdkVersion(27)
        versionCode = 1
        versionName = "1.0"
    }
}

configurations.all {
    attributes {
        attribute(Attribute.of("ui-framework", String::class.java), "android")
    }
}

dependencies {
    implementation(project(":null8fuffzehn-shared"))
}
