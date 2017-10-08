package com.tatemylove.BugReport;

import com.tatemylove.BugReport.Commands.MainCommand;
import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Files.LangFile;
import com.tatemylove.BugReport.Misc.Reminder;

import com.tatemylove.BugReport.Plugin.ThisPlugin;
import com.tatemylove.BugReport.Updater.Updater;
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
    public static String prefix = "§d[Bug§bManager] ";
    public static String version = "BugManager v1.3.7";
    private static int startCountdownId;
    public static int timeUntilStart;
    public static Inventory reportInv = Bukkit.createInventory(null, 54, "§dReports Page 1:");
    public static Inventory reportInv2 = Bukkit.createInventory(null, 54, "§dReports Page 2:");
    public static Inventory reportInv3 = Bukkit.createInventory(null, 54, "§dReports Page 3:");
    public static Inventory reportInv4 = Bukkit.createInventory(null, 54, "§dReports Page 4:");
    public static HashMap<UUID, Inventory> users1 = new HashMap<>();
    public static HashMap<UUID, Inventory> users2 = new HashMap<>();
    public static HashMap<UUID, Inventory> users3 = new HashMap<>();
    public static HashMap<UUID, Inventory> users4 = new HashMap<>();



    public void onEnable() {

        if(getConfig().getBoolean("auto-update") == true){
            Updater updater = new Updater(this, 277007, this.getFile(), Updater.UpdateType.DEFAULT, true);
        }

        Updater updater = new Updater(this, 277007, this.getFile(), Updater.UpdateType.NO_DOWNLOAD, false);
        startCountDown();
        ConsoleCommandSender cs = getServer().getConsoleSender();
        cs.sendMessage("§b=-=-=-Bug-Manager-=-=-=-");
        cs.sendMessage("§6Do not decompile the plugin without permission");
        cs.sendMessage("§6Do not claim this code as yours");
        cs.sendMessage("§6Altering this code, is an infringement under the copyright act");
        cs.sendMessage("§dYou are running version: " + version + " §aby: greeves12");
        cs.sendMessage("§5Latest Download is " + updater.getLatestName());
        cs.sendMessage("§b=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        Bukkit.getServer().getPluginManager().registerEvents(new Listeners(this), this);
        ThisPlugin.getPlugin().getConfig().options().copyDefaults(true);
        ThisPlugin.getPlugin().saveConfig();
        ThisPlugin.getPlugin().reloadConfig();

        DataFile.setup(this);
        LangFile.setup(this);

        MainCommand cmd = new MainCommand(this);
        getCommand("bugreport").setExecutor(cmd);

    }
    public void updatePlugin(){
        Updater updater = new Updater(this, 277007, this.getFile(), Updater.UpdateType.NO_VERSION_CHECK, true);
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
    public void checkUpdate(Player p){
        Updater updater = new Updater(this, 277007, this.getFile(), Updater.UpdateType.NO_DOWNLOAD, false);
            p.sendMessage(Main.prefix + "§dLatest Download is " + updater.getLatestName());
    }

}
