package com.tatemylove.BugReport;

import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Misc.ConfigEditor;
import com.tatemylove.BugReport.Misc.Reports;
import com.tatemylove.BugReport.Plugin.ThisPlugin;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.server.v1_12_R1.PacketDataSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutCustomPayload;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;


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
        if(!Reports.coolDown.containsKey(e.getPlayer().getUniqueId())){
            Reports.coolDown.put(e.getPlayer().getUniqueId(), 0L);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inventory = e.getInventory();
        for (String i : DataFile.getData().getConfigurationSection("Reports.").getKeys(false)) {
            int k = Integer.parseInt(i);
            if (inventory.getName().equals(Main.reportInv.getName())) {
                if(k < 52){
                if (e.getSlot() == k) {


                    String reports = DataFile.getData().getString("Reports." + k + ".Player");
                    String title = DataFile.getData().getString("Reports." + k + ".Title");
                    String description = DataFile.getData().getString("Reports." + k + ".Description");
                    e.setCancelled(true);
                    p.closeInventory();

                    ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                    BookMeta bm = (BookMeta) book.getItemMeta();
                    bm.setDisplayName("§dReport # " + k);
                    bm.setPages("§dReport Number: " + k + "\n\n" +"§2Player: " + reports + "\n\n" +"§9Title: " + title + "\n\n" +"§6Description:" + "\n§0" + description);
                    bm.setTitle(title);
                    bm.setAuthor(reports);
                    book.setItemMeta(bm);

                    int slot = p.getInventory().getHeldItemSlot();
                    ItemStack old = p.getInventory().getItem(slot);

                    p.getInventory().setItem(slot, book);

                    ByteBuf buf = Unpooled.buffer(256);
                    buf.setByte(0, (byte)0);
                    buf.writerIndex(1);

                    PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
                    CraftPlayer cp = (CraftPlayer)p;
                    cp.getHandle().playerConnection.sendPacket(packet);

                    p.getInventory().setItem(slot, old);
                    p.sendMessage(Main.prefix + "Received Report # " + "§d" + k);
                }
            }else if (k == 52) {
                    break;
                }
        }
        }
        if(inventory.getName().equals(Main.reportInv.getName())){
            if(e.getSlot() == 53){
                p.closeInventory();
                Reports.createInv2(p);
                //p.openInventory(Main.reportInv2);

            }
        }
        for(String k : DataFile.getData().getConfigurationSection("Reports.").getKeys(false)){
            int i = Integer.parseInt(k);
            if(inventory.getName().equals(Main.reportInv2.getName())){

                    if (i >= 53) {
                        if(e.getSlot() == i%53) {
                        String reports = DataFile.getData().getString("Reports." + i + ".Player");
                        String title = DataFile.getData().getString("Reports." + i + ".Title");
                        String description = DataFile.getData().getString("Reports." + i + ".Description");
                        e.setCancelled(true);
                        p.closeInventory();

                        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                        BookMeta bm = (BookMeta) book.getItemMeta();
                        bm.setDisplayName("§dReport # " +i);
                        bm.setPages("§dReport Number: " + i + "\n\n" +"§2Player: " + reports + "\n\n" +"§9Title: " + title + "\n\n" +"§6Description:" + "\n§0" + description);
                        bm.setTitle(title);
                        bm.setAuthor(reports);
                        book.setItemMeta(bm);
                            int slot = p.getInventory().getHeldItemSlot();
                            ItemStack old = p.getInventory().getItem(slot);

                            p.getInventory().setItem(slot, book);

                            ByteBuf buf = Unpooled.buffer(256);
                            buf.setByte(0, (byte)0);
                            buf.writerIndex(1);

                            PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
                            CraftPlayer cp = (CraftPlayer)p;
                            cp.getHandle().playerConnection.sendPacket(packet);

                            p.getInventory().setItem(slot, old);
                        p.sendMessage(Main.prefix + "Received Report # " + "§d" + i);
                    }else if(i == 97){
                        break;
                    }
                }
            }
        }
        if(inventory.getName().equals(Main.reportInv2.getName())){
            if(e.getSlot() == 45){
                p.closeInventory();
                Reports.createInv(p);
                //p.openInventory(Main.reportInv);

            }
        }
        if(inventory.getName().equalsIgnoreCase(Main.reportInv2.getName())){
            if(e.getSlot() == 53){
                p.closeInventory();
                Reports.createInv3(p);
                //p.openInventory(Main.reportInv3);

            }
        }
        if(inventory.getName().equalsIgnoreCase(Main.reportInv3.getName())){
            if(e.getSlot() == 45){
                p.closeInventory();
                Reports.createInv2(p);
               // p.openInventory(Main.reportInv2);

            }
            if(e.getSlot() == 53){
                p.closeInventory();
                Reports.createInv4(p);
                //p.openInventory(Main.reportInv4);

            }
        }
        if(inventory.getName().equalsIgnoreCase(Main.reportInv4.getName())){
            if(e.getSlot() == 45){
                p.closeInventory();
                Reports.createInv3(p);
                //p.openInventory(Main.reportInv3);

            }
        }
        for(String k : DataFile.getData().getConfigurationSection("Reports.").getKeys(false)){
            int j = Integer.parseInt(k);
            if(inventory.getName().equals(Main.reportInv3.getName())){
                    if(j >= 98){
                        if(e.getSlot() == j%98){
                        String reports = DataFile.getData().getString("Reports." + j + ".Player");
                        String title = DataFile.getData().getString("Reports." + j + ".Title");
                        String description = DataFile.getData().getString("Reports." + j + ".Description");
                        e.setCancelled(true);
                        p.closeInventory();

                        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                        BookMeta bm = (BookMeta) book.getItemMeta();
                        bm.setDisplayName("§dReport # " + j);
                        bm.setPages("§dReport Number: " + j + "\n\n" +"§2Player: " + reports + "\n\n" +"§9Title: " + title + "\n\n" +"§6Description:" + "\n§0" + description);
                        bm.setTitle(title);
                        bm.setAuthor(reports);
                        book.setItemMeta(bm);
                            int slot = p.getInventory().getHeldItemSlot();
                            ItemStack old = p.getInventory().getItem(slot);

                            p.getInventory().setItem(slot, book);

                            ByteBuf buf = Unpooled.buffer(256);
                            buf.setByte(0, (byte)0);
                            buf.writerIndex(1);

                            PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
                            CraftPlayer cp = (CraftPlayer)p;
                            cp.getHandle().playerConnection.sendPacket(packet);

                            p.getInventory().setItem(slot, old);
                        p.sendMessage(Main.prefix + "Received Report # " + "§d" + j);
                    }else if(j == 142){
                        break;
                    }
                }
            }
        }
        for(String k : DataFile.getData().getConfigurationSection("Reports.").getKeys(false)){
            if(inventory.getName().equals(Main.reportInv4.getName())){
                int j = Integer.parseInt(k);
                    if(j >= 143){
                        if(e.getSlot() == j%143){
                        String reports = DataFile.getData().getString("Reports." + j + ".Player");
                        String title = DataFile.getData().getString("Reports." + j + ".Title");
                        String description = DataFile.getData().getString("Reports." + j + ".Description");
                        e.setCancelled(true);
                        p.closeInventory();

                        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                        BookMeta bm = (BookMeta) book.getItemMeta();
                        bm.setDisplayName("§dReport # " + j);
                        bm.setPages("§dReport Number: " + j + "\n\n" +"§2Player: " + reports + "\n\n" +"§9Title: " + title + "\n\n" +"§6Description:" + "\n§0" + description);
                        bm.setTitle(title);
                        bm.setAuthor(reports);
                        book.setItemMeta(bm);
                            int slot = p.getInventory().getHeldItemSlot();
                            ItemStack old = p.getInventory().getItem(slot);

                            p.getInventory().setItem(slot, book);

                            ByteBuf buf = Unpooled.buffer(256);
                            buf.setByte(0, (byte)0);
                            buf.writerIndex(1);

                            PacketPlayOutCustomPayload packet = new PacketPlayOutCustomPayload("MC|BOpen", new PacketDataSerializer(buf));
                            CraftPlayer cp = (CraftPlayer)p;
                            cp.getHandle().playerConnection.sendPacket(packet);

                            p.getInventory().setItem(slot, old);
                        p.sendMessage(Main.prefix + "Received Report # " + "§d" + j);
                    }else if (j == 187){
                        break;
                    }
                }
            }
        }
    }

    @EventHandler
    public void configClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Inventory inventory = e.getInventory();
        if(inventory.getName().equals(ConfigEditor.configInv.getName())){
            if(e.getSlot() == 0){
                p.closeInventory();
                ConfigEditor.createReminder();
                p.openInventory(ConfigEditor.configReminder);
            }
            if(e.getSlot() == 22){
                e.setCancelled(true);
                p.closeInventory();
            }
            if(e.getSlot() == 4){
                p.closeInventory();
                ConfigEditor.createUpdater();
                p.openInventory(ConfigEditor.configAutoUpdater);
            }
            if(e.getSlot() == 2){
                p.closeInventory();
                ConfigEditor.createJoinMessage();
                p.openInventory(ConfigEditor.configJoinMessage);
            }
            if(e.getSlot() == 6){
                p.closeInventory();
                ConfigEditor.createCoolDown();
                p.openInventory(ConfigEditor.configCooldown);
            }
            if(e.getSlot() == 8){
                e.setCancelled(true);
            }
        }

        if(inventory.getName().equals(ConfigEditor.configReminder.getName())){
            if(e.getSlot() == 4){
                e.setCancelled(true);
            }
            if(e.getSlot() == 9){
                int current = ThisPlugin.getPlugin().getConfig().getInt("reminder-interval");
                ThisPlugin.getPlugin().getConfig().set("reminder-interval", current+5);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createReminder();
                p.openInventory(ConfigEditor.configReminder);
                p.sendMessage(Main.prefix + "§aSuccessfully changed reminder-interval to: §5" + this.plugin.getConfig().getInt("reminder-interval"));
            }
            if(e.getSlot() == 10){
                int current = ThisPlugin.getPlugin().getConfig().getInt("reminder-interval");
                this.plugin.getConfig().set("reminder-interval", current+10);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createReminder();
                p.openInventory(ConfigEditor.configReminder);
                p.sendMessage(Main.prefix + "§aSuccessfully changed reminder-interval to: §5" + this.plugin.getConfig().getInt("reminder-interval"));
            }
            if(e.getSlot() == 11){
                int current = ThisPlugin.getPlugin().getConfig().getInt("reminder-interval");
                this.plugin.getConfig().set("reminder-interval", current+50);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createReminder();
                p.openInventory(ConfigEditor.configReminder);
                p.sendMessage(Main.prefix + "§aSuccessfully changed reminder-interval to: §5" + this.plugin.getConfig().getInt("reminder-interval"));
            }
            if(e.getSlot() == 12){
                int current = ThisPlugin.getPlugin().getConfig().getInt("reminder-interval");
                this.plugin.getConfig().set("reminder-interval", current+100);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createReminder();
                p.openInventory(ConfigEditor.configReminder);
                p.sendMessage(Main.prefix + "§aSuccessfully changed reminder-interval to: §5" + this.plugin.getConfig().getInt("reminder-interval"));
            }
            if(e.getSlot() == 14){
                int current = ThisPlugin.getPlugin().getConfig().getInt("reminder-interval");
                this.plugin.getConfig().set("reminder-interval", current-100);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createReminder();
                p.openInventory(ConfigEditor.configReminder);
                p.sendMessage(Main.prefix + "§aSuccessfully changed reminder-interval to: §5" + this.plugin.getConfig().getInt("reminder-interval"));

            }
            if(e.getSlot() == 15){
                int current = ThisPlugin.getPlugin().getConfig().getInt("reminder-interval");
                this.plugin.getConfig().set("reminder-interval", current-50);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createReminder();
                p.openInventory(ConfigEditor.configReminder);
                p.sendMessage(Main.prefix + "§aSuccessfully changed reminder-interval to: §5" + this.plugin.getConfig().getInt("reminder-interval"));
            }
            if(e.getSlot() == 16){
                int current = ThisPlugin.getPlugin().getConfig().getInt("reminder-interval");
                this.plugin.getConfig().set("reminder-interval", current-10);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createReminder();
                p.openInventory(ConfigEditor.configReminder);
                p.sendMessage(Main.prefix + "§aSuccessfully changed reminder-interval to: §5" + this.plugin.getConfig().getInt("reminder-interval"));
            }
            if(e.getSlot() == 17){
                int current = ThisPlugin.getPlugin().getConfig().getInt("reminder-interval");
                this.plugin.getConfig().set("reminder-interval", current-5);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createReminder();
                p.openInventory(ConfigEditor.configReminder);
                p.sendMessage(Main.prefix + "§aSuccessfully changed reminder-interval to: §5" + this.plugin.getConfig().getInt("reminder-interval"));
            }
            if(e.getSlot() == 22){
                p.closeInventory();
                ConfigEditor.createConfig();
                p.openInventory(ConfigEditor.configInv);
            }
        }
        if(inventory.getName().equals(ConfigEditor.configAutoUpdater.getName())){
            if(e.getSlot() == 4){
                e.setCancelled(true);
            }
            if(e.getSlot() == 9){
                this.plugin.getConfig().set("auto-update", true);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                ConfigEditor.createUpdater();
                p.closeInventory();
                p.openInventory(ConfigEditor.configAutoUpdater);
                p.sendMessage(Main.prefix + "§aSuccessfully changed auto-update to: §5" + this.plugin.getConfig().getBoolean("auto-update"));
            }
            if(e.getSlot() == 17){
                this.plugin.getConfig().set("auto-update", false);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                ConfigEditor.createUpdater();
                p.closeInventory();
                p.openInventory(ConfigEditor.configAutoUpdater);
                p.sendMessage(Main.prefix + "§aSuccessfully changed auto-update to: §5" + this.plugin.getConfig().getBoolean("auto-update"));
            }
            if(e.getSlot() == 22){
                p.closeInventory();
                ConfigEditor.createConfig();
                p.openInventory(ConfigEditor.configInv);
            }
        }
        if(inventory.getName().equals(ConfigEditor.configJoinMessage.getName())){
            if(e.getSlot() == 9){
                this.plugin.getConfig().set("join-message", true);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createJoinMessage();
                p.openInventory(ConfigEditor.configJoinMessage);
                p.sendMessage(Main.prefix + "§aSuccessfully changed join-message to: §5" + this.plugin.getConfig().getBoolean("join-message"));
            }
            if(e.getSlot() == 17){
                this.plugin.getConfig().set("join-message", false);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createJoinMessage();
                p.openInventory(ConfigEditor.configJoinMessage);
                p.sendMessage(Main.prefix + "§aSuccessfully changed join-message to: §5" + this.plugin.getConfig().getBoolean("join-message"));
            }
            if(e.getSlot() == 22){
                p.closeInventory();
                ConfigEditor.createConfig();
                p.openInventory(ConfigEditor.configInv);
            }
        }
        if(inventory.getName().equals(ConfigEditor.configCooldown.getName())){
            if(e.getSlot() == 4){
                e.setCancelled(true);
            }
            if(e.getSlot() == 9){
                int current = ThisPlugin.getPlugin().getConfig().getInt("cool-down");
                ThisPlugin.getPlugin().getConfig().set("cool-down", current+5);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createCoolDown();
                p.openInventory(ConfigEditor.configCooldown);
                p.sendMessage(Main.prefix + "§aSuccessfully changed cooldown to: §5" + this.plugin.getConfig().getInt("cool-down"));
            }
            if(e.getSlot() == 10){
                int current = ThisPlugin.getPlugin().getConfig().getInt("cool-down");
                this.plugin.getConfig().set("cool-down", current+10);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createCoolDown();
                p.openInventory(ConfigEditor.configCooldown);
                p.sendMessage(Main.prefix + "§aSuccessfully changed cool-down to: §5" + this.plugin.getConfig().getInt("cool-down"));
            }
            if(e.getSlot() == 11){
                int current = ThisPlugin.getPlugin().getConfig().getInt("cool-down");
                this.plugin.getConfig().set("cool-down", current+50);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createCoolDown();
                p.openInventory(ConfigEditor.configCooldown);
                p.sendMessage(Main.prefix + "§aSuccessfully changed cool-down to: §5" + this.plugin.getConfig().getInt("cool-down"));
            }
            if(e.getSlot() == 12){
                int current = ThisPlugin.getPlugin().getConfig().getInt("cool-down");
                this.plugin.getConfig().set("cool-down", current+100);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createCoolDown();
                p.openInventory(ConfigEditor.configCooldown);
                p.sendMessage(Main.prefix + "§aSuccessfully changed cool-down to: §5" + this.plugin.getConfig().getInt("cool-down"));
            }
            if(e.getSlot() == 14){
                int current = ThisPlugin.getPlugin().getConfig().getInt("cool-down");
                this.plugin.getConfig().set("cool-down", current-100);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createCoolDown();
                p.openInventory(ConfigEditor.configCooldown);
                p.sendMessage(Main.prefix + "§aSuccessfully changed cool-down to: §5" + this.plugin.getConfig().getInt("cool-down"));
            }
            if(e.getSlot() == 15){
                int current = ThisPlugin.getPlugin().getConfig().getInt("cool-down");
                this.plugin.getConfig().set("cool-down", current-50);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createCoolDown();
                p.openInventory(ConfigEditor.configCooldown);
                p.sendMessage(Main.prefix + "§aSuccessfully changed cool-down to: §5" + this.plugin.getConfig().getInt("cool-down"));
            }
            if(e.getSlot() == 16){
                int current = ThisPlugin.getPlugin().getConfig().getInt("cool-down");
                this.plugin.getConfig().set("cool-down", current-10);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createCoolDown();
                p.openInventory(ConfigEditor.configCooldown);
                p.sendMessage(Main.prefix + "§aSuccessfully changed cool-down to: §5" + this.plugin.getConfig().getInt("cool-down"));
            }
            if(e.getSlot() == 17){
                int current = ThisPlugin.getPlugin().getConfig().getInt("cool-down");
                this.plugin.getConfig().set("cool-down", current-5);
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.closeInventory();
                ConfigEditor.createCoolDown();
                p.openInventory(ConfigEditor.configCooldown);
                p.sendMessage(Main.prefix + "§aSuccessfully changed cool-down to: §5" + this.plugin.getConfig().getInt("cool-down"));
            }
            if(e.getSlot() == 22){
                p.closeInventory();
                ConfigEditor.createConfig();
                p.openInventory(ConfigEditor.configInv);
            }
        }
    }
}