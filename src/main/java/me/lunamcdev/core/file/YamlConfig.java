package me.lunamcdev.core.file;

import lombok.Getter;
import me.lunamcdev.core.plugin.BasePlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;


@Getter
public abstract class YamlConfig {
	private final File file;
	protected FileConfiguration config;

	public YamlConfig(final String fileName) {
		final File dataFolder = BasePlugin.getData();
		if (!dataFolder.exists()) {
			dataFolder.mkdir();
		}
		this.file = new File(dataFolder, fileName);
		if (!file.exists()) {
			try {
				file.getParentFile().mkdir();
				file.createNewFile();
			} catch (final IOException e) {
				e.printStackTrace();
			}

		}
		this.config = YamlConfiguration.loadConfiguration(file);
	}

	public void save() {
		try {
			config.save(file);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}