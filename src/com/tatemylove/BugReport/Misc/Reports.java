package com.tatemylove.BugReport.Misc;

import com.mysql.fabric.xmlrpc.base.Array;
import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
    public int cooldown = 3000;


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
            Main.reportInv.setItem(k, null);
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
                Main.reportInv.setItem(k, stack);

            } else if (k == 53) {
                break;
            }
        }
        ItemStack anvil = new ItemStack(Material.ANVIL, 1);
        ItemMeta Meta = anvil.getItemMeta();
        Meta.setDisplayName("§bNext Page");
        anvil.setItemMeta(Meta);
        Main.reportInv.setItem(53, anvil);
    }

    public static void createInv2() {

        for (int i = 54; DataFile.getData().contains("Reports." + i); i++) {
            if (i < 99) {
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
                Main.reportInv2.setItem(i % 54, Stack);
            }else if(i==99){
                break;
            }

        }
        ItemStack anvil = new ItemStack(Material.ANVIL, 1);
        ItemMeta Meta = anvil.getItemMeta();
        Meta.setDisplayName("§bPrevious Page");
        anvil.setItemMeta(Meta);

        ItemStack anvil2 = new ItemStack(Material.ANVIL, 1);
        ItemMeta anvilMeta = anvil2.getItemMeta();
        anvilMeta.setDisplayName("§bNext Page");
        anvil2.setItemMeta(anvilMeta);
        Main.reportInv2.setItem(45, anvil);
        Main.reportInv2.setItem(53, anvil2);
    }

    public static void createInv3(){
        for (int j = 99; DataFile.getData().contains("Reports." + j); j++){
            if(j < 144){
                String player = DataFile.getData().getString("Reports." + j + ".Player");
                String title = DataFile.getData().getString("Reports." + j + ".Title");
                ItemStack Stack = new ItemStack(Material.BOOK, 1);
                ItemMeta meta = Stack.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();
                meta.setDisplayName("§aReport Number: §d" + j);
                lore.add(("By: " + player));
                lore.add(("Title: " + title));
                meta.setLore(lore);
                Stack.setItemMeta(meta);
                Main.reportInv3.setItem(j % 99, Stack);
            }else if(j == 144){
                break;
            }

        }
        ItemStack anvil = new ItemStack(Material.ANVIL, 1);
        ItemMeta Meta = anvil.getItemMeta();
        Meta.setDisplayName("§bPrevious Page");
        anvil.setItemMeta(Meta);


        Main.reportInv3.setItem(45, anvil);
    }
}


