plugins {
    id("com.android.application") version "7.0.4"
}

android {
    compileSdk = 27
    defaultConfig {
        applicationId = "com.null8fuffzehn.app"
        minSdk = 15
        targetSdk = 27
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
