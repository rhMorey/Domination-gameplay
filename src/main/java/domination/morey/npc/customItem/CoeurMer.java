package domination.morey.npc.customItem;

import domination.morey.npc.pnj.vendor.Elise;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CoeurMer implements Listener {

    @EventHandler
    public void Passive(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        Elise.item2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        if(player.getInventory().contains(Elise.item2)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 40, 0, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 40, 0, false, false));
        }
    }

    @EventHandler
    public void Active(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        Elise.item2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        if(player.getInventory().getItemInMainHand().equals(Elise.item2)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600, 2, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 3, false, false));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 1, false, false));
            player.getWorld().playSound(player.getLocation(), Sound.ITEM_GOAT_HORN_SOUND_7, 3, 1);
            player.getInventory().removeItem(Elise.item2.asQuantity(1));
        }
    }
}
