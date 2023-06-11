package domination.morey.npc.specialItem.fullset;

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
import static domination.morey.team.team.getTeam;

public class Celion implements Listener {

    @EventHandler
    public void ifEnsemble(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if (player.getInventory().getHelmet() == null) return;
        if (player.getInventory().getChestplate() == null) return;
        if (player.getInventory().getLeggings() == null) return;
        if (player.getInventory().getBoots() == null) return;

        String armor = "Célion";
        /////////////////////////////
        if (player.getInventory().getHelmet().getItemMeta().getDisplayName().contains(armor) &&
                player.getInventory().getChestplate().getItemMeta().getDisplayName().contains(armor) &&
                player.getInventory().getLeggings().getItemMeta().getDisplayName().contains(armor) &&
                player.getInventory().getBoots().getItemMeta().getDisplayName().contains(armor)) {
            /////////////////////////////
            Location location = player.getLocation();
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 0, true, true));
            for (Player nearbyPlayer : Bukkit.getOnlinePlayers()) {
                if (nearbyPlayer != player && nearbyPlayer.getLocation().distance(location) <= 5) {
                    if(getTeam(nearbyPlayer) == getTeam(player)) {
                        nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
                    }
                }
            }
        }
    }

}
