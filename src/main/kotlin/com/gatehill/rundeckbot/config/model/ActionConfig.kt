package com.gatehill.rundeckbot.config.model

/**
 * Models an action in a configuration file.
 *
 * @author Pete Cornish {@literal <outofcoffee@gmail.com>}
 */
data class FileActionConfig(val jobId: String,
                        val options: OptionConfig?,
                        val template: String,
                        val tags: List<String>?) {

    lateinit var name: String
}

/**
 * Models an action configuration.
 *
 * @author Pete Cornish {@literal <outofcoffee@gmail.com>}
 */
data class ActionConfig(val name: String,
                        val jobId: String,
                        val options: OptionConfig,
                        val template: String,
                        val tags: List<String>)

/**
 * Convenience method to read an attribute from an ActionConfig.
 */
fun readActionConfigAttribute(actions: List<ActionConfig>, supplier: (ActionConfig) -> String): String {
    val names = StringBuilder()

    actions.forEach { action ->
        if (names.length > 0) names.append(", ")
        names.append(supplier(action))
    }

    return names.toString()
}