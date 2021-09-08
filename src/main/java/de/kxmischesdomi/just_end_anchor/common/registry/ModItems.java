package de.kxmischesdomi.just_end_anchor.common.registry;

import de.kxmischesdomi.just_end_anchor.EndAnchorMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * @author KxmischesDomi | https://github.com/kxmischesdomi
 * @since 1.0
 */
public class ModItems {

	public static Item END_ANCHOR = register(ModBlocks.END_ANCHOR, ItemGroup.DECORATIONS);

	public static void init() {}

	public static <T extends Item> T register(String name, T item) {
		Registry.register(Registry.ITEM, new Identifier(EndAnchorMod.MOD_ID, name), item);
		return item;
	}

	private static BlockItem register(Block block, ItemGroup group) {
		return register(Registry.BLOCK.getId(block).getPath(), new BlockItem(block, (new Item.Settings()).group(group)));
	}

}
    