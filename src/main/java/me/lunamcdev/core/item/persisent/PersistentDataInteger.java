package me.lunamcdev.core.item.persisent;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PersistentDataInteger extends PersistentData<Integer> {

	public PersistentDataInteger(final ItemStack item) {
		super(item);
	}


	@Override
	public Integer get(final NamespacedKey key) {
		int value = 0;
		if (item == null || !item.hasItemMeta()) return value;
		final PersistentDataContainer itemData = getData();
		if (itemData.has(key, PersistentDataType.INTEGER)) {
			value = itemData.get(key, PersistentDataType.INTEGER);
		}
		return value;

	}

	@Override
	public void set(final NamespacedKey key, final Integer value) {
		if (!item.hasItemMeta()) return;
		final ItemMeta meta = item.getItemMeta();
		final PersistentDataContainer itemData = meta.getPersistentDataContainer();
		itemData.set(key, PersistentDataType.INTEGER, value);
		item.setItemMeta(meta);
	}

	@Override
	public void add(final NamespacedKey key, final Integer value) {
		if (!item.hasItemMeta()) return;
		final ItemMeta meta = item.getItemMeta();
		final PersistentDataContainer itemData = meta.getPersistentDataContainer();
		if (!itemData.has(key, PersistentDataType.INTEGER)) return;
		final int finalValue = itemData.get(key, PersistentDataType.INTEGER) + value;
		set(key, finalValue);
		item.setItemMeta(meta);

	}

}
