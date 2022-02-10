package works.hirosuke.hiroparkour.config.configs

import works.hirosuke.hiroparkour.MainData
import works.hirosuke.hiroparkour.config.Config
import works.hirosuke.hiroparkour.config.ConfigManager
import java.io.File

object Main: Config() {
    override var configFile: File = ConfigManager.config

    override fun init(temp: Boolean) {
        val yaml = load()
        val section = yaml.getConfigurationSection("main") ?: throw NullPointerException("main section not found in ${configFile.name}.")
        MainData.spawnLocation = section.getLocation("spawnLocation") ?: throw NullPointerException("spawnLocation config not found.")
    }
}