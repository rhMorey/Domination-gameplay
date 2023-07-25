package domination.morey;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import domination.morey.customItems.armor.GladiateurReinforced;
import domination.morey.customItems.armor.fullset.GardienOmbre;
import domination.morey.customItems.armor.fullset.OmbreEnvoutante;
import domination.morey.customItems.armor.fullset.effect.GardienOmbreEffect;
import domination.morey.customItems.armor.fullset.effect.OmbreEnvoutanteEffect;
import domination.morey.customItems.ingredients.CuirEnergie;
import domination.morey.customItems.ingredients.FerEnergie;
import domination.morey.customItems.ingredients.FragmentOmbre;
import domination.morey.customItems.ingredients.SolidificationArmure;
import domination.morey.customItems.items.ElectroLame;
import domination.morey.customItems.items.LanterneOmbre;
import domination.morey.customItems.items.effect.ElectroLameEffect;
import domination.morey.customItems.itemsEvent.LanterneOmbreEvents;
import domination.morey.dungeons.customMobs;
import domination.morey.economy.cmds.gmoneyCmds;
import domination.morey.economy.cmds.moneyCmds;
import domination.morey.dungeons.loot.emeraldNuggets;
import domination.morey.economy.moneyManage;
import domination.morey.experience.cmds.*;
import domination.morey.experience.leveling.leveling;
import domination.morey.experience.cmds.tabCompleter.transferTabCompleter;
import domination.morey.experience.level;
import domination.morey.fortress.capture.captureSystem;
import domination.morey.fortress.cmds.golemCmds;
import domination.morey.fortress.fortressManager;
import domination.morey.gamemode.capture;
import domination.morey.gamemode.gameplay;
import domination.morey.npc.cmds.tabCompleter.whereisTabCompleter;
import domination.morey.npc.cmds.whereisCmds;
import domination.morey.npc.pnj.bank.Banquier;
import domination.morey.npc.pnj.seller.CollectionneurDepouille;
import domination.morey.npc.pnj.seller.EchangeurFortune;
import domination.morey.npc.pnj.seller.MembreCreynois;
import domination.morey.npc.specialItem.*;
import domination.morey.npc.npcManager;
import domination.morey.npc.pnj.vendor.*;
import domination.morey.npc.specialItem.fullset.*;
import domination.morey.team.team;
import domination.morey.team.whichclass.classeEvent;
import domination.morey.team.whichclass.tabCompleter.classeTabCompleter;
import domination.morey.team.whichclass.classeCmds;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
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

        // COMMANDS
        Bukkit.getPluginCommand("money").setExecutor(new moneyCmds());
        Bukkit.getPluginCommand("gmoney").setExecutor(new gmoneyCmds());
        Bukkit.getPluginCommand("gxp").setExecutor(new gxpCmds());
        Bukkit.getPluginCommand("gmana").setExecutor(new gmanaCmds());
        Bukkit.getPluginCommand("transfer").setExecutor(new transferCmds());
        Bukkit.getPluginCommand("stats").setExecutor(new statsCmds());
        Bukkit.getPluginCommand("whereis").setExecutor(new whereisCmds());
        Bukkit.getPluginCommand("gspirit").setExecutor(new gspiritCmds());
        Bukkit.getPluginCommand("classe").setExecutor(new classeCmds());
        Bukkit.getPluginCommand("golem").setExecutor(new golemCmds());
        Bukkit.getPluginCommand("aff").setExecutor(new affichage());
        Bukkit.getPluginCommand("setlevel").setExecutor(new setlevelCmds());
        // COMMANDS

        // TAB COMPLETER
        getCommand("whereis").setTabCompleter(new whereisTabCompleter());
        getCommand("transfer").setTabCompleter(new transferTabCompleter());
        getCommand("classe").setTabCompleter(new classeTabCompleter());
        // TAB COMPLETER

        // EVENTS
        Bukkit.getPluginManager().registerEvents(new team(), this);
        Bukkit.getPluginManager().registerEvents(new capture(), this);
        Bukkit.getPluginManager().registerEvents(new moneyManage(), this);
        Bukkit.getPluginManager().registerEvents(new mainEvent(), this);
        Bukkit.getPluginManager().registerEvents(new gameplay(), this);
        Bukkit.getPluginManager().registerEvents(new level(), this);
        Bukkit.getPluginManager().registerEvents(new npcManager(), this);
        Bukkit.getPluginManager().registerEvents(new customMobs(), this);
        Bukkit.getPluginManager().registerEvents(new emeraldNuggets(), this);
        Bukkit.getPluginManager().registerEvents(new LanterneOmbreEvents(), this);
        Bukkit.getPluginManager().registerEvents(new classeEvent(), this);
        Bukkit.getPluginManager().registerEvents(new fortressManager(), this);
        Bukkit.getPluginManager().registerEvents(new captureSystem(), this);
        Bukkit.getPluginManager().registerEvents(new ElectroLameEffect(), this);
        Bukkit.getPluginManager().registerEvents(new intro(), this);
        Bukkit.getPluginManager().registerEvents(new leveling(), this);
        // EVENTS

        // NPC
        Bukkit.getPluginManager().registerEvents(new Doran(), this);
        Bukkit.getPluginManager().registerEvents(new Olga(), this);
        Bukkit.getPluginManager().registerEvents(new Alduan(), this);
        Bukkit.getPluginManager().registerEvents(new Schesein(), this);
        Bukkit.getPluginManager().registerEvents(new Lorient(), this);
        Bukkit.getPluginManager().registerEvents(new Elise(), this);
        Bukkit.getPluginManager().registerEvents(new Mila(), this);
        Bukkit.getPluginManager().registerEvents(new CollectionneurDepouille(), this);
        Bukkit.getPluginManager().registerEvents(new EchangeurFortune(), this);
        Bukkit.getPluginManager().registerEvents(new MembreCreynois(), this);
        Bukkit.getPluginManager().registerEvents(new Banquier(), this);
        Bukkit.getPluginManager().registerEvents(new Lazsnite(), this);
        // NPC

        // SPECIAL ITEMS
        Bukkit.getPluginManager().registerEvents(new FauxInutilisee(), this);
        Bukkit.getPluginManager().registerEvents(new RagoutChampignonsJaunes(), this);
        Bukkit.getPluginManager().registerEvents(new ElectrolyseurSchesein(), this);
        Bukkit.getPluginManager().registerEvents(new FruitDeChorus(), this);
        Bukkit.getPluginManager().registerEvents(new FauxDealite(), this);
        Bukkit.getPluginManager().registerEvents(new CoeurMer(), this);
        Bukkit.getPluginManager().registerEvents(new ModuleRapidite(), this);
        // SPECIAL ITEMS

        // FULL SET
        Bukkit.getPluginManager().registerEvents(new Dortiate(), this);
        Bukkit.getPluginManager().registerEvents(new GladiateurAmateur(), this);
        Bukkit.getPluginManager().registerEvents(new Celion(), this);
        Bukkit.getPluginManager().registerEvents(new Bourreau(), this);
        Bukkit.getPluginManager().registerEvents(new Fort(), this);
        Bukkit.getPluginManager().registerEvents(new Restaurateur(), this);
        // FULL SET
        Bukkit.getPluginManager().registerEvents(new GardienOmbreEffect(), this);
        Bukkit.getPluginManager().registerEvents(new OmbreEnvoutanteEffect(), this);
        // FULL SET + CUSTOM ITEMS

        // FLAGS
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag1(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag2(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag3(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag4(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag5(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag6(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag7(), this);
        // FLAGS

        // CUSTOM CRAFT
        logger.info("Loading custom recipes...");
        getServer().addRecipe(SolidificationArmure.onCraft());
        getServer().addRecipe(GladiateurReinforced.onCraft());
        getServer().addRecipe(FragmentOmbre.onCraft());
        getServer().addRecipe(LanterneOmbre.onCraft());
        getServer().addRecipe(FerEnergie.onCraft());
        getServer().addRecipe(CuirEnergie.onCraft());
        getServer().addRecipe(GardienOmbre.onCraftHelmet());
        getServer().addRecipe(GardienOmbre.onCraftChestplate());
        getServer().addRecipe(GardienOmbre.onCraftLeggings());
        getServer().addRecipe(GardienOmbre.onCraftBoots());
        getServer().addRecipe(OmbreEnvoutante.onCraftHelmet());
        getServer().addRecipe(OmbreEnvoutante.onCraftChestplate());
        getServer().addRecipe(OmbreEnvoutante.onCraftLeggings());
        getServer().addRecipe(OmbreEnvoutante.onCraftBoots());
        getServer().addRecipe(OmbreEnvoutante.onCraftSword());
        getServer().addRecipe(ElectroLame.onCraft());
        logger.info("Recipes loaded!");
        // CUSTOM CRAFT
    }

    @Override
    public void onDisable() {

        Logger logger = getLogger();
        logger.info("Domination has been disabled!");
        Bukkit.resetRecipes();
        logger.info("Recipes has been reset!");
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

    public static String manaPath(Player player) {
        return "eco." + player.getUniqueId() + ".mana";
    }
    public static String xpPath(Player player) {
        return "eco." + player.getUniqueId() + ".xp";
    }
    public static String classePath(Player player) {
        return "eco." + player.getUniqueId() + ".classe";
    }
    public static String levelPath(Player player) {
        return "eco." + player.getUniqueId() + ".level";
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

    public static ItemStack Item(Material mat, String name, String lore1, String lore2, String lore3, String lore4, String lore5, String lore6, String lore7) {

        ItemStack I = new ItemStack(mat);
        ItemMeta IM = I.getItemMeta();
        List<String> ILore = new ArrayList<>();
        ILore.add(String.valueOf(lore1));
        ILore.add(String.valueOf(lore2));
        ILore.add(String.valueOf(lore3));
        ILore.add(String.valueOf(lore4));
        ILore.add(String.valueOf(lore5));
        ILore.add(String.valueOf(lore6));
        ILore.add(String.valueOf(lore7));
        IM.setLore(ILore);
        IM.setDisplayName(name);
        I.setItemMeta(IM);
        return I;
    }
}
