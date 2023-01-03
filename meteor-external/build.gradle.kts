

version = "1.0.3"

project.extra["PluginName"] = "Example Plugin"
project.extra["PluginDescription"] = "This is an example plugin"
repositories{
    mavenCentral()
}

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
