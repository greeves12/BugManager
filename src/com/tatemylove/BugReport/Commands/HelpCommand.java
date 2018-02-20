package com.tatemylove.BugReport.Commands;

import org.bukkit.command.CommandSender;

/**
 * Created by Tate on 9/27/2017.
 */
public class HelpCommand {

    public static void help(CommandSender p, String[] args){
        if (args.length == 1) {
            p.sendMessage("§4§m |   »* |   >»  §r  §6[ §cBugManager Help §d· §e1/2§d· §6]  §4§m  «<   | *«   | §r\"");
            p.sendMessage(" §8- §3/report help §7- §bShows the help menu");
            p.sendMessage(" §8- §3/report create [Title] [Description] §7- §bCreates a report");
            p.sendMessage(" §8- §3/report view §7- §bView reports");
            p.sendMessage(" §8- §3/report reload §7- §bReloads the plugin");
            p.sendMessage(" §8- §3/report version §7- §bReturns the version");

        }else if (args.length >= 2) {
            if (args[1].equalsIgnoreCase("1") || args[1].equalsIgnoreCase("0")) {
                p.sendMessage("§4§m |   »* |   >»  §r  §6[ §cBugManager Help §d· §e1/2§d· §6]  §4§m  «<   | *«   | §r\"");
                p.sendMessage(" §8- §3/report help §7- §bShows the help menu");
                p.sendMessage(" §8- §3/report create [Title] [Description] §7- §bCreates a report");
                p.sendMessage(" §8- §3/report view §7- §bView reports");
                p.sendMessage(" §8- §3/report reload §7- §bReloads the plugin");
                p.sendMessage(" §8- §3/report version §7- §bReturns the version");
            }else if (args[1].equalsIgnoreCase("2")) {
                p.sendMessage("§4§m |   »* |   >»  §r  §6[ §cBugManager Help §d· §e2/2§d· §6]  §4§m  «<   | *«   | §r\"");
                p.sendMessage(" §8- §3/report delete [ID] §7- §bDeletes the report");
                p.sendMessage(" §8- §3/report config §7- §bOpens the in-game config");
    }
}
    }
}
