package works.hirosuke.hiroparkour

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class HiroParkour : JavaPlugin(), Listener {

    companion object {
        lateinit var plugin: JavaPlugin
    }

    init {
        plugin = this
    }

    override fun onEnable() {
        // クリアステージ数保存
        // スタートに戻る機能
        server.pluginManager.registerEvents(this, this)
    }

    override fun onDisable() {

    }

    @EventHandler
    fun join(e: PlayerJoinEvent) {

    }

    @EventHandler
    fun entityDamage(e: EntityDamageEvent) {
        if (e.entity is Player) e.damage = 0.0
    }
}