package me.lunamcdev.core.menu;

import me.lunamcdev.core.menu.button.Button;
import org.bukkit.entity.Player;


public interface IMenu {

	void open(Player player);

	void onButtonClick(Button button, MenuClick click);

	void onMenuClick(MenuClick click);

}
