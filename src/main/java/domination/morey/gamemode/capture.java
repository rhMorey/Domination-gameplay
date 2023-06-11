package domination.morey.gamemode;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import domination.morey.team.team;
import domination.morey.main;
import domination.morey.economy.moneyManage;
import domination.morey.experience.level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class capture implements Listener {

    capture manage;

    public capture() {
        manage = this;
    }
    static moneyManage myMoney = new moneyManage();
    static level level = new level();


    //
    // Détection de quel équipe clique sur le drapeau + changement de bloc
    //
    public void whatFlag(ProtectedRegion flag, Player player, Location playerLocation, int y) {
        if (flag.contains(playerLocation.getBlockX(), playerLocation.getBlockY(), playerLocation.getBlockZ())) {
            if (team.purple.getEntries().contains(player.getName()) && main.getCenter(flag, y).getType().equals(Material.YELLOW_WOOL)) {
                main.getCenter(flag, y).setType(Material.WHITE_WOOL);
                myMoney.addMoney(30, player);
                level.addXP(10, player);
                Bukkit.broadcastMessage("§6L'équipe §5Violet§6 conteste un drapeau !");
                return;
            }
            if (team.purple.getEntries().contains(player.getName()) && main.getCenter(flag, y).getType().equals(Material.WHITE_WOOL)) {
                main.getCenter(flag, y).setType(Material.PURPLE_WOOL);
                myMoney.addMoney(50, player);
                level.addXP(30, player);
                Bukkit.broadcastMessage("§6L'équipe §5Violet§6 a capturé un drapeau !");
                return;
            }
            if (team.yellow.getEntries().contains(player.getName()) && main.getCenter(flag, y).getType().equals(Material.PURPLE_WOOL)) {
                main.getCenter(flag, y).setType(Material.WHITE_WOOL);
                myMoney.addMoney(30, player);
                level.addXP(10, player);
                Bukkit.broadcastMessage("§6L'équipe §eJaune§6 conteste un drapeau !");
                return;
            }
            if (team.yellow.getEntries().contains(player.getName()) && main.getCenter(flag, y).getType().equals(Material.WHITE_WOOL)) {
                main.getCenter(flag, y).setType(Material.YELLOW_WOOL);
                myMoney.addMoney(50, player);
                level.addXP(30, player);
                Bukkit.broadcastMessage("§6L'équipe §eJaune§6 a capturé un drapeau !");
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
            player.getWorld().playSound(loc, Sound.ITEM_GOAT_HORN_SOUND_0, 7, 0);
            player.getWorld().spawnParticle(org.bukkit.Particle.FIREWORKS_SPARK, loc, 40);
        }

    }
}
