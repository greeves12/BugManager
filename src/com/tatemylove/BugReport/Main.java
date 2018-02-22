package com.tatemylove.BugReport;

import com.tatemylove.BugReport.Commands.MainCommand;
import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Files.LangFile;
import com.tatemylove.BugReport.Misc.Reminder;

import com.tatemylove.BugReport.Plugin.ThisPlugin;
import com.tatemylove.BugReport.Updater.CheckUpdate;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


/**
 * Created by Tate on 9/3/2017.
 */
public class Main extends JavaPlugin{
    public static final String prefix = "§d[Bug§bManager] ";
    public static final String version = "2.0.2";
    private static int startCountdownId;
    public static int timeUntilStart;
    public static Inventory reportInv = Bukkit.createInventory(null, 54, "§dReports Page 1:");
    public static Inventory reportInv2 = Bukkit.createInventory(null, 54, "§dReports Page 2:");
    public static Inventory reportInv3 = Bukkit.createInventory(null, 54, "§dReports Page 3:");
    public static Inventory reportInv4 = Bukkit.createInventory(null, 54, "§dReports Page 4:");


    public void onEnable() {


        startCountDown();
        ConsoleCommandSender cs = getServer().getConsoleSender();
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
