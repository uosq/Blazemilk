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

@Mixin(BlazeEntity.class)
public class ExampleMixin extends MobEntity {
	protected ExampleMixin(EntityType<? extends MobEntity> entityType, World world) {
		super(entityType, world);
	}

	@Override
	public ActionResult interactMob(PlayerEntity player, Hand hand) {
		/* only run this in the server */
		if (!this.getWorld().isClient) {
			ItemStack stack = player.getStackInHand(hand);
			if (stack.isOf(Items.BUCKET) && !this.isBaby()) {
				// play sound
				this.playSound(SoundEvents.ENTITY_BLAZE_HURT, 1.0f, 1.0f);

				// give lava bucket instead of empty bucket
				ItemStack lavaBucket = ItemUsage.exchangeStack(stack, player, Items.LAVA_BUCKET.getDefaultStack());
				player.setStackInHand(hand, lavaBucket);

				return ActionResult.SUCCESS;
			}
		}

		return super.interactMob(player, hand);
	}
}