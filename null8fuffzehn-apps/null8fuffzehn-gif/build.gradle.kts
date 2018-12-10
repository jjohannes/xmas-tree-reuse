import org.gradle.kotlin.dsl.resolver.SourceDistributionResolver.Companion.artifactType

plugins {
    java
    application
}

application {
    mainClassName = "com.santasoft.xmastree.Tree"
}

val uiFramework = Attribute.of("ui-framework", String::class.java)
val uiArtifact = Attribute.of("ui-artifact", String::class.java)

configurations.all {
    attributes {
        attribute(uiFramework, "gif")
        attribute(uiArtifact, "imageJar")
    }
}

dependencies {
    implementation(project(":null8fuffzehn-shared"))

    components {
        withModule("com.santasoft.xmastree:train") {
            withVariant("swing-runtime") {
                attributes {
                    attribute(uiFramework, "gif")
                }
            }
        }
        withModule("com.santasoft.xmastree:ornaments") {
            withVariant("swing-runtime") {
                attributes {
                    attribute(uiFramework, "gif")
                }
            }
        }
    }

    artifactTypes.getByName("jar") {
        attributes.attribute(uiArtifact, "completeJar")
    }

    registerTransform {
        from.attribute(artifactType, "jar").attribute(uiArtifact, "completeJar")
        to.attribute(artifactType, "jar").attribute(uiArtifact, "imageJar")
        artifactTransform(Jar2ImageJar::class)
    }
}

class Jar2ImageJar : ArtifactTransform() {

    override fun transform(input: File) : List<File> {
        return if (input.name.contains("-swing")) {
            val output = File(outputDirectory, input.name.replace("-swing", "-gif"))
            input.copyTo(output) //TODO remove non-image files from jar
            listOf(output)
        } else {
            listOf(input)
        }
    }

}