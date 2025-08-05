package net.qwfn.darkinf.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.qwfn.darkinf.util.block_infection;

public class DarkOrb extends Item {
    public DarkOrb(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Block ClickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
       block_infection.radius_infecting(20, 10, 4,context.getClickedPos(),level);


        return super.useOn(context);
    }
}
