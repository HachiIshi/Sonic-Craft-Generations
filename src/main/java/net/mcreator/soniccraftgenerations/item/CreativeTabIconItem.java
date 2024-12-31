
package net.mcreator.soniccraftgenerations.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CreativeTabIconItem extends Item {
	public CreativeTabIconItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
