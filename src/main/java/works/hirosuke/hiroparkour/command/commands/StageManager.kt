package works.hirosuke.hiroparkour.command.commands

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import works.hirosuke.hiroparkour.command.Command

class StageManager() : Command("stage") {
    override fun onCommand(sender: CommandSender, label: String, args: Array<out String>) {
        val err: String? = if (sender !is Player) {
            "Do not command from console."
        } else if (!sender.hasPermission("parkour.command.stage")) {
            "You don't have permission."
        } else if (args.isEmpty()) {
            "Arguments are empty."
        } else {
            null
        }

        if (err != null) {
            sender.sendMessage(err)
            return
        }

        when (args[0]) {
            "create" -> {

            }
        }
    }

    override fun onTabComplete(sender: CommandSender, label: String, args: Array<out String>): List<String> {
        return if (args.size == 1) {
            listOf("create", "unregister", "save", "load", "config")
        } else {
            when(args[0]) {
                else -> emptyList()
            }
        }
    }
}