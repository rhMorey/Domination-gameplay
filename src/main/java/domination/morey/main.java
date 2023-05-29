package domination.morey;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import domination.morey.economy.cmds.gmoneyCmds;
import domination.morey.economy.cmds.moneyCmds;
import domination.morey.economy.moneyManage;
import domination.morey.experience.cmds.glevelCmds;
import domination.morey.experience.cmds.gxpCmds;
import domination.morey.experience.cmds.levelCmds;
import domination.morey.experience.cmds.xpCmds;
import domination.morey.experience.level;
import domination.morey.gamemode.capture;
import domination.morey.gamemode.gameplay;
import domination.morey.npc.customItem.FauxInutilisee;
import domination.morey.npc.npcManager;
import domination.morey.npc.pnj.Doran;
import domination.morey.team.team;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public final class main extends JavaPlugin {


    public static main plugin;
    private static main instance;

    @Override
    public void onEnable() {

        plugin = this;
        instance = this;
        Logger logger = getLogger();
        logger.info("Domination has been enabled!");
        saveDefaultConfig();

        Bukkit.getPluginCommand("money").setExecutor(new moneyCmds());
        Bukkit.getPluginCommand("gmoney").setExecutor(new gmoneyCmds());
        Bukkit.getPluginCommand("gxp").setExecutor(new gxpCmds());
        Bukkit.getPluginCommand("glevel").setExecutor(new glevelCmds());
        Bukkit.getPluginCommand("xp").setExecutor(new xpCmds());
        Bukkit.getPluginCommand("level").setExecutor(new levelCmds());
        Bukkit.getPluginManager().registerEvents(new team(), this);
        Bukkit.getPluginManager().registerEvents(new capture(), this);
        Bukkit.getPluginManager().registerEvents(new moneyManage(), this);
        Bukkit.getPluginManager().registerEvents(new mainEvent(), this);
        Bukkit.getPluginManager().registerEvents(new gameplay(), this);
        Bukkit.getPluginManager().registerEvents(new level(), this);
        Bukkit.getPluginManager().registerEvents(new npcManager(), this);

        // NPC
        Bukkit.getPluginManager().registerEvents(new Doran(), this);
        // NPC

        // ITEMS
        Bukkit.getPluginManager().registerEvents(new FauxInutilisee(), this);
        // ITEMS

        // FLAGS
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag1(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag2(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag3(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag4(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag5(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag6(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag7(), this);
        // FLAGS
    }

    @Override
    public void onDisable() {

        Logger logger = getLogger();
        logger.info("Domination has been disabled!");
    }

    public static main getInstance() {
        return instance;
    }

    public static String prefix = "§c§l(!) §c";

    public static Block getCenter(ProtectedRegion region, int y) {
        BlockVector3 minPoint = region.getMinimumPoint();
        BlockVector3 maxPoint = region.getMaximumPoint();

        double centerX = (minPoint.getX() + maxPoint.getX()) / 2.0;
        double centerZ = (minPoint.getZ() + maxPoint.getZ()) / 2.0;

        World world = Bukkit.getWorld("world");
        Location centerLocation = new Location(world, centerX, y, centerZ);

        return centerLocation.getBlock();
    }

    //
    // ITEMSTACK
    //
    public static ItemStack Item(Material mat, String name){

        ItemStack I = new ItemStack(mat);
        ItemMeta IM = I.getItemMeta();
        assert IM != null;
        IM.setDisplayName(name);
        I.setItemMeta(IM);
        return I;
    }
    public static ItemStack Item(Material mat, String name, String lore1) {

        ItemStack I = new ItemStack(mat);
        ItemMeta IM = I.getItemMeta();
        List<String> ILore = new ArrayList<>();
        ILore.add(String.valueOf(lore1));
        IM.setLore(ILore);
        IM.setDisplayName(name);
        I.setItemMeta(IM);
        return I;
    }
    public static ItemStack Item(Material mat, String name, String lore1, String lore2) {

        ItemStack I = new ItemStack(mat);
        ItemMeta IM = I.getItemMeta();
        List<String> ILore = new ArrayList<>();
        ILore.add(String.valueOf(lore1));
        ILore.add(String.valueOf(lore2));
        IM.setLore(ILore);
        IM.setDisplayName(name);
        I.setItemMeta(IM);
        return I;
    }
    public static ItemStack Item(Material mat, String name, String lore1, String lore2, String lore3) {

        ItemStack I = new ItemStack(mat);
        ItemMeta IM = I.getItemMeta();
        List<String> ILore = new ArrayList<>();
        ILore.add(String.valueOf(lore1));
        ILore.add(String.valueOf(lore2));
        ILore.add(String.valueOf(lore3));
        IM.setLore(ILore);
        IM.setDisplayName(name);
        I.setItemMeta(IM);
        return I;
    }
    public static ItemStack Item(Material mat, String name, String lore1, String lore2, String lore3, String lore4) {

        ItemStack I = new ItemStack(mat);
        ItemMeta IM = I.getItemMeta();
        List<String> ILore = new ArrayList<>();
        ILore.add(String.valueOf(lore1));
        ILore.add(String.valueOf(lore2));
        ILore.add(String.valueOf(lore3));
        ILore.add(String.valueOf(lore4));
        IM.setLore(ILore);
        IM.setDisplayName(name);
        I.setItemMeta(IM);
        return I;
    }

    public static ItemStack Item(Material mat, String name, String lore1, String lore2, String lore3, String lore4, String lore5) {

        ItemStack I = new ItemStack(mat);
        ItemMeta IM = I.getItemMeta();
        List<String> ILore = new ArrayList<>();
        ILore.add(String.valueOf(lore1));
        ILore.add(String.valueOf(lore2));
        ILore.add(String.valueOf(lore3));
        ILore.add(String.valueOf(lore4));
        ILore.add(String.valueOf(lore5));
        IM.setLore(ILore);
        IM.setDisplayName(name);
        I.setItemMeta(IM);
        return I;
    }

    public static ItemStack Item(Material mat, String name, String lore1, String lore2, String lore3, String lore4, String lore5, String lore6) {

        ItemStack I = new ItemStack(mat);
        ItemMeta IM = I.getItemMeta();
        List<String> ILore = new ArrayList<>();
        ILore.add(String.valueOf(lore1));
        ILore.add(String.valueOf(lore2));
        ILore.add(String.valueOf(lore3));
        ILore.add(String.valueOf(lore4));
        ILore.add(String.valueOf(lore5));
        ILore.add(String.valueOf(lore6));
        IM.setLore(ILore);
        IM.setDisplayName(name);
        I.setItemMeta(IM);
        return I;
    }
}
