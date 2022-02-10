package works.hirosuke.hiroparkour.config

import works.hirosuke.hiroparkour.config.configs.Main
import works.hirosuke.hiroparkour.HiroParkour.Companion.plugin
import java.io.File

object ConfigManager {
    val config = File(plugin.dataFolder, "config.yml")

    const val PATH_SEPARATOR: String = "."

    fun available(path: String, config: Config): Boolean {
        return config.get(path) != null
    }

    private fun getInstance(enumConfig: EnumConfig): Config {
        return when (enumConfig) {
            EnumConfig.ALL -> throw IllegalArgumentException("You can't get config type ALL.")
            EnumConfig.MAIN -> Main
        }
    }

    fun getInstanceByName(name: String): Config? {
        return try {
            getInstance(EnumConfig.valueOf(name.uppercase()))
        } catch (e: IllegalArgumentException) {
            null
        }
    }

    fun getAllInstance(): MutableList<Config> {
        val list = mutableListOf<Config>()
        EnumConfig.values().filter { it != EnumConfig.ALL }.forEach { list.add(getInstance(it)) }
        return list
    }

    fun init(enumConfig: EnumConfig, temp: Boolean = false) {
        when (enumConfig) {
            EnumConfig.ALL -> EnumConfig.values().filter { it != EnumConfig.ALL }.forEach { init(it, temp) }
            EnumConfig.MAIN -> Main.init(temp)
        }
    }
}