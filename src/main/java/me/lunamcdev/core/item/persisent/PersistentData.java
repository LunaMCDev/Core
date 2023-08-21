package me.lunamcdev.core.item.persisent;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;


@AllArgsConstructor
public abstract class PersistentData<T> {

	@Setter
	protected ItemStack item;


	protected ItemMeta getMeta() {
		return this.item.getItemMeta();
	}

	protected PersistentDataContainer getData() {
		return getMeta().getPersistentDataContainer();
	}


	public abstract T get(NamespacedKey key);

	public abstract void set(NamespacedKey key, T value);

	public abstract void add(NamespacedKey key, T value);


}
