package net.qwfn.darkinf.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.qwfn.darkinf.block.DIBlocks;

import java.util.Map;

public class block_infection {

    public static final Map<Block , Block> Infection_MAP =
            Map.of(
                    Blocks.GRASS_BLOCK, DIBlocks.void_soil.get(),
                    Blocks.STONE, DIBlocks.void_stone.get(),
                    Blocks.DIRT, DIBlocks.void_dirt.get()

            );
    public static void block_infecting(BlockPos pos, Level level, int rand){
     Block infectingblock = level.getBlockState(pos).getBlock();



     if(Infection_MAP.containsKey(infectingblock)) {
          if(!level.isClientSide()) {
              rand = rand *=10;
              int rende = (int) (Math.random()*rand);
              if(rende <= 5){
                  level.setBlockAndUpdate(pos,Infection_MAP.get(infectingblock).defaultBlockState());
                  level.sendBlockUpdated(pos, level.getBlockState(pos),Infection_MAP.get(infectingblock).defaultBlockState(),1);
              }

          }
     }
     
    }
    public static void radius_infecting(int range, int hight, int fallof, BlockPos node_pos, Level level){

        for(int y = -hight; y <= hight; y++) {
            for(int x = -range; x <= range; x++) {
                for(int z = -range; z <= range; z++){



                    int rand = Math.addExact(Math.abs(x),Math.abs(z) );
                    if (rand < (range*1.5)){
                        if (hight > range){
                            rand = Math.addExact(rand, Math.divideExact(Math.abs(y), 2));
                        }else if (hight < range){
                            rand = Math.addExact(rand, Math.multiplyExact(Math.abs(y), 2));
                        }else {
                            rand = Math.addExact(rand, Math.abs(y));
                        }
                        rand = Math.divideExact(rand, (range-fallof));

                        BlockPos infect_pos = new BlockPos(node_pos.getX() + x, node_pos.getY() + y , node_pos.getZ() + z);
                        block_infecting(infect_pos, level, rand);
                    }


                }
            }
        }
    }
}
