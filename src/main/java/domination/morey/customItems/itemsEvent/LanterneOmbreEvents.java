package domination.morey.customItems.itemsEvent;

import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class LanterneOmbreEvents implements Listener {

    @EventHandler
    public void onBiome(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        Location location = player.getLocation();
        if(player.getLocation().getWorld().getBiome(location.getBlockX(), location.getBlockY(), location.getBlockZ()).equals(Biome.valueOf("SOUL_SAND_VALLEY")) && !player.isOp()) {
            if(player.getInventory().contains(domination.morey.customItems.items.LanterneOmbre.result)) {
            } else {
                player.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.BLINDNESS, 400, 1));
            }

        }

    }
}
