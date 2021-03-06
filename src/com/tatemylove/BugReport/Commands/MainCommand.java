package com.tatemylove.BugReport.Commands;

import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Files.LangFile;
import com.tatemylove.BugReport.Main;
import com.tatemylove.BugReport.Misc.ConfigEditor;
import com.tatemylove.BugReport.Misc.Reports;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * Created by Tate on 9/3/2017.
 */
public class MainCommand implements CommandExecutor {
    Main plugin;
    public MainCommand(Main pl){
        plugin = pl;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage("§4§m |   »* |   >»  §r  §6[ §cBugManager §6]  §4§m  «<   | *«   | §r\"");
                p.sendMessage("§8§lPlugin version: §e" + Main.version);
                p.sendMessage("§2§lDevelopers: §btatemylove (greeves12)");
                p.sendMessage("§7§lCommands: §6/report help");
            }
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("create")) {
                    if (p.hasPermission("bugreport.report")) {
                        if (args.length >= 3) {
                            String title = args[1];
                            String desc = "";

                            for (int i = 2; i < args.length; i++) {
                                String arg = args[i] + " ";
                                desc = desc + arg;
                            }
                            Reports.fileReport(p, title, desc);
                            return true;
                        }

                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + LangFile.getData().getString("noperm-message")));
                    }
                }
                    if (args[0].equalsIgnoreCase("help")) {
                        HelpCommand.help(p, args);
                    }
                if (args[0].equalsIgnoreCase("view")) {
                    Reports reports = new Reports();
                    if (p.hasPermission("bugreport.view")) {

                       reports.createInv(p);
                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + LangFile.getData().getString("noperm-message")));
                    }
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    if (p.hasPermission("bugreport.reload")) {
                        p.sendMessage(Main.prefix + "§eDatabase reloaded!");
                        DataFile.saveData();
                        DataFile.reloadData();
                        this.plugin.saveConfig();
                        this.plugin.reloadConfig();
                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + LangFile.getData().getString("noperm-message")));
                    }
                }
                if (args[0].equalsIgnoreCase(("version"))) {
                    p.sendMessage(Main.prefix + "§aRunning §5" + Main.version);
                }
                if (args[0].equalsIgnoreCase("delete")) {
                    if (p.hasPermission("bugreport.delete")) {
                        Reports reports = new Reports();
                        if (args.length >= 2) {
                            int k = Integer.parseInt(args[1]);
                            reports.deleteReport(k, p);

                        }
                    } else {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + LangFile.getData().getString("noperm-message")));
                    }
                }

                if(args[0].equalsIgnoreCase("config")){
                    if(p.hasPermission("bugreport.config")){
                        DataFile.reloadData();
                        p.openInventory(ConfigEditor.configInv);
                    }else{
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + LangFile.getData().getString("noperm-message")));
                    }
                }


            }
            return true;
        }
        return true;
    }
}