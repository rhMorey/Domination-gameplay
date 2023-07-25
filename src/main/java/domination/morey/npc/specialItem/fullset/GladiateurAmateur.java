package domination.morey.npc.specialItem.fullset;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GladiateurAmateur implements Listener {

    @EventHandler
    public void ifEnsemble(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if (player.getInventory().getHelmet() == null) return;
        if (player.getInventory().getChestplate() == null) return;
        if (player.getInventory().getLeggings() == null) return;
        if (player.getInventory().getBoots() == null) return;
        if(player.getInventory().getItemInMainHand().getItemMeta() == null) return;

        /////////////////////////////
        if (player.getInventory().getHelmet().getItemMeta().getDisplayName().contains("Gladiateur") &&
                player.getInventory().getChestplate().getItemMeta().getDisplayName().contains("Gladiateur") &&
                player.getInventory().getLeggings().getItemMeta().getDisplayName().contains("Gladiateur") &&
                player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Gladiateur") &&
                player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Gladiateur")) {
            /////////////////////////////
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 0, false, false));
        }
    }
}
