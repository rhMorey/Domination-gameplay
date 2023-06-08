package domination.morey.npc.specialItem;

import domination.morey.npc.pnj.vendor.Schesein;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ModuleRapidite implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if(event.getAction().isRightClick() && player.getInventory().getItemInMainHand().equals(Schesein.item2)) {
            player.getInventory().removeItem(player.getInventory().getItemInMainHand().asQuantity(1));
            player.playSound(player.getLocation(), Sound.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, 1, 1);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 2));
        }

    }

}
