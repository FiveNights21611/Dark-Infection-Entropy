package net.qwfn.darkinf.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.qwfn.darkinf.entity.DIBlockEntitys;
import net.qwfn.darkinf.entity.VoidRootEntity;
import org.jetbrains.annotations.Nullable;

public class VoidRoot extends BaseEntityBlock {
    public static final MapCodec<VoidRoot> codec = simpleCodec(VoidRoot::new);


    public VoidRoot(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return codec;
    }



    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

   public static void test(){

   }



    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new VoidRootEntity(blockPos, blockState);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if(level.isClientSide){
            return null;
        }

        return createTickerHelper(blockEntityType, DIBlockEntitys.void_root_be.get(),
                (level1, blockpos, blockstate, blockEntity) -> blockEntity.tick(level1, blockpos, blockstate));
    }
}
