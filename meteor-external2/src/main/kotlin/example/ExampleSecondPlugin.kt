package example


import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor


@PluginDescriptor(
    name = "Example2",
    description = "Example",
    enabledByDefault = false,
    external = true,
)
open class ExampleSecondPlugin : Plugin() {

    var config = configuration<ExampleSecondConfig>()

    override fun onStart() {

        println("do something here to")
    }


    override fun onStop() {
        println("do something else here")
    }


}
