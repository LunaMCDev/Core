package me.lunamcdev.core.plugin;

import lombok.Getter;
import me.lunamcdev.core.command.BaseCommand;
import me.lunamcdev.core.command.BaseCommandGroup;
import me.lunamcdev.core.command.CommandRegistry;
import me.lunamcdev.core.event.EventController;
import me.lunamcdev.core.menu.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;


public abstract class BasePlugin extends JavaPlugin {

	private static volatile BasePlugin instance;

	@Getter
	private static String version;

	@Getter
	private static String named;

	@Getter
	private static File source;
	@Getter
	private static File data;

	@Getter
	private static volatile boolean reloading = false;

	public static BasePlugin getInstance() {
		if (instance == null) {
			try {
				instance = JavaPlugin.getPlugin(BasePlugin.class);

			} catch (final IllegalStateException ex) {
				if (Bukkit.getPluginManager().getPlugin("PlugMan") != null)
					Bukkit.getLogger().severe("(!) Failed to get instance of the plugin, if you reloaded using PlugMan you need to do a complete server restart instead.");

				throw ex;
			}

			Objects.requireNonNull(instance, "(!) Cannot get a new instance!");
		}

		return instance;
	}

	public static boolean hasInstance() {
		return instance != null;
	}


	@Override
	public void onLoad() {
		try {
			getInstance();
		} catch (final Throwable throwable) {
			throwable.printStackTrace();
		}

		version = instance.getDescription().getVersion();
		named = instance.getDataFolder().getName();
		source = instance.getFile();
		data = instance.getDataFolder();

		onPluginLoad();
	}

	@Override
	public void onEnable() {
		onReloadAndStart();

		registerEvents(new MenuListener());

		onPluginStart();
	}

	@Override
	public void onDisable() {
		onPluginStop();
	}


	private void reload() {

		reloading = true;
		try {
			onPluginPreReload();

			onPluginReload();

			onReloadAndStart();


		} finally {
			reloading = false;
		}

	}

	protected final void registerEvents(final Listener listener) {
		EventController.registerEvent(listener);
	}

	protected final void registerCommand(final Command command) {
		if (command instanceof BaseCommand)
			((BaseCommand) command).register();

		else
			CommandRegistry.registerCommand(command);
	}

	protected final void registerCommands(final BaseCommandGroup group) {
		group.register();
	}

	protected void onPluginLoad() {
	}

	protected abstract void onPluginStart();

	protected void onPluginStop() {
	}

	protected void onPluginPreReload() {
	}

	protected void onPluginReload() {
	}

	protected void onReloadAndStart() {
	}
}
