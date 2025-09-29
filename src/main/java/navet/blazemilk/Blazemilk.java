package navet.blazemilk;

import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Blazemilk implements ModInitializer {
	public static final String MOD_ID = "blazemilk";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static boolean interact(MobEntity blaze, PlayerEntity player, Hand hand) {
		if (blaze.getWorld().isClient) {
			return false; // only run logic on the server
		}

		ItemStack stack = player.getStackInHand(hand);
		if (stack.isOf(Items.BUCKET) && !blaze.isBaby()) {
			// play sound
			blaze.playSound(SoundEvents.ENTITY_BLAZE_HURT, 1.0f, 1.0f);

			// give lava bucket instead of empty bucket
			ItemStack lavaBucket = ItemUsage.exchangeStack(stack, player, Items.LAVA_BUCKET.getDefaultStack());
			player.setStackInHand(hand, lavaBucket);

			return true; // signal successful interaction
		}
		return false;
	}

	@Override
	public void onInitialize() {
		LOGGER.info("Blazemilk loaded!");
	}
}