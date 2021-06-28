package com.mr_sword.dragonarmor.mixin;

import com.mr_sword.dragonarmor.util.MixinHooks;
import net.minecraft.network.ClientConnection;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class MixinPlayerManager {

    @Inject(at = @At("TAIL"), method = "onPlayerConnect")
    public void colytra$onPlayerConnect(ClientConnection connection, ServerPlayerEntity player,
                                        CallbackInfo cb) {
        MixinHooks.syncConfig(player);
    }
}
