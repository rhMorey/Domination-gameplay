package domination.morey.npc.customItem;

import domination.morey.npc.pnj.Doran;
import io.papermc.paper.event.player.PrePlayerAttackEntityEvent;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static domination.morey.npc.pnj.Doran.item4;

public class FauxInutilisee implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {

        if(event.getEntity() instanceof Player) {
            if (event.getDamager() instanceof Player) {
                Player player = (Player) event.getDamager();
                Player target = (Player) event.getEntity();
                //
                item4.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
                //
                if (player.getInventory().getItemInMainHand().equals(item4)) {
                    target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 1));
                }
            }
        }
    }
}
