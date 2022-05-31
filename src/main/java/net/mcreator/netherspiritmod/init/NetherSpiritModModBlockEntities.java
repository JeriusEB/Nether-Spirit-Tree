
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.netherspiritmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.netherspiritmod.block.entity.CharredBirchLeavesBlockEntity;
import net.mcreator.netherspiritmod.NetherSpiritModMod;

public class NetherSpiritModModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
			NetherSpiritModMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> CHARRED_BIRCH_LEAVES = register("charred_birch_leaves",
			NetherSpiritModModBlocks.CHARRED_BIRCH_LEAVES, CharredBirchLeavesBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
