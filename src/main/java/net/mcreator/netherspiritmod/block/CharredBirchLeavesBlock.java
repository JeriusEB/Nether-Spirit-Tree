
package net.mcreator.netherspiritmod.block;

import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Containers;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.BiomeColors;

import net.mcreator.netherspiritmod.init.NetherSpiritModModBlocks;
import net.mcreator.netherspiritmod.block.entity.CharredBirchLeavesBlockEntity;

public class CharredBirchLeavesBlock extends LeavesBlock
		implements

			EntityBlock {
	public CharredBirchLeavesBlock() {
		super(BlockBehaviour.Properties.of(Material.LEAVES).sound(SoundType.GRASS).strength(0.2f).noOcclusion().randomTicks());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 1;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 30;
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CharredBirchLeavesBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof CharredBirchLeavesBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof CharredBirchLeavesBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(ColorHandlerEvent.Block event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor();
		}, NetherSpiritModModBlocks.CHARRED_BIRCH_LEAVES.get());
	}

	@OnlyIn(Dist.CLIENT)
	public static void itemColorLoad(ColorHandlerEvent.Item event) {
		event.getItemColors().register((stack, index) -> {
			return FoliageColor.getDefaultColor();
		}, NetherSpiritModModBlocks.CHARRED_BIRCH_LEAVES.get());
	}
}
