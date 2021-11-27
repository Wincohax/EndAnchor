package de.kxmischesdomi.just_end_anchor.common.registry;

import de.kxmischesdomi.just_end_anchor.EndAnchorMod;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * @author KxmischesDomi | https://github.com/kxmischesdomi
 * @since 1.0
 */
public class ModItems {

	public static Item END_ANCHOR = register(ModBlocks.END_ANCHOR, CreativeModeTab.TAB_DECORATIONS);

	public static void init() {}

	public static <T extends Item> T register(String name, T item) {
		Registry.register(Registry.ITEM, new ResourceLocation(EndAnchorMod.MOD_ID, name), item);
		return item;
	}

	private static BlockItem register(Block block, CreativeModeTab group) {
		return register(Registry.BLOCK.getKey(block).getPath(), new BlockItem(block, (new Item.Properties()).tab(group)));
	}

}
    