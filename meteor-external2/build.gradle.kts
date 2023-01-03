
version = "1.0.0"

project.extra["PluginName"] = "Example Second"
project.extra["PluginDescription"] = "This is an example plugin"




tasks {

    jar {
        manifest {

            attributes(mapOf(
                "Plugin-Version" to project.version,
                "Plugin-Id" to nameToId(project.extra["PluginName"] as String),
                "Plugin-Description" to project.extra["PluginDescription"],
            )
            )

        }
    }
}
