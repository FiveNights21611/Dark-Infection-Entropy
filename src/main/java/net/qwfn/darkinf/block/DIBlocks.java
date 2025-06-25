package net.qwfn.darkinf.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.qwfn.darkinf.DarkInfection;
import net.qwfn.darkinf.item.DItems;

import java.util.function.Supplier;

public class DIBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.createBlocks(DarkInfection.MOD_ID);


    public static final DeferredBlock<Block> void_steel_block = registerBlock("void_steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> raw_void_steel_block = registerBlock("raw_void_steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<Block> void_soil = registerBlock("void_soil",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).sound(SoundType.GRASS)));
    public static final DeferredBlock<Block> void_dirt = registerBlock("void_dirt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).sound(SoundType.ROOTED_DIRT)));
    public static final DeferredBlock<Block> void_stone = registerBlock("void_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> the_anomaly = registerBlock("the_anomaly",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(32767f).requiresCorrectToolForDrops().sound(SoundType.SCULK)));
    public static final DeferredBlock<Block> void_steel_ore = registerBlock("void_steel_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> void_gem_ore = registerBlock("void_gem_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> cobbled_void = registerBlock("cobbled_void",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = (DeferredBlock<T>) BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        DItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
