package com.example.disablef3f4; // 改成你的包名

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

@Mod("disablef3f4") // 模组ID，可以改成你喜欢的名字
public class DisableF3F4 {
    public DisableF3F4() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = "disablef3f4", value = Dist.CLIENT)
    public static class KeyHandler {
        @SubscribeEvent
        public static void onKeyPress(InputEvent.Key event) {
            Minecraft mc = Minecraft.getInstance();
            if (mc.screen != null) return; // 如果有GUI界面（如背包），就不处理

            // 检查是否按下了 F3 + F4
            if (event.getKey() == GLFW.GLFW_KEY_F4 && (event.getModifiers() & GLFW.GLFW_MOD_F3) != 0) {
                event.setCanceled(true); // 阻止这个快捷键
            }
        }
    }
}