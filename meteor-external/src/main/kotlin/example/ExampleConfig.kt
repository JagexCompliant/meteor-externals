/*
 * Copyright (c) 2019-2020, ganom <https://github.com/Ganom>
 * All rights reserved.
 * Licensed under GPL3, see LICENSE for the full scope.
 */
package example


import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup(value = "Examples")
interface ExampleConfig : Config {

    @ConfigItem(
        keyName = "Example",
        name = "Example",
        description = "",
        position = 0,

    )
    fun example(): String {
        return "Something"
    }



}