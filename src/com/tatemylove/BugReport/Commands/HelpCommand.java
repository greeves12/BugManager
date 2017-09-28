package com.tatemylove.BugReport.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Tate on 9/27/2017.
 */
public class HelpCommand {

    public static void help(CommandSender p, String[] args){
        if (args.length == 1) {
            p.sendMessage("§b=-=-=-§aBug-Manager §5by tatemylove (greeves12)§b-=-=-=-");
            p.sendMessage("§d/bugreport help <page #> ~ Brings up the help section");
            p.sendMessage("§2/bugreport create [Title] [Description] ~ Creates a bug report");
            p.sendMessage("§b/bugreport view ~ Ingame viewing of bug reports");
            p.sendMessage("§c/bugreport reload ~ Reloads the data yml file and config");
            p.sendMessage(("§4/bugreport version ~ Checks the current version"));
            p.sendMessage("§6/bugreport delete <ID> ~ Deletes the report with the ID (Example: /bugreport delete 0)");
            p.sendMessage("§a/bugreport update ~ Updates the plugin");
        }else if (args.length >= 2) {
            if (args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("0")) {
                p.sendMessage("§b=-=-=-§aBug-Manager §5by tatemylove (greeves12)§b-=-=-=-");
                p.sendMessage("§d/bugreport help <page #> ~ Brings up the help section");
                p.sendMessage("§2/bugreport create [Title] [Description] ~ Creates a bug report");
                p.sendMessage("§b/bugreport view ~ Ingame viewing of bug reports");
                p.sendMessage("§c/bugreport reload ~ Reloads the data yml file and config");
                p.sendMessage(("§4/bugreport version ~ Checks the current version"));
                p.sendMessage("§6/bugreport delete <ID> ~ Deletes the report with the ID (Example: /bugreport delete 0)");
                p.sendMessage("§a/bugreport update ~ Updates the plugin");
                p.sendMessage("§b=-=-=--=-=-=-=-=-=-=-=-=-");
            }else if (args[1].equalsIgnoreCase("2")) {
                p.sendMessage("§b=-=-=-§aBug-Manager §5by tatemylove (greeves12)§b-=-=-=-");
                p.sendMessage("§a/bugreport update ~ Updates the plugin");
                p.sendMessage("§5/bugreport config ~ Opens the config editor GUI");
    }
}
    }
}
