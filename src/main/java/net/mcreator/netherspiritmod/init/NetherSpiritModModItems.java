
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.netherspiritmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.netherspiritmod.NetherSpiritModMod;

public class NetherSpiritModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, NetherSpiritModMod.MODID);
	public static final RegistryObject<Item> STRIPPED_CHARRED_BIRCH_LOG = block(NetherSpiritModModBlocks.STRIPPED_CHARRED_BIRCH_LOG,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CHARRED_BIRCH_LEAVES = block(NetherSpiritModModBlocks.CHARRED_BIRCH_LEAVES,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CHARRED_BIRCH_LOG = block(NetherSpiritModModBlocks.CHARRED_BIRCH_LOG,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CHARRED_BIRCH_SAPLING = block(NetherSpiritModModBlocks.CHARRED_BIRCH_SAPLING,
			CreativeModeTab.TAB_DECORATIONS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
