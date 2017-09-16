package com.tatemylove.BugReport.Commands;

import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Main;
import com.tatemylove.BugReport.Misc.Reports;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Tate on 9/3/2017.
 */
public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        Player p = (Player) sender;
            if(args.length == 0){
            p.sendMessage("§6Please use /bugreport help for assistance");
            p.sendMessage("§6Plugin version " + Main.version);
            p.sendMessage("§6Developers: tatemylove (greeves12)");
            p.sendMessage("§dThe bukkit page: §bhttps://dev.bukkit.org/projects/bugmanager");
    }
            if(args.length >= 1) {
                if (args[0].equalsIgnoreCase("create")) {
                    if (p.hasPermission("bugreport.report")) {
                        if (args.length >= 3) {
                            String title = args[1];
                            String desc = args[2];
                            Reports.fileReport(p, title, desc);
                            p.sendMessage(Main.prefix + "§bThanks for reporting!");
                            return true;
                        }
                    } else {
                        p.sendMessage(Main.prefix + "§cNo access");
                    }
                }
                if(args[0].equalsIgnoreCase("help")){
                    p.sendMessage("§d=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    p.sendMessage("§aBug Manager Help Section");
                    p.sendMessage("§d/bugreport help ~ Brings up the help section");
                    p.sendMessage("§d/bugreport create [Title] [Description] ~ Creates a bug report");
                    p.sendMessage("§b/bugreport view ~ Ingame viewing of bug reports");
                    p.sendMessage("§c/bugreport reload ~ Reloads the data yml file, always do this before viewing reports");
                }
                if(args[0].equalsIgnoreCase("view")){
                    if(p.hasPermission("bugreport.view")){
                        DataFile.reloadData();
                        p.openInventory(Reports.reportInv);
                    }
                }
                if(args[0].equalsIgnoreCase("reload")){
                    if(p.hasPermission("bugreport.reload")){
                        p.sendMessage(Main.prefix + "§eDatabase reloaded!");
                        DataFile.saveData();
                        DataFile.reloadData();
                    }
                }

            }
        return true;
    }
}