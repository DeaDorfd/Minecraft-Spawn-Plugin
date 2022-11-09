package de.flugboy.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

/**
 * @Author Flugboy
 * @Project SpawnPlugin
 * @Package de.flugboy.utils
 * @Date 06.06.2022
 * @Time 18:38:22
 */
public class Config {

	public static File file = new File("plugins//Spawn//config.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

	public static void setSpawn(Player player) {
		File file = new File("plugins//Spawn//spawn.yml");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {}
		}
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		Location loc = player.getLocation();
		cfg.set("X", loc.getX());
		cfg.set("Y", loc.getY());
		cfg.set("Z", loc.getZ());
		cfg.set("Yaw", loc.getYaw());
		cfg.set("Pitch", loc.getPitch());
		cfg.set("WorldName", loc.getWorld().getName());
		try {
			cfg.save(file);
		} catch (IOException e) {}
	}

	public static void teleportSpawn(Player player) {
		File file = new File("plugins//Spawn//spawn.yml");
		if (!file.exists()) return;
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		World world = Bukkit.getWorld(cfg.getString("WorldName"));
		double yaw = cfg.getDouble("Yaw");
		double pitch = cfg.getDouble("Pitch");
		player.teleport(new Location(world, cfg.getDouble("X"), cfg.getDouble("Y"), cfg.getDouble("Z"), (float) yaw,
				(float) pitch));
	}

	public static boolean isSpawnSet() {
		return new File("plugins//Spawn//spawn.yml").exists();
	}

	public static String getString(String path) {
		return cfg.getString(path).replaceAll("&", "§");
	}
}