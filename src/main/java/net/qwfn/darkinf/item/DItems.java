package net.qwfn.darkinf.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.qwfn.darkinf.DarkInfection;

public class DItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(DarkInfection.MOD_ID);

    public static  final DeferredItem<Item> void_steel_ingot = (DeferredItem<Item>) ITEMS.register("void_steel_ingot",
            () -> new Item(new Item.Properties()));
    public static  final DeferredItem<Item> raw_void_steel = (DeferredItem<Item>) ITEMS.register("raw_void_steel",
            () -> new Item(new Item.Properties()));
    public static  final DeferredItem<Item> void_gem = (DeferredItem<Item>) ITEMS.register("void_gem",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
