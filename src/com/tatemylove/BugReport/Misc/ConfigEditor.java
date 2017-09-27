package com.tatemylove.BugReport.Misc;

import com.tatemylove.BugReport.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * Created by Tate on 9/26/2017.
 */
public class ConfigEditor {

    Main plugin;
    public ConfigEditor(Main pl){
        plugin = pl;
    }
    public static Inventory configInv = Bukkit.createInventory(null, 27, Main.prefix + "§5Config Editor");
    public static Inventory configReminder = Bukkit.createInventory(null, 18, "§5Reminder Interval");

    public static void createConfig(){
        ItemStack stack = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§aReminder Interval");
        stack.setItemMeta(meta);
        configInv.setItem(0, stack);

        ItemStack two = new ItemStack(Material.BOOK, 1);
        ItemMeta twoMeta = two.getItemMeta();
        twoMeta.setDisplayName("§bAutoUpdater");
        two.setItemMeta(twoMeta);
        configInv.setItem(8, two);

        ItemStack closeInv = new ItemStack(Material.ANVIL, 1);
        ItemMeta closeMeta = closeInv.getItemMeta();
        closeMeta.setDisplayName("§cExit");
        closeInv.setItemMeta(closeMeta);
        configInv.setItem(22, closeInv);
    }


}
