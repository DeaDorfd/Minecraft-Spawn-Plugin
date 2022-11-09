package de.flugboy.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.flugboy.utils.Config;

/**
 * @Author Flugboy
 * @Project SpawnPlugin
 * @Package de.flugboy.commands
 * @Date 06.06.2022
 * @Time 18:32:27
 */
public class Spawn_CMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (label.equalsIgnoreCase("spawn")) {
				if (Config.isSpawnSet()) {
					player.sendMessage(Config.getString("Prefix") + Config.getString("Messages.SpawnTeleport"));
					Config.teleportSpawn(player);
				} else {
					player.sendMessage(Config.getString("Prefix") + Config.getString("Messages.SpawnNotSet"));
				}
			} else if (label.equalsIgnoreCase("setspawn")) {
				if (player.hasPermission(Config.getString("Permission.SetSpawn"))) {
					player.sendMessage(Config.getString("Prefix") + Config.getString("Messages.SpawnSet"));
					Config.setSpawn(player);
				} else {
					player.sendMessage(Config.getString("Prefix") + Config.getString("Messages.NoPermission"));
					return true;
				}
			}
		}
		return false;
	}
}