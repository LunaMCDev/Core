package me.lunamcdev.core.item.persisent;


import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PersistentDataDouble extends PersistentData<Double> {

	public PersistentDataDouble(final ItemStack item) {
		super(item);
	}


	@Override
	public Double get(final NamespacedKey key) {
		double value = 0D;
		if (item == null || !item.hasItemMeta()) return value;
		final PersistentDataContainer itemData = getData();
		if (itemData.has(key, PersistentDataType.DOUBLE)) {
			value = itemData.get(key, PersistentDataType.DOUBLE);
		}
		return value;

	}

	@Override
	public void set(final NamespacedKey key, final Double value) {
		if (!item.hasItemMeta()) return;
		final ItemMeta meta = item.getItemMeta();
		final PersistentDataContainer itemData = meta.getPersistentDataContainer();
		itemData.set(key, PersistentDataType.DOUBLE, value);
		item.setItemMeta(meta);
	}

	@Override
	public void add(final NamespacedKey key, final Double value) {
		if (!item.hasItemMeta()) return;
		final ItemMeta meta = item.getItemMeta();
		final PersistentDataContainer itemData = meta.getPersistentDataContainer();
		if (!itemData.has(key, PersistentDataType.DOUBLE)) return;
		final double finalValue = itemData.get(key, PersistentDataType.DOUBLE) + value;
		set(key, finalValue);
		item.setItemMeta(meta);

	}

}
