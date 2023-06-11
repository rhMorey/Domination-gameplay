package domination.morey.npc.specialItem.fullset;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Dortiate implements Listener {

    @EventHandler
    public void ifEnsemble(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if (player.getInventory().getHelmet() == null) return;
        if (player.getInventory().getChestplate() == null) return;
        if (player.getInventory().getLeggings() == null) return;
        if (player.getInventory().getBoots() == null) return;

        /////////////////////////////
        if (player.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Dortiate") &&
                player.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Dortiate") &&
                player.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Dortiate") &&
                player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Dortiate")) {
            /////////////////////////////
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 0, false, false));
        }
    }
}
