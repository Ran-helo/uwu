package io.github.ran.uwu.client;

import io.github.ran.uwu.client.config.UwuConfig;
import net.fabricmc.api.ClientModInitializer;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class UwUMod implements ClientModInitializer {
    public static String prevUwuifiedMessage = "\r";
    public static String prevMessage = "\r";

    @Override
    public void onInitializeClient() {
        UwuConfig.load();
    }
}
