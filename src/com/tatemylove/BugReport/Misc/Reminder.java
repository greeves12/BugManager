package com.tatemylove.BugReport.Misc;

import com.tatemylove.BugReport.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

/**
 * Created by Tate on 9/16/2017.
 */
public class Reminder extends BukkitRunnable{
    public static int timeUntilStart = 300;
    Main plugin;
    public Reminder(Main pl){
        plugin = pl;
    }


    @Override
    public void run() {
        if (timeUntilStart == 0) {
            plugin.restartCountdown();
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendMessage(Main.prefix + "§dIf you encounter a bug, please report it! \n§b/bugreport <title> <description>");
            }
        }
        timeUntilStart -= 1;
    }
}

