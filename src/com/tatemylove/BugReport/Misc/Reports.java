package com.tatemylove.BugReport.Misc;

import com.tatemylove.BugReport.Files.DataFile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Created by Tate on 9/3/2017.
 */
public class Reports {
    public static int currentReport;
    public static int newID;
    public static Inventory reportInv = Bukkit.createInventory(null, 18, "§dReports:");
    public int cooldown = 3000;
    public static int k = 0;
    public static int k2 = 0;
    public static int k3 = 0;


    public static int chooseReport() {
        ArrayList<Integer> numbers = new ArrayList<>();

        DataFile.getData().contains("Reports." + k + ".Player");
        numbers.add(Integer.valueOf(k));

    return ((Integer)numbers.get(0)).intValue();
    }

    public static int chooseReport2(){
        ArrayList<Integer> numbers = new ArrayList<>();

        DataFile.getData().contains("Reports." + k2 + ".Title");
        numbers.add(Integer.valueOf(k2).intValue());

        return ((Integer)numbers.get(0)).intValue();
    }

    public static int chooseReport3(){
        ArrayList<Integer> numbers = new ArrayList<>();

        DataFile.getData().contains("Reports." + k3 + ".Description");
        numbers.add(Integer.valueOf(k3).intValue());

        return ((Integer)numbers.get(0).intValue());

    }

    public static void fileReport(Player p, String title, String desc){
        TreeMap<Integer, Integer> numbers = new TreeMap();
        for (int k = 0; DataFile.getData().contains("Reports." + k); k++) {
            numbers.put(Integer.valueOf(k), Integer.valueOf(k));
        }

        if (numbers.size() == 0) {
            newID = 0;
        } else {
            newID = ((Integer)numbers.lastEntry().getValue()).intValue() + 1;
        }


        DataFile.getData().set("Reports." + newID + ".Player", p.getName());
        DataFile.getData().set("Reports." + newID + ".Title", title);
        DataFile.getData().set("Reports." + newID + ".Description", desc);
        DataFile.saveData();
        DataFile.reloadData();

    }
    static {
        reportInv.setItem(0, new ItemStack(Material.BOOK, 1));
        reportInv.setItem(1, new ItemStack(Material.SAND, 1));
        reportInv.setItem(2, new ItemStack(Material.SADDLE, 1));
        reportInv.setItem(3, new ItemStack(Material.SNOW_BALL, 1));
        reportInv.setItem(4, new ItemStack(Material.GHAST_TEAR, 1));
        reportInv.setItem(5, new ItemStack(Material.RED_ROSE, 1));
        reportInv.setItem(6, new ItemStack(Material.REDSTONE, 1));
        reportInv.setItem(7, new ItemStack(Material.GOLD_AXE, 1));
        reportInv.setItem(8, new ItemStack(Material.NETHER_BRICK, 1));
        reportInv.setItem(9, new ItemStack(Material.DIAMOND_PICKAXE, 1));
        reportInv.setItem(10, new ItemStack(Material.DIAMOND, 1));
        reportInv.setItem(11, new ItemStack(Material.GLOWSTONE_DUST, 1));
        reportInv.setItem(12, new ItemStack(Material.MUSHROOM_SOUP, 1));
        reportInv.setItem(13, new ItemStack(Material.QUARTZ, 1));
        reportInv.setItem(14, new ItemStack(Material.LAPIS_ORE, 1));
        reportInv.setItem(15, new ItemStack(Material.PAPER, 1));
        reportInv.setItem(16, new ItemStack(Material.SAPLING, 1));
        reportInv.setItem(17, new ItemStack(Material.INK_SACK, 1));
    }

}
    /*public static void viewReports(){
        ArrayList<Integer> numbers = new ArrayList<>();

    }
}*/
