

version = "1.0"

val pluginName = "ExamplePlugin"

val pluginClass by rootProject.extra { "example.ExamplePlugin" }

tasks {

    jar {

        manifest {
            baseName = pluginName
            attributes["Main-Class"] = pluginClass
        }

    }

}