
version = "1.0.9"

project.extra["PluginName"] = "ExampleSecond"
project.extra["PluginDescription"] = "This is an example plugin"

val pluginClass by rootProject.extra { "example.ExampleSecondPlugin" }



tasks {
    jar {
        manifest {
            attributes(mapOf(
                "Main-Class" to pluginClass,
                "Plugin-Version" to project.version,
                "Plugin-Id" to nameToId(project.extra["PluginName"] as String),
                "Plugin-Description" to project.extra["PluginDescription"],
            ))
        }
    }
}
