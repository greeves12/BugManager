package com.tatemylove.BugReport.Misc;

import com.mysql.fabric.xmlrpc.base.Array;
import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

/**
 * Created by Tate on 9/3/2017.
 */
public class Reports {
    public static int newID;
    public static Inventory reportInv = Bukkit.createInventory(null, 54, "§dReports Page 1:");
    public static Inventory reportInv2 = Bukkit.createInventory(null, 54, "§dReports Page 2:");
    public int cooldown = 3000;
    public static int j;
    public ArrayList<Inventory> pages = new ArrayList<>();
    public static ArrayList<ItemStack> items = new ArrayList<ItemStack>();
    public static HashMap<Integer, Player> player = new HashMap<>();


    public static void fileReport(Player p, String title, String desc) {
        TreeMap<Integer, Integer> numbers = new TreeMap();
        for (int k = 0; DataFile.getData().contains("Reports." + k); k++) {
            numbers.put(Integer.valueOf(k), Integer.valueOf(k));
        }

        if (numbers.size() == 0) {
            newID = 0;
        } else {
            newID = ((Integer) numbers.lastEntry().getValue()).intValue() + 1;
        }

        DataFile.getData().set("Reports." + newID + ".Player", p.getName());
        DataFile.getData().set("Reports." + newID + ".Title", title);
        DataFile.getData().set("Reports." + newID + ".Description", desc);
        DataFile.saveData();
        DataFile.reloadData();

    }

    public static void deleteReport(int k) {
        if (DataFile.getData().contains("Reports." + k)) {
            String player = DataFile.getData().getString("Reports." + k + ".Player");
            String title = DataFile.getData().getString("Reports." + k + ".Title");
            ItemStack stack = new ItemStack(Material.BOOK, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            DataFile.getData().set("Reports." + k, null);
            DataFile.saveData();
            DataFile.reloadData();
            reportInv.setItem(k, null);
        }

    }

    public static void createInv() {
        for (int k = 0; DataFile.getData().contains("Reports." + k); k++) {

            if (k < 53) {
                String player = DataFile.getData().getString("Reports." + k + ".Player");
                String title = DataFile.getData().getString("Reports." + k + ".Title");
                ItemStack stack = new ItemStack(Material.BOOK, 1);
                ItemMeta meta = stack.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();
                meta.setDisplayName("§aReport Number: §d" + k);
                lore.add(("By: " + player));
                lore.add(("Title: " + title));
                meta.setLore(lore);
                stack.setItemMeta(meta);
                reportInv.setItem(k, stack);

            } else if (k == 53) {
                break;
            }
        }
        ItemStack anvil = new ItemStack(Material.ANVIL, 1);
        ItemMeta Meta = anvil.getItemMeta();
        Meta.setDisplayName("§bNext Page");
        anvil.setItemMeta(Meta);
        reportInv.setItem(53, anvil);
    }

    public static void createInv2() {

        for (int i = 54; DataFile.getData().contains("Reports." + i); i++) {
            if (i < 107) {
                String player = DataFile.getData().getString("Reports." + i + ".Player");
                String title = DataFile.getData().getString("Reports." + i + ".Title");
                ItemStack Stack = new ItemStack(Material.BOOK, 1);
                ItemMeta meta = Stack.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();
                meta.setDisplayName("§aReport Number: §d" + i);
                lore.add(("By: " + player));
                lore.add(("Title: " + title));
                meta.setLore(lore);
                Stack.setItemMeta(meta);
                reportInv2.setItem(i % 54, Stack);
            }else if(i==107){
                break;
            }

        }
        ItemStack anvil = new ItemStack(Material.ANVIL, 1);
        ItemMeta Meta = anvil.getItemMeta();
        Meta.setDisplayName("§bPrevious Page");
        anvil.setItemMeta(Meta);
        reportInv2.setItem(45, anvil);
    }
}


