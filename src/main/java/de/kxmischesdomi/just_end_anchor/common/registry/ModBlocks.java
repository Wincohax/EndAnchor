package de.kxmischesdomi.just_end_anchor.common.registry;

import de.kxmischesdomi.just_end_anchor.EndAnchorMod;
import de.kxmischesdomi.just_end_anchor.common.blocks.EndAnchorBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * @author KxmischesDomi | https://github.com/kxmischesdomi
 * @since 1.0
 */
public class ModBlocks {

	public static Block END_ANCHOR = register("end_anchor", new EndAnchorBlock(FabricBlockSettings.of(Material.STONE, MapColor.BLACK).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(50f, 1200.0F).luminance((state) -> EndAnchorBlock.getLightLevel(state, 15))));

	private static <T extends Block> T register(String name, T block) {
		Registry.register(Registry.BLOCK, new Identifier(EndAnchorMod.MOD_ID, name), block);
		return block;
	}

}
