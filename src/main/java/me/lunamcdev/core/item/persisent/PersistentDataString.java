package me.lunamcdev.core.item.persisent;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PersistentDataString extends PersistentData<String> {

	public PersistentDataString(final ItemStack item) {
		super(item);
	}


	@Override
	public String get(final NamespacedKey key) {
		String value = "";
		if (this.item == null || !this.item.hasItemMeta()) return value;
		final PersistentDataContainer itemData = getData();
		if (itemData.has(key, PersistentDataType.STRING)) {
			value = itemData.get(key, PersistentDataType.STRING);
		}
		return value;

	}

	@Override
	public void set(final NamespacedKey key, final String value) {
		if (!this.item.hasItemMeta()) return;
		final ItemMeta meta = this.item.getItemMeta();
		final PersistentDataContainer itemData = meta.getPersistentDataContainer();
		itemData.set(key, PersistentDataType.STRING, value);
		this.item.setItemMeta(meta);
	}

	@Override
	public void add(final NamespacedKey key, final String value) {
		if (!this.item.hasItemMeta()) return;
		final ItemMeta meta = this.item.getItemMeta();
		final PersistentDataContainer itemData = meta.getPersistentDataContainer();
		if (!itemData.has(key, PersistentDataType.STRING)) return;
		final String finalValue = itemData.get(key, PersistentDataType.STRING) + value;
		set(key, finalValue);
		this.item.setItemMeta(meta);
	}

}
