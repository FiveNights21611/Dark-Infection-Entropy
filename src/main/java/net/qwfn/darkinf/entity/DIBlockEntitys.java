package net.qwfn.darkinf.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.qwfn.darkinf.DarkInfection;
import net.qwfn.darkinf.block.DIBlocks;

import java.util.function.Supplier;

public class DIBlockEntitys {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, DarkInfection.MOD_ID);

    public static final Supplier<BlockEntityType<VoidRootEntity>> void_root_be =
            BLOCK_ENTITIES.register("void_root_be", () -> BlockEntityType.Builder.of(
                    VoidRootEntity::new, DIBlocks.void_root.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
