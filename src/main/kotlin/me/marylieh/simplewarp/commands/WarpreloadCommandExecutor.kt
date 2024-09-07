package me.marylieh.simplewarp.commands

import me.marylieh.simplewarp.SimpleWarp
import me.marylieh.simplewarp.utils.Config
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class WarpreloadCommandExecutor : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("${SimpleWarp.instance.prefix} §4Just a Player can execute this command!")
            return true
        }
        val player: Player = sender

        if (!(player.hasPermission("simplewarp.warpreload"))) {
            player.sendMessage("${SimpleWarp.instance.prefix} §cYou don't have the permission to do that!")
            return true
        }

        if (args.isNotEmpty()) {
            player.sendMessage("${SimpleWarp.instance.prefix} §cPlease use: §7/warpreload")
            return true
        }

        if (Config.getConfig().getBoolean("AllowConfigReload")) {
            Config.reload()
            player.sendMessage("${SimpleWarp.instance.prefix} §aThe config has been reloaded.")
            return true
        }
        player.sendMessage("${SimpleWarp.instance.prefix} §4The config reload has been globally disabled.")
        return true
    }
}