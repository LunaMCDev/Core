package me.lunamcdev.core.entity;

import lombok.experimental.UtilityClass;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

@UtilityClass
public class EntityUtil {

	public static String getName(final Entity entity) {
		try {
			return entity.getName();

		} catch (final NoSuchMethodError t) {
			return entity instanceof Player ? ((Player) entity).getName() : entity.getType().name();
		}
	}

}
