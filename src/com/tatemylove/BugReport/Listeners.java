package com.tatemylove.BugReport;

import com.sun.org.apache.regexp.internal.RE;
import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Misc.Reports;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

/**
 * Created by Tate on 9/6/2017.
 */
public class Listeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();



        if (inventory.getName().equals(Reports.reportInv.getName())) {
            if (clicked.getType() == Material.BOOK) {
                String reports = DataFile.getData().getString("Reports." + 0 + ".Player");
                String title = DataFile.getData().getString("Reports." + 0 + ".Title");
                String description = DataFile.getData().getString("Reports." + 0 + ".Description");
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);

            }
        }
        if (inventory.getName().equals(Reports.reportInv.getName())) {
            String reports = DataFile.getData().getString("Reports." + 1 + ".Player");
            String title = DataFile.getData().getString("Reports." + 1 + ".Title");
            String description = DataFile.getData().getString("Reports." + 1 + ".Description");
            if (clicked.getType() == Material.SAND) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if (inventory.getName().equals(Reports.reportInv.getName())) {
            String reports = DataFile.getData().getString("Reports." + 2 + ".Player");
            String title = DataFile.getData().getString("Reports." + 2 + ".Title");
            String description = DataFile.getData().getString("Reports." + 2 + ".Description");

                if (clicked.getType() == Material.SADDLE) {
                    e.setCancelled(true);
                    p.closeInventory();

                    ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                    BookMeta bm = (BookMeta) book.getItemMeta();
                    bm.setPages(description);
                    bm.setTitle(title);
                    bm.setAuthor(reports);
                    book.setItemMeta(bm);
                    p.getInventory().addItem(book);

                }
            }
            if(inventory.getName().equals(Reports.reportInv.getName())){
                String reports = DataFile.getData().getString("Reports." + 3 + ".Player");
                String title = DataFile.getData().getString("Reports." + 3 + ".Title");
                String description = DataFile.getData().getString("Reports." + 3 + ".Description");

                if (clicked.getType() == Material.SNOW_BALL) {
                    e.setCancelled(true);
                    p.closeInventory();

                    ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                    BookMeta bm = (BookMeta) book.getItemMeta();
                    bm.setPages(description);
                    bm.setTitle(title);
                    bm.setAuthor(reports);
                    book.setItemMeta(bm);
                    p.getInventory().addItem(book);

                }
            }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 4 + ".Player");
            String title = DataFile.getData().getString("Reports." + 4 + ".Title");
            String description = DataFile.getData().getString("Reports." + 4 + ".Description");

            if (clicked.getType() == Material.GHAST_TEAR) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 5 + ".Player");
            String title = DataFile.getData().getString("Reports." + 5 + ".Title");
            String description = DataFile.getData().getString("Reports." + 5 + ".Description");

            if (clicked.getType() == Material.RED_ROSE) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 6 + ".Player");
            String title = DataFile.getData().getString("Reports." + 6 + ".Title");
            String description = DataFile.getData().getString("Reports." + 6 + ".Description");

            if (clicked.getType() == Material.REDSTONE) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);

            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 7 + ".Player");
            String title = DataFile.getData().getString("Reports." + 7 + ".Title");
            String description = DataFile.getData().getString("Reports." + 7 + ".Description");

            if (clicked.getType() == Material.GOLD_AXE) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 8 + ".Player");
            String title = DataFile.getData().getString("Reports." + 8 + ".Title");
            String description = DataFile.getData().getString("Reports." + 8 + ".Description");

            if (clicked.getType() == Material.NETHER_BRICK) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);

            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 9 + ".Player");
            String title = DataFile.getData().getString("Reports." + 9 + ".Title");
            String description = DataFile.getData().getString("Reports." + 9 + ".Description");

            if (clicked.getType() == Material.DIAMOND_PICKAXE) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 10 + ".Player");
            String title = DataFile.getData().getString("Reports." + 10 + ".Title");
            String description = DataFile.getData().getString("Reports." + 10 + ".Description");

            if (clicked.getType() == Material.DIAMOND) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 11 + ".Player");
            String title = DataFile.getData().getString("Reports." + 11 + ".Title");
            String description = DataFile.getData().getString("Reports." + 11 + ".Description");

            if (clicked.getType() == Material.GLOWSTONE_DUST) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 12 + ".Player");
            String title = DataFile.getData().getString("Reports." + 12 + ".Title");
            String description = DataFile.getData().getString("Reports." + 12 + ".Description");

            if (clicked.getType() == Material.MUSHROOM_SOUP) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 13 + ".Player");
            String title = DataFile.getData().getString("Reports." + 13 + ".Title");
            String description = DataFile.getData().getString("Reports." + 13 + ".Description");

            if (clicked.getType() == Material.QUARTZ) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 14 + ".Player");
            String title = DataFile.getData().getString("Reports." + 14 + ".Title");
            String description = DataFile.getData().getString("Reports." + 14 + ".Description");

            if (clicked.getType() == Material.LAPIS_ORE) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 15 + ".Player");
            String title = DataFile.getData().getString("Reports." + 15 + ".Title");
            String description = DataFile.getData().getString("Reports." + 15 + ".Description");

            if (clicked.getType() == Material.PAPER) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 16 + ".Player");
            String title = DataFile.getData().getString("Reports." + 16 + ".Title");
            String description = DataFile.getData().getString("Reports." + 16 + ".Description");

            if (clicked.getType() == Material.SAPLING) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
            }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            String reports = DataFile.getData().getString("Reports." + 17 + ".Player");
            String title = DataFile.getData().getString("Reports." + 17 + ".Title");
            String description = DataFile.getData().getString("Reports." + 17 + ".Description");

            if (clicked.getType() == Material.INK_SACK) {
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(description);
                bm.setTitle(title);
                bm.setAuthor(reports);
                book.setItemMeta(bm);
                p.getInventory().addItem(book);

            }
        }
        }

    }