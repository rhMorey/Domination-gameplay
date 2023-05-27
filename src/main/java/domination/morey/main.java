package domination.morey;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import domination.morey.economy.cmds.gmoneyCmds;
import domination.morey.economy.cmds.moneyCmds;
import domination.morey.economy.money;
import domination.morey.gamemode.capture;
import domination.morey.team.team;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.logging.Logger;

public final class main extends JavaPlugin {


    public static main plugin;
    private static main instance;

    FileConfiguration config = this.getConfig();
    @Override
    public void onEnable() {

        plugin = this;
        instance = this;
        Logger logger = getLogger();
        logger.info("Domination has been enabled!");
        saveDefaultConfig();

        Bukkit.getPluginCommand("money").setExecutor(new moneyCmds());
        Bukkit.getPluginCommand("gmoney").setExecutor(new gmoneyCmds());
        Bukkit.getPluginManager().registerEvents(new team(), this);
        Bukkit.getPluginManager().registerEvents(new capture(), this);
        Bukkit.getPluginManager().registerEvents(new money(), this);
        Bukkit.getPluginManager().registerEvents(new mainEvent(), this);

        // FLAGS
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag1(), this);
        Bukkit.getPluginManager().registerEvents(new domination.morey.gamemode.flags.flag2(), this);
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
}
