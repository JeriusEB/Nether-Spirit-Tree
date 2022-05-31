package net.mcreator.netherspiritmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.BonemealEvent;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CharredBirchSaplingPlantRightClickedProcedure {
	@SubscribeEvent
	public static void onBonemeal(BonemealEvent event) {
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (Math.random() <= 0.3) {
			world.destroyBlock(new BlockPos(x, y, z), false);
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager()
						.getOrCreate(new ResourceLocation("nether_spirit_mod", "charredbirchtree"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x - 2, y, z - 2), new BlockPos(x - 2, y, z - 2),
							new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false),
							_serverworld.random, 3);
				}
			}
		}
	}
}
