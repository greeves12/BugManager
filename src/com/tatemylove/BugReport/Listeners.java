package com.tatemylove.BugReport;

import com.sun.org.apache.regexp.internal.RE;
import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Misc.Reports;
import com.tatemylove.BugReport.Updater.Updater;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;

/**
 * Created by Tate on 9/6/2017.
 */
public class Listeners implements Listener {
    Main plugin;
    public Listeners(Main pl){
        plugin = pl;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(e.getPlayer().hasPermission("bugreport.joinmes")){
            this.plugin.checkUpdate(p);
            p.sendMessage(Main.prefix + "§cYou are running version " + Main.version);
            p.sendMessage(Main.prefix + "§aTo update type /bugreport update");
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inventory = e.getInventory();

        for (int k = 0; DataFile.getData().contains("Reports." + k); k++) {
            if (inventory.getName().equals(Reports.reportInv.getName())) {
                if(k < 53){
                if (e.getSlot() == k) {
                    String reports = DataFile.getData().getString("Reports." + k + ".Player");
                    String title = DataFile.getData().getString("Reports." + k + ".Title");
                    String description = DataFile.getData().getString("Reports." + k + ".Description");
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
            }else if (k == 53){
                    break;
                }


        }
        }
        if(inventory.getName().equals(Reports.reportInv.getName())){
            if(e.getSlot() == 53){
                p.closeInventory();
                Reports.createInv2();
                p.openInventory(Reports.reportInv2);

            }
        }
        for(int i = 54; DataFile.getData().contains("Reports." + i); i++){
            if(inventory.getName().equals(Reports.reportInv2.getName())){
                if(e.getSlot() == i%54){
                    String reports = DataFile.getData().getString("Reports." + i + ".Player");
                    String title = DataFile.getData().getString("Reports." + i + ".Title");
                    String description = DataFile.getData().getString("Reports." + i + ".Description");
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
        if(inventory.getName().equals(Reports.reportInv2.getName())){
            if(e.getSlot() == 45){
                p.closeInventory();
                Reports.createInv();
                p.openInventory(Reports.reportInv);
            }
        }
    }
}