package me.simonfoy.invsee;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class InvSee extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("invsee").setExecutor(new InvSeeCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
