package io.github.ran.uwu.client.config;

import gg.essential.vigilance.Vigilance;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import net.minecraft.client.MinecraftClient;

import java.io.File;
import java.io.IOException;

public class UwuConfig extends Vigilant {
    @Property(
            type = PropertyType.SWITCH,
            name = "Uwuify Outgoing Messages",
            description = "i-it uwuifies youw messages! >_<",
            category = "uwu"
    )
    public static boolean uwuifyOutgoing = true;
    @Property(
            type = PropertyType.SWITCH,
            name = "Uwuify Incoming Messages",
            description = "i-it uwuifies othew pwayew messages!",
            category = "uwu"
    )
    public static boolean uwuifyIncoming = false;
    @Property(
            type = PropertyType.SWITCH,
            name = "Uwuify Minecraft",
            description = "i-it uwuifies the minyecwaft cwient! >_<",
            category = "uwu"
    )
    public static boolean uwuifyMinecraft = true;

    public static boolean isLoaded = false;

    public static UwuConfig INSTANCE;

    public static void load() {
        if (isLoaded) return;
        Vigilance.initialize();
        try {
            INSTANCE = new UwuConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public UwuConfig() throws IOException {
        super(configFile(), "uwu");
        initialize();

        // Sometimes the config doesn't save properly, so we force it to save
        registerListener("uwuifyOutgoing", this::forceSaveConfig);
        registerListener("uwuifyIncoming", this::forceSaveConfig);
        registerListener("uwuifyMinecraft", this::reloadResources);

        isLoaded = true;
    }

    public static File configFile() throws IOException {
        File file = new File("./config/uwu.toml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }

    public void forceSaveConfig(Object field) {
        INSTANCE.markDirty();
        INSTANCE.writeData();
    }

    public void reloadResources(Object field) {
        this.forceSaveConfig(field);
        new Thread(() -> MinecraftClient.getInstance().reloadResources()).start();
    }
}
