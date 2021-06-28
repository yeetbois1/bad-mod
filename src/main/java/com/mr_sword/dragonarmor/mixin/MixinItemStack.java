package com.mr_sword.dragonarmor.mixin;


import com.mr_sword.dragonarmor.util.MixinHooks;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public class MixinItemStack {

    @SuppressWarnings("ConstantConditions")
    @Inject(at = @At("RETURN"), method = "getTooltip", cancellable = true)
    public void colytra$getTooltip(CallbackInfoReturnable<List<Text>> cb) {
        MixinHooks.appendColytraTooltip((ItemStack) (Object) this, cb.getReturnValue());
    }
}
