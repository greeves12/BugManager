package com.tatemylove.BugReport.Updater;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tatemylove.BugReport.Main;
import com.tatemylove.BugReport.Misc.Reminder;
import com.tatemylove.BugReport.Plugin.ThisPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CheckUpdate {

    public void autoUpdate(){
        try {
            String version = Main.version;
            String parseVersion = version.replace(".", "");

            String tagname = null;
            URL api = new URL("https://api.github.com/repos/greeves12/BugManager/releases/latest");
            URLConnection con = api.openConnection();
            con.setConnectTimeout(15000);
            con.setReadTimeout(15000);

            JsonObject json = new JsonParser().parse(new InputStreamReader(con.getInputStream())).getAsJsonObject();
            tagname = json.get("tag_name").getAsString();

            String parsedTagName = tagname.replace(".", "");

            int latestVersion = Integer.valueOf(parsedTagName.substring(1, parsedTagName.length()));

            final URL download = new URL("https://github.com/greeves12/BugManager/releases/download/" + tagname + "/BugReport.jar");

            if(latestVersion > Integer.parseInt(parseVersion)) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN +"[BugManager] Found a new version " +ChatColor.RED+ tagname +ChatColor.LIGHT_PURPLE+ " downloading now!!");

                new BukkitRunnable(){

                    @Override
                    public void run() {
                        try {

                            InputStream in = download.openStream();
                            File temp = new File("plugins/update");
                            if (!temp.exists()) {
                                temp.mkdir();
                            }
                            Path path = new File("plugins/update" + File.separator + "BugReport.jar").toPath();
                            Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);

                        }catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                }.runTaskLaterAsynchronously(ThisPlugin.getPlugin(), 0);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
