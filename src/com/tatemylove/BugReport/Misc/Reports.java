package com.tatemylove.BugReport.Misc;


import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Files.LangFile;
import com.tatemylove.BugReport.Main;
import com.tatemylove.BugReport.Plugin.ThisPlugin;
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
    public static int cooldown = ThisPlugin.getPlugin().getConfig().getInt("cool-down");
    public static int newID;
    public static HashMap<UUID, Long> coolDown = new HashMap<>();
    //public static HashMap<String, Inventory> hasPlayer = new HashMap<>();


    public static void fileReport(Player p, String title, String desc) {
        Calendar cal = Calendar.getInstance();

        int cooldown = ThisPlugin.getPlugin().getConfig().getInt("cool-down");
        long secondsLeft = ((coolDown.get(p.getUniqueId())/1000)+cooldown) - (System.currentTimeMillis()/1000);

        if(!p.hasPermission("bugreport.bypass")) {
            if (secondsLeft < 1) {
                coolDown.put(p.getUniqueId(), System.currentTimeMillis());
            }
        }


        if(coolDown.containsKey(p.getUniqueId())) {
            if (secondsLeft < 1) {
                TreeMap<Integer, Integer> numbers = new TreeMap();
                for (int k = 0; DataFile.getData().contains("Reports." + k); k++) {
                    numbers.put(k, k);
                }

                if (numbers.size() == 0) {
                    newID = 0;
                } else {
                    newID = (Integer) numbers.lastEntry().getValue() + 1;
                }

                DataFile.getData().set("Reports." + newID + ".Player", p.getName());
                DataFile.getData().set("Reports." + newID + ".Title", title);
                DataFile.getData().set("Reports." + newID + ".Description", desc);
                DataFile.getData().set("Reports." + newID + ".Time", cal);
                DataFile.saveData();
                DataFile.reloadData();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + LangFile.getData().getString("report-message")));

            }else{
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + LangFile.getData().getString("cooldown-message").replaceAll("%secondsleft%", String.valueOf(secondsLeft))));
            }
        }
    }

    public static void deleteReport(int k, Player p) {
        if (DataFile.getData().contains("Reports." + k)) {
            DataFile.getData().set("Reports." + k, null);
            DataFile.saveData();
            DataFile.reloadData();
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.prefix + LangFile.getData().getString("delete-message").replaceAll("%report#%", String.valueOf(k))));

            if(k <=52){
                Main.reportInv.setItem(k, null);
            }
            if (k >= 53) {
                Main.reportInv2.setItem(k % 53, null);
            }
            if(k >=99){
                Main.reportInv3.setItem(k % 99, null);
            }
            if(k>=143){
                Main.reportInv4.setItem(k % 143, null);
            }
            if(k > 188){
                p.sendMessage(Main.prefix + "§cInvalid argument (" + k + "§c)");
            }
        }else{
            p.sendMessage(Main.prefix + "§cReport §e" + k + "§c does not exist!");
        }

    }



    public static void createInv(Player p) {
        Main.reportInv = Bukkit.createInventory(p, 54, "§dReports Page 1:");
        if (DataFile.getData().contains("Reports." + 0)) {
            for (String k : DataFile.getData().getConfigurationSection("Reports.").getKeys(false)) {
                int j = Integer.parseInt(k);
                //if (!hasPlayer.containsKey(p.getName())) {

                if (j >= 0) {
                    String player = DataFile.getData().getString("Reports." + Integer.parseInt(k) + ".Player");
                    String title = DataFile.getData().getString("Reports." + Integer.parseInt(k) + ".Title");
                    String cal = DataFile.getData().getString("Reports." + j + ".Time");
                    ItemStack Stack = new ItemStack(Material.BOOK, 1);
                    ItemMeta meta = Stack.getItemMeta();
                    ArrayList<String> lore = new ArrayList<String>();
                    meta.setDisplayName("§bReport Number: §d" + Integer.parseInt(k));
                    lore.add("§6<Right Click To Delete>");
                    lore.add(("§8By: §a" + player));
                    lore.add(("§8Title: §a" + title));
                    lore.add("§8Time: §a" + cal);
                    meta.setLore(lore);
                    Stack.setItemMeta(meta);
                    Main.reportInv.setItem(Integer.parseInt(k), Stack);
                    if (j == 52) {
                        break;
                    }
                }
            }
            ItemStack anvil = new ItemStack(Material.ANVIL, 1);
            ItemMeta Meta = anvil.getItemMeta();
            Meta.setDisplayName("§bNext Page");
            anvil.setItemMeta(Meta);
            Main.reportInv.setItem(53, anvil);

            p.openInventory(Main.reportInv);
        }else{
            p.sendMessage(Main.prefix + "§bNo reports found!");
        }
    }

   // }

    public static void createInv2(Player p) {
        Main.reportInv2 = Bukkit.createInventory(p, 54, "§dReports Page 2:");
        for (String i  : DataFile.getData().getConfigurationSection("Reports.").getKeys(false)) {
            int j = Integer.parseInt(i);
            //if (!hasPlayer.containsKey(p.getName())) {

                if (j >= 53) {
                    String player = DataFile.getData().getString("Reports." + j + ".Player");
                    String title = DataFile.getData().getString("Reports." + j + ".Title");
                    String cal = DataFile.getData().getString("Reports." + j + ".Time");
                    ItemStack Stack = new ItemStack(Material.BOOK, 1);
                    ItemMeta meta = Stack.getItemMeta();
                    ArrayList<String> lore = new ArrayList<String>();
                    meta.setDisplayName("§bReport Number: §d" + j);
                    lore.add("§6<Right Click To Delete>");
                    lore.add(("§8By: §a" + player));
                    lore.add(("§8Title: §a" + title));
                    lore.add("§8Time: §a" + cal);
                    meta.setLore(lore);
                    Stack.setItemMeta(meta);
                    Main.reportInv2.setItem(j % 53, Stack);
                    if (j == 97) {
                        break;
                    }
                }
                ItemStack anvil = new ItemStack(Material.ANVIL, 1);
                ItemMeta Meta = anvil.getItemMeta();
                Meta.setDisplayName("§bNext Page");
                anvil.setItemMeta(Meta);
                Main.reportInv2.setItem(53, anvil);

                ItemStack anvil1 = new ItemStack(Material.ANVIL, 1);
                ItemMeta Meta1 = anvil1.getItemMeta();
                Meta1.setDisplayName("§bPrevious Page");
                anvil1.setItemMeta(Meta1);
                Main.reportInv2.setItem(45, anvil1);


            }
        p.openInventory(Main.reportInv2);
        }



    public static void createInv3(Player p){
        Main.reportInv3 = Bukkit.createInventory(p, 54, "§dReports Page 3:");
        for (String i  : DataFile.getData().getConfigurationSection("Reports.").getKeys(false)) {
            int j = Integer.parseInt(i);
            //if (!hasPlayer.containsKey(p.getName())) {

                if (j >= 98) {
                    String player = DataFile.getData().getString("Reports." + j + ".Player");
                    String title = DataFile.getData().getString("Reports." + j + ".Title");
                    String cal = DataFile.getData().getString("Reports." + j + ".Time");
                    ItemStack Stack = new ItemStack(Material.BOOK, 1);
                    ItemMeta meta = Stack.getItemMeta();
                    ArrayList<String> lore = new ArrayList<String>();
                    meta.setDisplayName("§bReport Number: §d" + j);
                    lore.add("§6<Right Click To Delete>");
                    lore.add(("§8By: §a" + player));
                    lore.add(("§8Title: §a" + title));
                    lore.add("§8Time: §a" + cal);
                    meta.setLore(lore);
                    Stack.setItemMeta(meta);
                    Main.reportInv3.setItem(j % 98, Stack);

                }
                if (j == 142) {
                    break;
                }
                ItemStack anvil = new ItemStack(Material.ANVIL, 1);
                ItemMeta Meta = anvil.getItemMeta();
                Meta.setDisplayName("§bNext Page");
                anvil.setItemMeta(Meta);
                Main.reportInv3.setItem(53, anvil);

                ItemStack anvil1 = new ItemStack(Material.ANVIL, 1);
                ItemMeta Meta1 = anvil1.getItemMeta();
                Meta1.setDisplayName("§bPrevious Page");
                anvil1.setItemMeta(Meta1);
                Main.reportInv3.setItem(45, anvil1);

            }
        p.openInventory(Main.reportInv3);
        }



    public static void createInv4(Player p){
        Main.reportInv4 = Bukkit.createInventory(p, 54, "§dReports Page 4:");
        for (String i  : DataFile.getData().getConfigurationSection("Reports.").getKeys(false)) {
            int j = Integer.parseInt(i);


                if (j >= 143) {
                    String player = DataFile.getData().getString("Reports." + j + ".Player");
                    String title = DataFile.getData().getString("Reports." + j + ".Title");
                    String cal = DataFile.getData().getString("Reports." + j + ".Time");
                    ItemStack Stack = new ItemStack(Material.BOOK, 1);
                    ItemMeta meta = Stack.getItemMeta();
                    ArrayList<String> lore = new ArrayList<String>();
                    meta.setDisplayName("§bReport Number: §d" + j);
                    lore.add("§6<Right Click To Delete>");
                    lore.add(("§8By: §a" + player));
                    lore.add(("§8Title: §a" + title));
                    lore.add("§8Time: §a" + cal);
                    meta.setLore(lore);
                    Stack.setItemMeta(meta);
                    Main.reportInv4.setItem(j % 143, Stack);
                    if (j == 187) {
                        break;
                    }
                }
                ItemStack anvil1 = new ItemStack(Material.ANVIL, 1);
                ItemMeta Meta1 = anvil1.getItemMeta();
                Meta1.setDisplayName("§bPrevious Page");
                anvil1.setItemMeta(Meta1);
                Main.reportInv4.setItem(45, anvil1);
            }
        p.openInventory(Main.reportInv4);
        }

    }



