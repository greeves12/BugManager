package com.tatemylove.BugReport;

import com.tatemylove.BugReport.Commands.MainCommand;
import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Misc.Reminder;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Tate on 9/3/2017.
 */
public class Main extends JavaPlugin{
    public static String prefix = "§d[Bug§bManager] ";
    public static String version = "RELEASE v.1.0";
    private static int startCountdownId;
    FileConfiguration config = getConfig();
    public static int timeUntilStart;

    public void onEnable(){

        Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);
        startCountDown();
        ConsoleCommandSender cs = getServer().getConsoleSender();
        cs.sendMessage("§4=-=-=-=-=-=-=-=-");
        cs.sendMessage("§1Running BugManager ver " + version);
        cs.sendMessage("§1Plugin made by tatemylove");
        cs.sendMessage("§1Report plugin bugs on the bukkit page, please.");
        cs.sendMessage("§4=-=-=-=-=-=-=-=-");


        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        DataFile.setup(this);
        MainCommand cmd = new MainCommand();
        getCommand("bugreport").setExecutor(cmd);

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
