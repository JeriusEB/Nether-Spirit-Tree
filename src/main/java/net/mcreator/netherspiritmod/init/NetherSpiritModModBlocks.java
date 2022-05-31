
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.netherspiritmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.netherspiritmod.block.StrippedCharredBirchLogBlock;
import net.mcreator.netherspiritmod.block.CharredBirchLogBlock;
import net.mcreator.netherspiritmod.block.CharredBirchLeavesBlock;
import net.mcreator.netherspiritmod.NetherSpiritModMod;

public class NetherSpiritModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, NetherSpiritModMod.MODID);
	public static final RegistryObject<Block> STRIPPED_CHARRED_BIRCH_LOG = REGISTRY.register("stripped_charred_birch_log",
			() -> new StrippedCharredBirchLogBlock());
	public static final RegistryObject<Block> CHARRED_BIRCH_LEAVES = REGISTRY.register("charred_birch_leaves", () -> new CharredBirchLeavesBlock());
	public static final RegistryObject<Block> CHARRED_BIRCH_LOG = REGISTRY.register("charred_birch_log", () -> new CharredBirchLogBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
		}

		@SubscribeEvent
		public static void blockColorLoad(ColorHandlerEvent.Block event) {
			CharredBirchLeavesBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(ColorHandlerEvent.Item event) {
			CharredBirchLeavesBlock.itemColorLoad(event);
		}
	}
}
