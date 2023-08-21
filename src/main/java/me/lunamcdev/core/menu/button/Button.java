package me.lunamcdev.core.menu.button;

import me.lunamcdev.core.menu.MenuClick;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class Button {

	abstract public ItemStack getItem();

	abstract public void onMenuClick(MenuClick click);


	public boolean isNullOrAir() {
		return getItem() == null || getItem().getType() == Material.AIR;
	}

}
