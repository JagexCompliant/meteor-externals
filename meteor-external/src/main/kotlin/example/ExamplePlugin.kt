package example


import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor


@PluginDescriptor(
    name = "Example1",
    description = "Example",
    enabledByDefault = false,
    external = true
)
open class ExamplePlugin : Plugin() {

    var config = configuration<ExampleConfig>()

    override fun onStart() {
        println("do something here")


    }

    override fun onStop() {
        println("do something here")

    }




}
