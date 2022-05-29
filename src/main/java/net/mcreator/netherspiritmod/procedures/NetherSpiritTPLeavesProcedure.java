package net.mcreator.netherspiritmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NetherSpiritTPLeavesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		boolean Found = false;
		double vy = 0;
		double ty = 0;
		double tx = 0;
		double tz = 0;
	}
}
