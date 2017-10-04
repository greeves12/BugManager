package com.tatemylove.BugReport.Files;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Tate on 9/30/2017.
 */
public class LangFile {

    private LangFile() { }

    static LangFile instance = new LangFile();

    public static LangFile getInstance() {
        return instance;
    }

    static Plugin p;

    static FileConfiguration language;
    static File lfile;

    public static void setup(Plugin p) {

        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }

        lfile = new File(p.getDataFolder(), "language.yml");

        if (!lfile.exists()) {
            try {
                lfile.createNewFile();
            }
            catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create language.yml!");
            }
        }

        language = YamlConfiguration.loadConfiguration(lfile);
        language.addDefault("reminder-message", "&dIf you encounter a bug, please report it! %n%&b/bugreport <title> <description>");
        language.addDefault("report-message", "&bThanks for reporting!");
        language.addDefault("delete-message", "&aReport %report#% deleted");
        language.addDefault("noperm-message", "&cYou don't have access to this command!");
        language.addDefault("cooldown-message", "&cYou cannot report another bug for %secondsleft% more seconds");
        language.options().copyDefaults(true);
        saveData();
    }

    public static FileConfiguration getData() {
        return language;
    }

    public static void saveData() {
        try {
            language.save(lfile);
        }
        catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save language.yml!");
        }
    }

    public static void reloadData() {
        language = YamlConfiguration.loadConfiguration(lfile);
    }

    public static PluginDescriptionFile getDesc() {
        return p.getDescription();
    }
}