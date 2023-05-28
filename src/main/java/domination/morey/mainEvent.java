package domination.morey;

import domination.morey.economy.money;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.Locale;

public class mainEvent implements Listener {

    static domination.morey.economy.money money = new money();

    @EventHandler
    public void onDie(PlayerDeathEvent event) {

        Player player = event.getPlayer();
        player.sendMessage("§cVous êtes mort");
        int random = (int) (Math.random() * 20);
        money.removeMoney(random, player);
        if (player.getKiller() != null) {
            Player killer = player.getKiller();
            killer.sendMessage("§aVous avez tué §c" + player.getName());
            money.addMoney(random, killer);
        }
    }

    @EventHandler
    public void deathMessage(PlayerDeathEvent event) {

        event.deathMessage(null);
    }

    @EventHandler
    public void onWalk(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if (player.getWorld().getName().equals("world")) {
            Block block = player.getLocation().getBlock();
            if (block.getType().equals(Material.DIRT_PATH) || block.getType().equals(Material.COARSE_DIRT) || block.getType().equals(Material.ROOTED_DIRT)) {
                player.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.SPEED, 20, 1));
            }
        }
    }
    /*
    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        Block block = event.getBlock();
        ArrayList<Material> blocks = new ArrayList<>();
        blocks.add(Material.DIAMOND_ORE);
        // Si le joueur casse un bloc qui n'est pas dans la liste
        if (!blocks.contains(block.getType())) {
            player.sendMessage("§cVous ne pouvez pas casser ce bloc");
            event.setCancelled(true);
        }

    }*/

    @EventHandler
    public void onConnect(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        event.setJoinMessage("§a+ §7" + player.getName());
        info(event);
        if(!player.hasPlayedBefore()) {
            Bukkit.getServer().broadcastMessage("§f§lFIRST TIME! " + "§d"+player.getName());
        }
    }

    @EventHandler
    public void onDisconnect(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        event.setQuitMessage("§c- §7" + player.getName());
    }

    public void info(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        player.sendMessage("§f§lNEWS §7§l» \n§6§lPatch§6: V0.1-ALPHA");
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
    }
}

