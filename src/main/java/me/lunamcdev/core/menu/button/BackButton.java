package me.lunamcdev.core.menu.button;

import me.lunamcdev.core.item.Item;
import me.lunamcdev.core.menu.Menu;
import me.lunamcdev.core.menu.MenuClick;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BackButton extends Button {

	@Override
	public ItemStack getItem() {
		return new Item(Material.OAK_DOOR).name("&6&lGo Back").create();
	}

	@Override
	public void onMenuClick(final MenuClick click) {
		final Player player = click.getPlayer();
		final Menu menu = Menu.getPreviousMenu(player);
		if (menu != null)
			menu.open(player);
		else
			player.closeInventory();
	}


}
