package net.qwfn.darkinf.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.qwfn.darkinf.block.DIBlocks;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class block_infection {
    public static final Map<Block , Block> Infection_MAP =
            Map.of(
                    Blocks.GRASS_BLOCK, DIBlocks.void_soil.get(),
                    Blocks.STONE, DIBlocks.void_stone.get(),
                    Blocks.DIRT, DIBlocks.void_dirt.get()

            );
    public static void block_infecting(BlockPos pos, UseOnContext context){
     Level level = context.getLevel();
     Block infectingblock = level.getBlockState(pos).getBlock();



     if(Infection_MAP.containsKey(infectingblock)) {
          if(!level.isClientSide()) {
              level.setBlockAndUpdate(pos,Infection_MAP.get(infectingblock).defaultBlockState());
              level.sendBlockUpdated(pos, level.getBlockState(pos),Infection_MAP.get(infectingblock).defaultBlockState(),1);
          }
     }
     
    }
    public static void radius_infecting(int range, int hight, int fallof, BlockPos node_pos, UseOnContext context){
        for(int x = -range; x <= range; x++) {
            for(int y = -range; y <= range; y++) {
                BlockPos infect_pos = new BlockPos(node_pos.getX() + x, node_pos.getY() + 0 , node_pos.getZ() + y);
                block_infecting(infect_pos, context);
            }
        }
    }
}
