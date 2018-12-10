plugins {
    java
    application
}

application {
    mainClassName = "com.null8fuffzehn.app.DesktopApp"
}

configurations.all {
    attributes {
        attribute(Attribute.of("ui-framework", String::class.java), "swing")
    }
}

dependencies {
    implementation(project(":null8fuffzehn-shared"))

    /*
    implementation("com.santasoft.xmastree:train:2.0")
    components {
        withModule("com.santasoft.xmastree:train") {
            allVariants {
                withDependencies {
                    removeAll { it.group == "com.santasoft.xmastree"}
                }
            }
        }
    }
    */
}
