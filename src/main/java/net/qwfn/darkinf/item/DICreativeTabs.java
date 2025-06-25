package net.qwfn.darkinf.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qwfn.darkinf.DarkInfection;
import net.qwfn.darkinf.block.DIBlocks;

import java.util.function.Supplier;

public class DICreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_tabs =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DarkInfection.MOD_ID);

    public static final Supplier<CreativeModeTab> infected_blocks_n_items =
            CREATIVE_MODE_tabs.register("infected_blocks_n_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DIBlocks.the_anomaly.get()))
                    .title(Component.translatable("creativetab.dark_infection.infected_blocks_n_items"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(DItems.void_steel_ingot.get());
                        pOutput.accept(DItems.raw_void_steel.get());
                        pOutput.accept(DItems.void_gem.get());
                        pOutput.accept(DIBlocks.void_steel_block.get());
                        pOutput.accept(DIBlocks.raw_void_steel_block.get());
                        pOutput.accept(DIBlocks.void_soil.get());
                        pOutput.accept(DIBlocks.void_dirt.get());
                        pOutput.accept(DIBlocks.void_stone.get());
                        pOutput.accept(DIBlocks.the_anomaly.get());
                        pOutput.accept(DIBlocks.void_gem_ore.get());
                        pOutput.accept(DIBlocks.void_steel_ore.get());
                        pOutput.accept(DIBlocks.cobbled_void.get());

                    }).build());


    public static void register(IEventBus eventBus) {

        CREATIVE_MODE_tabs.register(eventBus);
    }


}
