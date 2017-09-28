package com.tatemylove.BugReport;

import com.tatemylove.BugReport.Commands.MainCommand;
import com.tatemylove.BugReport.Files.DataFile;
import com.tatemylove.BugReport.Misc.ConfigEditor;
import com.tatemylove.BugReport.Misc.Reminder;
import com.tatemylove.BugReport.Misc.Reports;
import com.tatemylove.BugReport.Updater.Updater;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * Created by Tate on 9/3/2017.
 */
public class Main extends JavaPlugin{
    public static String prefix = "§d[Bug§bManager] ";
    public static String version = "BugManager v1.2.9";
    private static int startCountdownId;
    public static int timeUntilStart;
    public static Inventory reportInv = Bukkit.createInventory(null, 54, "§dReports Page 1:");
    public static Inventory reportInv2 = Bukkit.createInventory(null, 54, "§dReports Page 2:");
    public static Inventory reportInv3 = Bukkit.createInventory(null, 54, "§dReports Page 3:");



    public void onEnable() {
        if(getConfig().getBoolean("auto-update") == true){
            Updater updater = new Updater(this, 277007, this.getFile(), Updater.UpdateType.DEFAULT, true);
        }

            Updater updater = new Updater(this, 277007, this.getFile(), Updater.UpdateType.NO_DOWNLOAD, false);
        startCountDown();
        ConsoleCommandSender cs = getServer().getConsoleSender();
        cs.sendMessage("§b=-=-=-Bug-Manager-=-=-=-");
        cs.sendMessage("§6Do not decompile the plugin without permission");
        cs.sendMessage("§6Do not claim this code as yours");
        cs.sendMessage("§6Altering this code, is an infringement under the copyright act");
        cs.sendMessage("§dYou are running version: " + version + " §aby: greeves12");
        cs.sendMessage("§5Latest Download is " + updater.getLatestName());
        cs.sendMessage("§b=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        Bukkit.getServer().getPluginManager().registerEvents(new Listeners(this), this);

        getConfig().options().copyDefaults(true);
        saveConfig();

        DataFile.setup(this);
        MainCommand cmd = new MainCommand(this);
        getCommand("bugreport").setExecutor(cmd);

    }
    public void updatePlugin(){
        Updater updater = new Updater(this, 277007, this.getFile(), Updater.UpdateType.NO_VERSION_CHECK, true);
    }

    public void startCountDown() {
        startCountdownId = getServer().getScheduler().scheduleSyncRepeatingTask((this), new Reminder(this), 0L, 20L);
        timeUntilStart = getConfig().getInt("reminder-interval");
    }
    public void stopCountDown(){
        getServer().getScheduler().cancelTask(startCountdownId);
    }
    public void restartCountdown(){
        stopCountDown();
        startCountDown();
    }
    public void checkUpdate(Player p){
        Updater updater = new Updater(this, 277007, this.getFile(), Updater.UpdateType.NO_DOWNLOAD, false);
            p.sendMessage(Main.prefix + "§dLatest Download is " + updater.getLatestName());
    }
    public void createReminder(){
        ItemStack one = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta oneMeta = one.getItemMeta();
        oneMeta.setDisplayName("§aCurrent Setting: §5"  + this.getConfig().getInt("reminder-interval"));
        one.setItemMeta(oneMeta);
        ConfigEditor.configReminder.setItem(4, one);

        ItemStack two = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta twoMeta = two.getItemMeta();
        twoMeta.setDisplayName("§bChange to §530");
        two.setItemMeta(twoMeta);
        ConfigEditor.configReminder.setItem(9, two);

        ItemStack three = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta threeMEta = three.getItemMeta();
        threeMEta.setDisplayName("§bChange to §560");
        three.setItemMeta(threeMEta);
        ConfigEditor.configReminder.setItem(10, three);

        ItemStack four = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta fourMeta = four.getItemMeta();
        fourMeta.setDisplayName("§bChange to §590");
        four.setItemMeta(fourMeta);
        ConfigEditor.configReminder.setItem(11, four);

        ItemStack five = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta fiveMeta = five.getItemMeta();
        fiveMeta.setDisplayName("§bChange to §5120");
        five.setItemMeta(fiveMeta);
        ConfigEditor.configReminder.setItem(12, five);

        ItemStack six = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta sixMeta = six.getItemMeta();
        sixMeta.setDisplayName("§bChange to §5150");
        six.setItemMeta(sixMeta);
        ConfigEditor.configReminder.setItem(13, six);

        ItemStack seven = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta sevenMeta = seven.getItemMeta();
        sevenMeta.setDisplayName("§bChange to §5180");
        seven.setItemMeta(sevenMeta);
        ConfigEditor.configReminder.setItem(14, seven);

        ItemStack eight = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta eightMeta = eight.getItemMeta();
        eightMeta.setDisplayName("§bChange to §5210");
        eight.setItemMeta(eightMeta);
        ConfigEditor.configReminder.setItem(15, eight);

        ItemStack nine = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta nineMeta = nine.getItemMeta();
        nineMeta.setDisplayName("§bChange to §5240");
        nine.setItemMeta(nineMeta);
        ConfigEditor.configReminder.setItem(16, nine);

        ItemStack ten = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta tenMeta = ten.getItemMeta();
        tenMeta.setDisplayName("§bChange to §5270");
        ten.setItemMeta(tenMeta);
        ConfigEditor.configReminder.setItem(17, ten);

        ItemStack exit = new ItemStack(Material.ANVIL, 1);
        ItemMeta exitMeta = exit.getItemMeta();
        exitMeta.setDisplayName("§cPrevious Page");
        exit.setItemMeta(exitMeta);
        ConfigEditor.configReminder.setItem(22, exit);
    }
    public void createUpdater(){
        ItemStack stack = new ItemStack(Material.ENDER_CHEST);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§aCurrent Setting: §5" + this.getConfig().getBoolean("auto-update"));
        stack.setItemMeta(meta);
        ConfigEditor.configAutoUpdater.setItem(4, stack);

        ItemStack on = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta onMeta = on.getItemMeta();
        onMeta.setDisplayName("§bChange to §5true");
        on.setItemMeta(onMeta);
        ConfigEditor.configAutoUpdater.setItem(9, on);

        ItemStack off = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta offMeta = off.getItemMeta();
        offMeta.setDisplayName("§bChange to §5false");
        off.setItemMeta(offMeta);
        ConfigEditor.configAutoUpdater.setItem(17, off);

        ItemStack exit = new ItemStack(Material.ANVIL, 1);
        ItemMeta exitMeta = exit.getItemMeta();
        exitMeta.setDisplayName("§cPrevious Page");
        exit.setItemMeta(exitMeta);
        ConfigEditor.configAutoUpdater.setItem(22, exit);
    }
    public void createJoinMessage(){
        ItemStack stack = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§aCurrent Setting: §5" + this.getConfig().getBoolean("join-message"));
        stack.setItemMeta(meta);
        ConfigEditor.configJoinMessage.setItem(4, stack);

        ItemStack on = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta onMeta = on.getItemMeta();
        onMeta.setDisplayName("§bChange to §5true");
        on.setItemMeta(onMeta);
        ConfigEditor.configJoinMessage.setItem(9, on);

        ItemStack off = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta offMeta = off.getItemMeta();
        offMeta.setDisplayName("§bChange to §5false");
        off.setItemMeta(offMeta);
        ConfigEditor.configJoinMessage.setItem(17, off);

        ItemStack exit = new ItemStack(Material.ANVIL, 1);
        ItemMeta exitMeta = exit.getItemMeta();
        exitMeta.setDisplayName("§cPrevious Page");
        exit.setItemMeta(exitMeta);
        ConfigEditor.configJoinMessage.setItem(22, exit);
    }
}
