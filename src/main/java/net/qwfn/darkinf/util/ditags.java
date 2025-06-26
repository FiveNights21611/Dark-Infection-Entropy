package net.qwfn.darkinf.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.qwfn.darkinf.DarkInfection;

public class ditags {
    public static class void_tags {
        public static  final TagKey<Block> void_soil = createTag( "void_soil");
        public static  final TagKey<Block> void_dirt = createTag( "void_dirt");
        public static  final TagKey<Block> void_stone = createTag( "void_stone");
        public static  final TagKey<Block> cobbled_void = createTag( "cobbled_void");
        public static  final TagKey<Block> void_steel_ore = createTag( "void_steel_ore");
        public static  final TagKey<Block> void_gem_ore = createTag( "void_gem_ore");



        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(DarkInfection.MOD_ID, name));
        }
    }
}
