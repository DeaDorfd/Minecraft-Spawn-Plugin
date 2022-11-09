package de.flugboy.main;

import org.bukkit.plugin.java.JavaPlugin;

import de.flugboy.commands.Spawn_CMD;

/**
 * @Author Flugboy
 * @Project SpawnPlugin
 * @Package de.flugboy.main
 * @Date 06.06.2022
 * @Time 15:52:14
 */
public class Spawn extends JavaPlugin {

	@Override
	public void onEnable() {
		getCommand("Spawn").setExecutor(new Spawn_CMD());
		getCommand("setSpawn").setExecutor(new Spawn_CMD());
		getDataFolder().mkdir();
		saveDefaultConfig();
	}

}
