package de.tobi1craft.repairswapper.mixin;

import de.tobi1craft.repairswapper.RepairSwapperClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ExperienceOrb.class)
public class ExperienceOrbMixin {

    @Inject(at = @At("HEAD"), method = "playerTouch")
    private void swapRepairable(Player playerEntity, CallbackInfo ci) {
        if (!(playerEntity instanceof LocalPlayer)) {
            return;
        }
        RepairSwapperClient.enable(Minecraft.getInstance(), true);
    }
}