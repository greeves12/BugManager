package com.tatemylove.BugReport.Misc;

import com.tatemylove.BugReport.Files.DataFile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Created by Tate on 9/3/2017.
 */
public class Reports {
    public static int newID;
    public static Inventory reportInv = Bukkit.createInventory(null, 18, "§dReports:");
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
        public static void createBook() {
            String player = DataFile.getData().getString("Reports." + 0 + ".Player");
            String title = DataFile.getData().getString("Reports." + 0 + ".Title");
            ItemStack stack = new ItemStack(Material.BOOK, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(0, stack);
        }
        public static void createSand() {
            String player = DataFile.getData().getString("Reports." + 1 + ".Player");
            String title = DataFile.getData().getString("Reports." + 1 + ".Title");
            ItemStack stack = new ItemStack(Material.SAND, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(1, stack);
        }
        public static void createSaddle(){
            String player = DataFile.getData().getString("Reports." + 2 + ".Player");
            String title = DataFile.getData().getString("Reports." + 2 + ".Title");
            ItemStack stack = new ItemStack(Material.SADDLE, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(2, stack);
        }
        public static void snowBall(){
            String player = DataFile.getData().getString("Reports." + 3 + ".Player");
            String title = DataFile.getData().getString("Reports." + 3 + ".Title");
            ItemStack stack = new ItemStack(Material.SNOW_BALL, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(3, stack);
        }
        public static void ghastTear(){
            String player = DataFile.getData().getString("Reports." + 4 + ".Player");
            String title = DataFile.getData().getString("Reports." + 4 + ".Title");
            ItemStack stack = new ItemStack(Material.GHAST_TEAR, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(4, stack);
        }
        public static void roseRed(){
            String player = DataFile.getData().getString("Reports." + 5 + ".Player");
            String title = DataFile.getData().getString("Reports." + 5 + ".Title");
            ItemStack stack = new ItemStack(Material.RED_ROSE, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(5, stack);
        }
        public static void redStone(){
            String player = DataFile.getData().getString("Reports." + 6 + ".Player");
            String title = DataFile.getData().getString("Reports." + 6 + ".Title");
            ItemStack stack = new ItemStack(Material.REDSTONE, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(6, stack);
        }
        public static void goldAxe(){
            String player = DataFile.getData().getString("Reports." + 7 + ".Player");
            String title = DataFile.getData().getString("Reports." + 7 + ".Title");
            ItemStack stack = new ItemStack(Material.GOLD_AXE, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(7, stack);
        }
        public static void netherBrick(){
            String player = DataFile.getData().getString("Reports." + 8 + ".Player");
            String title = DataFile.getData().getString("Reports." + 8 + ".Title");
            ItemStack stack = new ItemStack(Material.NETHER_BRICK, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(8, stack);
        }
        public static void diamondPickaxe(){
            String player = DataFile.getData().getString("Reports." + 9 + ".Player");
            String title = DataFile.getData().getString("Reports." + 9 + ".Title");
            ItemStack stack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(9, stack);
        }
        public static void diamond(){
            String player = DataFile.getData().getString("Reports." + 10 + ".Player");
            String title = DataFile.getData().getString("Reports." + 10 + ".Title");
            ItemStack stack = new ItemStack(Material.DIAMOND, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(10, stack);
        }
        public static void glowStone(){
            String player = DataFile.getData().getString("Reports." + 11 + ".Player");
            String title = DataFile.getData().getString("Reports." + 11 + ".Title");
            ItemStack stack = new ItemStack(Material.GLOWSTONE_DUST, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(11, stack);
        }
        public static void mushroomSoup(){
            String player = DataFile.getData().getString("Reports." + 12 + ".Player");
            String title = DataFile.getData().getString("Reports." + 12 + ".Title");
            ItemStack stack = new ItemStack(Material.MUSHROOM_SOUP, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(12, stack);
        }
        public static void quartz(){
            String player = DataFile.getData().getString("Reports." + 13 + ".Player");
            String title = DataFile.getData().getString("Reports." + 13 + ".Title");
            ItemStack stack = new ItemStack(Material.QUARTZ, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(13, stack);
        }
        public static void lapisOre(){
            String player = DataFile.getData().getString("Reports." + 14 + ".Player");
            String title = DataFile.getData().getString("Reports." + 14 + ".Title");
            ItemStack stack = new ItemStack(Material.LAPIS_ORE, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(14, stack);
        }
        public static void paper(){
            String player = DataFile.getData().getString("Reports." + 15 + ".Player");
            String title = DataFile.getData().getString("Reports." + 15 + ".Title");
            ItemStack stack = new ItemStack(Material.PAPER, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(15, stack);
        }
        public static void sapling(){
            String player = DataFile.getData().getString("Reports." + 16 + ".Player");
            String title = DataFile.getData().getString("Reports." + 16 + ".Title");
            ItemStack stack = new ItemStack(Material.SAPLING, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(16, stack);
        }
        public static void inkSack(){
            String player = DataFile.getData().getString("Reports." + 17 + ".Player");
            String title = DataFile.getData().getString("Reports." + 17 + ".Title");
            ItemStack stack = new ItemStack(Material.INK_SACK, 1);
            ItemMeta meta = stack.getItemMeta();
            ArrayList<String> lore = new ArrayList<String>();
            lore.add(("By: " + player));
            lore.add(("Title: " + title));
            meta.setLore(lore);
            stack.setItemMeta(meta);
            reportInv.setItem(17, stack);


        }


}
    /*public static void viewReports(){
        ArrayList<Integer> numbers = new ArrayList<>();

    }
}*/
