package com.tatemylove.BugReport;

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
public class Listeners implements Listener{

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();
        final ArrayList<String> reports = new ArrayList<>();
        final ArrayList<String> title = new ArrayList<>();
        final ArrayList<String> description = new ArrayList<>();
        reports.add(DataFile.getData().getString("Reports." + Reports.chooseReport() + ".Player"));
        title.add(DataFile.getData().getString("Reports." + Reports.chooseReport2() + ".Title"));
        description.add(DataFile.getData().getString("Reports." + Reports.chooseReport3() + ".Description"));

        if(inventory.getName().equals(Reports.reportInv.getName())){
            Reports.k = 0;
            Reports.k2 = 0;
            Reports.k3 = 0;
            if(clicked.getType() == Material.BOOK){
                e.setCancelled(true);
                p.closeInventory();

                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.setPages(String.valueOf(description.get(0)));
                bm.setTitle(String.valueOf(title.get(0)));
                bm.setAuthor(String.valueOf(reports.get(0)));
                book.setItemMeta(bm);
                p.getInventory().addItem(book);
                reports.clear();
                title.clear();
            }
        }
    }

}
