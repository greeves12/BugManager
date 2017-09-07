package com.tatemylove.BugReport;

import com.tatemylove.BugReport.Commands.MainCommand;
import com.tatemylove.BugReport.Files.DataFile;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Tate on 9/3/2017.
 */
public class Main extends JavaPlugin{
    public static String prefix = "§d[Bug§bManager] ";
    public static String version = "vALPHA";

    public void onEnable(){

        Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);

        ConsoleCommandSender cs = getServer().getConsoleSender();
        cs.sendMessage("§4=-=-=-=-=-=-=-=-");
        cs.sendMessage("§1Running BugManager ver " + version);
        cs.sendMessage("§1Plugin made by tatemylove");
        cs.sendMessage("§1Report plugin bugs on the bukkit page, please.");
        cs.sendMessage("§4=-=-=-=-=-=-=-=-");

        DataFile.setup(this);
        MainCommand cmd = new MainCommand();
        getCommand("bugreport").setExecutor(cmd);

    }
}
