package net.qwfn.darkinf.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.TickingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.qwfn.darkinf.event.DIEvents;
import net.qwfn.darkinf.util.block_infection;

import static net.qwfn.darkinf.event.DIEvents.s;

public class VoidRootEntity extends BlockEntity {

    public void tick(Level level, BlockPos blockpos, BlockState blockstate) {

        if(s == 100){
            block_infection.radius_infecting(20, 10, 4,blockpos,level);
        }

    }

    public VoidRootEntity(BlockPos pos, BlockState blockState) {
        super(DIBlockEntitys.void_root_be.get(), pos, blockState);
    }
}
