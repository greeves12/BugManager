package com.tatemylove.BugReport.Misc;

import com.tatemylove.BugReport.Main;
import com.tatemylove.BugReport.Plugin.ThisPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


/**
 * Created by Tate on 9/26/2017.
 */
public class ConfigEditor {

    Main plugin;
    public ConfigEditor(Main pl){
        plugin = pl;
    }
    public static Inventory configInv = Bukkit.createInventory(null, 27, "§5Config Editor");
    public static Inventory configReminder = Bukkit.createInventory(null, 27, "§5Reminder Interval");
    public static Inventory configAutoUpdater = Bukkit.createInventory(null, 27, "§5Auto Updater");
    public static Inventory configJoinMessage = Bukkit.createInventory(null, 27, "§5Join Message");
    public static Inventory configCooldown = Bukkit.createInventory(null, 27, "§5CoolDown Interval");

    public static void createConfig(){
        ItemStack stack = new ItemStack(Material.WOOL, 1, (byte) 3);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§aReminder Interval");
        stack.setItemMeta(meta);
        configInv.setItem(0, stack);

        ItemStack two = new ItemStack(Material.WOOL, 1, (byte) 6);
        ItemMeta twoMeta = two.getItemMeta();
        twoMeta.setDisplayName("§bAutoUpdater");
        two.setItemMeta(twoMeta);
        configInv.setItem(4, two);

        ItemStack closeInv = new ItemStack(Material.ANVIL, 1);
        ItemMeta closeMeta = closeInv.getItemMeta();
        closeMeta.setDisplayName("§cExit");
        closeInv.setItemMeta(closeMeta);
        configInv.setItem(22, closeInv);

        ItemStack joinMes = new ItemStack(Material.WOOL, 1, (byte) 14);
        ItemMeta joinMeta = joinMes.getItemMeta();
        joinMeta.setDisplayName("§3Join-Message");
        joinMes.setItemMeta(joinMeta);
        configInv.setItem(2, joinMes);

        ItemStack cooldown = new ItemStack(Material.WOOL, 1, (byte) 5);
        ItemMeta coolMeta = cooldown.getItemMeta();
        coolMeta.setDisplayName("§9CoolDown Interval");
        cooldown.setItemMeta(coolMeta);
        configInv.setItem(6, cooldown);

        ItemStack tba = new ItemStack(Material.WOOL,1, (byte) 15);
        ItemMeta tbaMeta = tba.getItemMeta();
        tbaMeta.setDisplayName("§cComing Soon");
        tba.setItemMeta(tbaMeta);
        configInv.setItem(8, tba);
    }
    public static void createReminder(){
        ItemStack one = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta oneMeta = one.getItemMeta();
        oneMeta.setDisplayName("§aCurrent Setting: §5"  + ThisPlugin.getPlugin().getConfig().getInt("reminder-interval"));
        one.setItemMeta(oneMeta);
        ConfigEditor.configReminder.setItem(4, one);

        ItemStack two = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta twoMeta = two.getItemMeta();
        twoMeta.setDisplayName("§bAdd §55");
        two.setItemMeta(twoMeta);
        ConfigEditor.configReminder.setItem(9, two);

        ItemStack three = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta threeMEta = three.getItemMeta();
        threeMEta.setDisplayName("§bAdd §510");
        three.setItemMeta(threeMEta);
        ConfigEditor.configReminder.setItem(10, three);

        ItemStack four = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta fourMeta = four.getItemMeta();
        fourMeta.setDisplayName("§bAdd §550");
        four.setItemMeta(fourMeta);
        ConfigEditor.configReminder.setItem(11, four);

        ItemStack five = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta fiveMeta = five.getItemMeta();
        fiveMeta.setDisplayName("§bAdd §5100");
        five.setItemMeta(fiveMeta);
        ConfigEditor.configReminder.setItem(12, five);


        ItemStack seven = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta sevenMeta = seven.getItemMeta();
        sevenMeta.setDisplayName("§bSubtract §5100");
        seven.setItemMeta(sevenMeta);
        ConfigEditor.configReminder.setItem(14, seven);

        ItemStack eight = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta eightMeta = eight.getItemMeta();
        eightMeta.setDisplayName("§bSubtract §550");
        eight.setItemMeta(eightMeta);
        ConfigEditor.configReminder.setItem(15, eight);

        ItemStack nine = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta nineMeta = nine.getItemMeta();
        nineMeta.setDisplayName("§bSubtract §510");
        nine.setItemMeta(nineMeta);
        ConfigEditor.configReminder.setItem(16, nine);

        ItemStack ten = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta tenMeta = ten.getItemMeta();
        tenMeta.setDisplayName("§bSubtract §55");
        ten.setItemMeta(tenMeta);
        ConfigEditor.configReminder.setItem(17, ten);

        ItemStack exit = new ItemStack(Material.ANVIL, 1);
        ItemMeta exitMeta = exit.getItemMeta();
        exitMeta.setDisplayName("§cPrevious Page");
        exit.setItemMeta(exitMeta);
        ConfigEditor.configReminder.setItem(22, exit);
    }
    public static void createUpdater(){
        ItemStack stack = new ItemStack(Material.ENDER_CHEST);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§aCurrent Setting: §5" + ThisPlugin.getPlugin().getConfig().getBoolean("auto-update"));
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
    public static void createJoinMessage(){
        ItemStack stack = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§aCurrent Setting: §5" + ThisPlugin.getPlugin().getConfig().getBoolean("join-message"));
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
    public static void createCoolDown(){
        ItemStack stack = new ItemStack(Material.ENDER_CHEST, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§aCurrent Setting: §5" + ThisPlugin.getPlugin().getConfig().getInt("cool-down"));
        stack.setItemMeta(meta);
        configCooldown.setItem(4, stack);

        ItemStack two = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta twoMeta = two.getItemMeta();
        twoMeta.setDisplayName("§bAdd §55");
        two.setItemMeta(twoMeta);
        ConfigEditor.configCooldown.setItem(9, two);

        ItemStack three = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta threeMEta = three.getItemMeta();
        threeMEta.setDisplayName("§bAdd §510");
        three.setItemMeta(threeMEta);
        ConfigEditor.configCooldown.setItem(10, three);

        ItemStack four = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta fourMeta = four.getItemMeta();
        fourMeta.setDisplayName("§bAdd §550");
        four.setItemMeta(fourMeta);
        ConfigEditor.configCooldown.setItem(11, four);

        ItemStack five = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta fiveMeta = five.getItemMeta();
        fiveMeta.setDisplayName("§bAdd §5100");
        five.setItemMeta(fiveMeta);
        ConfigEditor.configCooldown.setItem(12, five);


        ItemStack seven = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta sevenMeta = seven.getItemMeta();
        sevenMeta.setDisplayName("§bSubtract §5100");
        seven.setItemMeta(sevenMeta);
        ConfigEditor.configCooldown.setItem(14, seven);

        ItemStack eight = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta eightMeta = eight.getItemMeta();
        eightMeta.setDisplayName("§bSubtract §550");
        eight.setItemMeta(eightMeta);
        ConfigEditor.configCooldown.setItem(15, eight);

        ItemStack nine = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta nineMeta = nine.getItemMeta();
        nineMeta.setDisplayName("§bSubtract §510");
        nine.setItemMeta(nineMeta);
        ConfigEditor.configCooldown.setItem(16, nine);

        ItemStack ten = new ItemStack(Material.EYE_OF_ENDER, 1);
        ItemMeta tenMeta = ten.getItemMeta();
        tenMeta.setDisplayName("§bSubtract §55");
        ten.setItemMeta(tenMeta);
        ConfigEditor.configCooldown.setItem(17, ten);

        ItemStack exit = new ItemStack(Material.ANVIL, 1);
        ItemMeta exitMeta = exit.getItemMeta();
        exitMeta.setDisplayName("§cPrevious Page");
        exit.setItemMeta(exitMeta);
        ConfigEditor.configCooldown.setItem(22, exit);
    }
}
