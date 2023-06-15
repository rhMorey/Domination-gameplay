package domination.morey.customItems.armor.fullset.effect;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class OmbreEnvoutanteEffect implements Listener {

    @EventHandler
    public void ifEnsemble(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if (player.getInventory().getHelmet() == null) return;
        if (player.getInventory().getChestplate() == null) return;
        if (player.getInventory().getLeggings() == null) return;
        if (player.getInventory().getBoots() == null) return;
        if(player.getInventory().getItemInMainHand().getItemMeta() == null) return;

        String armor = "Ombre envoûtante";
        /////////////////////////////
        if (player.getInventory().getHelmet().getItemMeta().getDisplayName().contains(armor) &&
                player.getInventory().getChestplate().getItemMeta().getDisplayName().contains(armor) &&
                player.getInventory().getLeggings().getItemMeta().getDisplayName().contains(armor) &&
                player.getInventory().getBoots().getItemMeta().getDisplayName().contains(armor) &&
                player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(armor)); {
            /////////////////////////////
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
        }
    }

}
