package navet.blazemilk.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;

import navet.blazemilk.Blazemilk;

@Mixin(BlazeEntity.class)
public class ExampleMixin extends MobEntity {
	protected ExampleMixin(EntityType<? extends MobEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		if (Blazemilk.interact(this, player, hand))
			return ActionResult.SUCCESS;
		return super.interactMob(player, hand);
	}
}