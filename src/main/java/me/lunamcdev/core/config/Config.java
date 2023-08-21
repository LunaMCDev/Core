package me.lunamcdev.core.config;

import lombok.Getter;
import me.lunamcdev.core.plugin.BasePlugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Getter
public abstract class Config {

	private YamlConfiguration config;
	
	@Getter
	private File file;

	public void load(final String path) {
		BasePlugin.getInstance().saveResource(path, false);
		final File file = new File(BasePlugin.getInstance().getDataFolder(), path);
		this.file = file;
		this.config = YamlConfiguration.loadConfiguration(file);
		onLoad();
	}

	public abstract void onLoad();

	public void saveConfig(final String path) {
		try {
			this.config.save(new File(BasePlugin.getInstance().getDataFolder(), path));
		} catch (final IOException exception) {
			throw new RuntimeException(exception);
		}
	}

	public void save() {

		try {
			getConfig().save(getFile());
		} catch (final IOException ignored) {

		}
	}

	public String getString(final String path) {
		return getConfig().getString(path);
	}

	public int getInt(final String path) {
		return getConfig().getInt(path);
	}

	public boolean getBoolean(final String path) {
		return getConfig().getBoolean(path);
	}

	public float getFloat(final String path) {
		return (float) getDouble(path);
	}

	public double getDouble(final String path) {
		return getConfig().getDouble(path);
	}

	public List<String> getStringList(final String path) {
		return getConfig().getStringList(path);
	}

	public void set(final String path, final Object value) {
		getConfig().set(path, value);
	}
}
