plugins {
    id("java")
}

val gifsToMerge = tasks.register("gifsToMerge") {
    doLast {
        println(configurations.runtimeClasspath.get().files.joinToString { it.name })
    }
}
tasks.build {
    dependsOn(gifsToMerge)
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

    registerTransform(Jar2ImageJar::class) {
        from.attribute(ArtifactTypeDefinition.ARTIFACT_TYPE_ATTRIBUTE, "jar").attribute(uiArtifact, "completeJar")
        to.attribute(ArtifactTypeDefinition.ARTIFACT_TYPE_ATTRIBUTE, "jar").attribute(uiArtifact, "imageJar")
    }
}

abstract class Jar2ImageJar : TransformAction<TransformParameters.None> {

    @get:InputArtifact
    abstract val inputArtifact: Provider<FileSystemLocation>

    override fun transform(outputs: TransformOutputs) {
        val inputFile = inputArtifact.get().asFile
        if (inputFile.name.contains("-swing")) {
            val output = outputs.file(inputFile.name.replace("-swing", "-gif"))
            inputFile.copyTo(output) //TODO remove non-image files from jar
        } else {
            outputs.file(inputFile)
        }
    }

}