package xyz.redsmarty.nbtlib;

import org.bukkit.plugin.java.JavaPlugin;

public final class NbtLib extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().warning("This plugin is meant to be shaded into other plugin as libraries, its not required to install it on the server. But installing on the server will worn nonetheless.");
        if (NbtIOManager.getInstance() == null) {
            getLogger().severe("You are running an unsupported server version. This plugin will not work.");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
