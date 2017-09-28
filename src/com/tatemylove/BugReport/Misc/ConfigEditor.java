package com.tatemylove.BugReport.Misc;

import com.tatemylove.BugReport.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


/**
 * Created by Tate on 9/26/2017.
 */
public class ConfigEditor {

    Main plugin;
    public ConfigEditor(Main pl){
        plugin = pl;
    }
    public static Inventory configInv = Bukkit.createInventory(null, 27, "§5Config Editor");
    public static Inventory configReminder = Bukkit.createInventory(null, 27, "§5Reminder Interval");
    public static Inventory configAutoUpdater = Bukkit.createInventory(null, 27, "§5Auto Updater");
    public static Inventory configJoinMessage = Bukkit.createInventory(null, 27, "§5Join Message");

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

        ItemStack joinMes = new ItemStack(Material.BOOK, 1);
        ItemMeta joinMeta = joinMes.getItemMeta();
        joinMeta.setDisplayName("§3Join-Message");
        joinMes.setItemMeta(joinMeta);
        configInv.setItem(4, joinMes);
    }

}
