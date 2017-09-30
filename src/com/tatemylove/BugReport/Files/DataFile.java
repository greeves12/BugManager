package com.tatemylove.BugReport.Files;

import com.tatemylove.BugReport.Misc.ConfigEditor;
import com.tatemylove.BugReport.Misc.Reports;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Tate on 9/3/2017.
 */
public class DataFile
{

    static DataFile instance = new DataFile();
    static Plugin p;
    static FileConfiguration bug;
    static File afile;

    public static void setup(Plugin p)
    {
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
        afile = new File(p.getDataFolder(), "data.yml");
        if (!afile.exists()) {
            try
            {
                afile.createNewFile();
            }
            catch (IOException e)
            {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not create data.yml!");
            }
        }
        bug = YamlConfiguration.loadConfiguration(afile);
    }

    public static FileConfiguration getData()
    {
        return bug;
    }

    public static void saveData()
    {
        try
        {
            bug.save(afile);
        }
        catch (IOException e)
        {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save data.yml!");
        }
    }

    public static void reloadData()
    {
        bug = YamlConfiguration.loadConfiguration(afile);
        Reports.createInv();
        ConfigEditor.createConfig();
    }

    public static PluginDescriptionFile getDesc()
    {
        return p.getDescription();
    }
}