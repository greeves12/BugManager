package com.tatemylove.BugReport;

import com.tatemylove.BugReport.Commands.MainCommand;
import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Files.LangFile;
import com.tatemylove.BugReport.Misc.Reminder;

import com.tatemylove.BugReport.Plugin.ThisPlugin;
import com.tatemylove.BugReport.Updater.CheckUpdate;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;


/**
 * Created by Tate on 9/3/2017.
 */
public class Main extends JavaPlugin{
    public static final String prefix = "§d[Bug§bManager] ";
    public static final String version = "2.0.3";
    private static int startCountdownId;
    public static int timeUntilStart;



    public void onEnable() {



        startCountDown();
        Bukkit.getServer().getPluginManager().registerEvents(new Listeners(this), this);
        ThisPlugin.getPlugin().getConfig().options().copyDefaults(true);
        ThisPlugin.getPlugin().saveConfig();
        ThisPlugin.getPlugin().reloadConfig();

        DataFile.setup(this);
        LangFile.setup(this);

        MainCommand cmd = new MainCommand(this);
        getCommand("bugreport").setExecutor(cmd);
        getCommand("report").setExecutor(cmd);

        CheckUpdate update = new CheckUpdate();
        update.autoUpdate();

    }


    public void startCountDown() {
        startCountdownId = getServer().getScheduler().scheduleSyncRepeatingTask((this), new Reminder(this), 0L, 20L);
        timeUntilStart = getConfig().getInt("reminder-interval");
    }
    public void stopCountDown(){
        getServer().getScheduler().cancelTask(startCountdownId);
    }
    public void restartCountdown(){
        stopCountDown();
        startCountDown();
    }


}
