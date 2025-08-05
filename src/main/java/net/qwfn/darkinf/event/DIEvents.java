package net.qwfn.darkinf.event;

import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.qwfn.darkinf.DarkInfection;
import net.qwfn.darkinf.entity.VoidRootEntity;
import team.lodestar.lodestone.events.types.worldevent.WorldEventTickEvent;

@EventBusSubscriber(modid = DarkInfection.MOD_ID, bus = EventBusSubscriber.Bus.GAME)

public class DIEvents {
    public static int s;
    @SubscribeEvent
    public static void timer(ServerTickEvent.Post Event){
        s ++;
        if(s == 101){

            s = 0;
        }
    }
}
