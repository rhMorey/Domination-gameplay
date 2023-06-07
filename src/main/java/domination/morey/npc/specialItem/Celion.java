package domination.morey.npc.specialItem;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static domination.morey.main.plugin;

public class Celion implements Listener {

    @EventHandler
    public void ifEnsemble(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if (player.getInventory().getHelmet() == null) return;
        if (player.getInventory().getChestplate() == null) return;
        if (player.getInventory().getLeggings() == null) return;
        if (player.getInventory().getBoots() == null) return;

        /////////////////////////////
        if (player.getInventory().getHelmet().getItemMeta().getDisplayName().contains("célion") &&
                player.getInventory().getChestplate().getItemMeta().getDisplayName().contains("célion") &&
                player.getInventory().getLeggings().getItemMeta().getDisplayName().contains("célion") &&
                player.getInventory().getBoots().getItemMeta().getDisplayName().contains("célion")) {
            /////////////////////////////
            Location location = player.getLocation();
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 30, 0, true, true));
            for (Player nearbyPlayer : Bukkit.getOnlinePlayers()) {
                if (nearbyPlayer != player && nearbyPlayer.getLocation().distance(location) <= 5) {
                    nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 0));
                }
            }
        }
    }

}
