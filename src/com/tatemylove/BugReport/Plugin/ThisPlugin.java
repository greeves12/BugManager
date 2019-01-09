package com.tatemylove.BugReport.Plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/**
 * Created by Tate on 9/30/2017.
 */
public class ThisPlugin {

    public static Plugin getPlugin() {
        return Bukkit.getServer().getPluginManager().getPlugin("BugReport");
    }
}
