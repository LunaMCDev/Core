package me.lunamcdev.core.file;

import lombok.Getter;

import java.io.File;
import java.util.UUID;

@Getter
public class PlayerDataConfig extends YamlConfig {

	private final UUID uuid;


	public PlayerDataConfig(final UUID uuid) {
		this(uuid, "player-data");
	}

	public PlayerDataConfig(final UUID uuid, final String folderName) {
		super(folderName + File.separator + uuid.toString() + ".yml");
		this.uuid = uuid;
	}

}
