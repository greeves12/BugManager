package com.tatemylove.BugReport.Commands;

import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Main;
import com.tatemylove.BugReport.Misc.Reports;
import com.tatemylove.BugReport.Updater.Updater;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.StringJoiner;

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
                p.sendMessage("§6Please use /bugreport help for assistance");
                p.sendMessage("§6Plugin version " + Main.version);
                p.sendMessage("§6Developers: tatemylove (greeves12)");
                p.sendMessage("§dThe bukkit page: §bhttps://dev.bukkit.org/projects/bugmanager");
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
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + plugin.getConfig().getString("report-message")));
                            return true;
                        }

                    } else {
                        p.sendMessage(Main.prefix + this.plugin.getConfig().getString("noperm-message"));
                    }
                }
                if (args[0].equalsIgnoreCase("help")) {
                    p.sendMessage("§b=-=-=-Bug-Manager by tatemylove (greeves12)-=-=-=-");
                    p.sendMessage("§d/bugreport help ~ Brings up the help section");
                    p.sendMessage("§2/bugreport create [Title] [Description] ~ Creates a bug report");
                    p.sendMessage("§b/bugreport view ~ Ingame viewing of bug reports");
                    p.sendMessage("§c/bugreport reload ~ Reloads the data yml file, always do this before viewing reports");
                    p.sendMessage(("§4/bugreport version ~ Checks the current version"));
                    p.sendMessage("§6/bugreport delete <ID> ~ Deletes the report with the ID (Example: /bugreport delete 0)");
                    p.sendMessage("§a/bugreport update ~ Updates the plugin");
                    p.sendMessage("§b=-=-=--=-=-=-=-=-=-=-=-=-");
                }
                if (args[0].equalsIgnoreCase("view")) {
                    if (p.hasPermission("bugreport.view")) {
                        DataFile.reloadData();
                        p.openInventory(Main.reportInv);
                    } else {
                        p.sendMessage(Main.prefix + this.plugin.getConfig().getString("noperm-message"));
                    }
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    if (p.hasPermission("bugreport.reload")) {
                        p.sendMessage(Main.prefix + "§eDatabase reloaded!");
                        DataFile.saveData();
                        DataFile.reloadData();
                    } else {
                        p.sendMessage(Main.prefix + this.plugin.getConfig().getString("noperm-message"));
                    }
                }
                if (args[0].equalsIgnoreCase(("version"))) {
                    p.sendMessage(Main.prefix + "§aRunning version " + Main.version);
                }
                if (args[0].equalsIgnoreCase("delete")) {
                    if (p.hasPermission("bugreport.delete")) {
                        if (args.length >= 2) {
                            int k = Integer.parseInt(args[1]);
                            Reports.deleteReport(k);
                            p.sendMessage(Main.prefix + this.plugin.getConfig().getString("delete-message"));
                        }
                    } else {
                        p.sendMessage(Main.prefix + this.plugin.getConfig().getString("noperm-message"));
                    }
                }
                if (args[0].equalsIgnoreCase("update")) {
                    if (p.hasPermission("bugreport.update")) {
                        this.plugin.updatePlugin();
                        p.sendMessage(Main.prefix + "Update successfull! Changes will take action next server restart");
                    } else {
                        p.sendMessage(Main.prefix + this.plugin.getConfig().getString("noperm-message"));
                    }
                }
                if (args[0].equalsIgnoreCase("check")) {
                    this.plugin.checkUpdate(p);
                    p.sendMessage(Main.prefix + "§cYou are running version " + Main.version);
                }

            }
            return true;
        }
        return true;
    }
}