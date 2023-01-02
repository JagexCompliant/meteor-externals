
version = "1.0"

val pluginClass by rootProject.extra { "example.ExampleSecondPlugin" }

val pluginName = "ExampleSecondPlugin"


tasks {

    jar {

        manifest {
            baseName = pluginName
            attributes["Main-Class"] = pluginClass
        }

    }

}