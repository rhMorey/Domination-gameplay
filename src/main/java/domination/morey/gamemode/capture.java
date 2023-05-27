package domination.morey.gamemode;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldedit.world.World;
import domination.morey.team.team;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import domination.morey.main;
import domination.morey.economy.money;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.Objects;
import java.util.logging.Logger;

public class capture implements Listener {

    capture manage;

    public capture() {
        manage = this;
    }
    static money money = new money();


    //
    // Détection de quel équipe clique sur le drapeau + changement de bloc
    //
    public void whatFlag(ProtectedRegion flag, Player player, Location playerLocation, int y) {
        if (flag.contains(playerLocation.getBlockX(), playerLocation.getBlockY(), playerLocation.getBlockZ())) {
            if (team.purple.getEntries().contains(player.getName()) && main.getCenter(flag, y).getType().equals(Material.YELLOW_WOOL)) {
                main.getCenter(flag, y).setType(Material.WHITE_WOOL);
                money.addMoney(5, player);
                player.sendMessage("§6L'équipe §5Violet§6 conteste un drapeau !");
                return;
            }
            if (team.purple.getEntries().contains(player.getName()) && main.getCenter(flag, y).getType().equals(Material.WHITE_WOOL)) {
                main.getCenter(flag, y).setType(Material.PURPLE_WOOL);
                money.addMoney(15, player);
                player.sendMessage("§6L'équipe §5Violet§6 a capturé un drapeau !");
                return;
            }
            if (team.yellow.getEntries().contains(player.getName()) && main.getCenter(flag, y).getType().equals(Material.PURPLE_WOOL)) {
                main.getCenter(flag, y).setType(Material.WHITE_WOOL);
                money.addMoney(5, player);
                player.sendMessage("§6L'équipe §eJaune§6 conteste un drapeau !");
                return;
            }
            if (team.yellow.getEntries().contains(player.getName()) && main.getCenter(flag, y).getType().equals(Material.WHITE_WOOL)) {
                main.getCenter(flag, y).setType(Material.YELLOW_WOOL);
                money.addMoney(15, player);
                player.sendMessage("§6L'équipe §eJaune§6 a capturé un drapeau !");
                return;
            }
        }
    }
    //
    // Effet ajouté lors de la capture d'un drapeau ou contestation
    //
    public void effect(int a, Player player) {

        Location loc = player.getLocation();
        if(a == 10) {
            player.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_COW_BELL, 2, 0);
            player.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BELL, 2, 0);
        }
        if(a == 20) {
            player.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BELL, 2, 1);
            player.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_COW_BELL, 2, 1);
        }
        if(a == 30) {
            player.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_BELL, 2, 2);
            player.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_COW_BELL, 2, 2);
        }
        if(a == 40) {
            player.getWorld().playSound(loc, Sound.BLOCK_NOTE_BLOCK_FLUTE, 5, 1);
            player.getWorld().playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5, 2);
            player.getWorld().spawnParticle(org.bukkit.Particle.FIREWORKS_SPARK, loc, 40);
        }

    }
}
