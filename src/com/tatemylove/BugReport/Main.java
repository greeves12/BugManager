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
        cs.sendMessage("§b=-=-=-Bug-Manager-=-=-=-");
        cs.sendMessage("§6Do not decompile the plugin without permission");
        cs.sendMessage("§6Do not claim this code as yours");
        cs.sendMessage("§6Altering this code, is an infringement under the copyright act");
        cs.sendMessage("§dYou are running version: " + version + " §aby: greeves12");
        cs.sendMessage("§b=-=-=-=-=-=-=-=-=-=-=-=-=-=-");


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
