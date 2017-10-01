package com.tatemylove.BugReport.Misc;

import com.tatemylove.BugReport.Files.LangFile;
import com.tatemylove.BugReport.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


/**
 * Created by Tate on 9/16/2017.
 */
public class Reminder extends BukkitRunnable{
    Main plugin;
    public Reminder(Main pl){
        plugin = pl;
    }


    @Override
    public void run() {
        if (Main.timeUntilStart == 0) {
            plugin.restartCountdown();
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + LangFile.getData().getString("reminder-message")));
            }
        }
        Main.timeUntilStart -= 1;
    }
}

