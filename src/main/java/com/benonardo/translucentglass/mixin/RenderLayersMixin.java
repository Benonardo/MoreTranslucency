package com.benonardo.translucentglass.mixin;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Debug(export = true)
@Mixin(RenderLayers.class)
public class RenderLayersMixin {

    @ModifyArg(method = "method_23685", at = @At(value = "INVOKE", target = "Ljava/util/HashMap;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", remap = false, ordinal = 0), slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;GLASS:Lnet/minecraft/block/Block;", opcode = Opcodes.GETSTATIC)), index = 1)
    private static Object makeGlassTranslucent(Object original) {
        return RenderLayer.getTranslucent();
    }

    @ModifyArg(method = "method_23685", at = @At(value = "INVOKE", target = "Ljava/util/HashMap;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", remap = false, ordinal = 0), slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;GLASS_PANE:Lnet/minecraft/block/Block;", opcode = Opcodes.GETSTATIC)), index = 1)
    private static Object makeGlassPaneTranslucent(Object original) {
        return RenderLayer.getTranslucent();
    }

}
