package domination.morey.npc.specialItem;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static domination.morey.npc.pnj.vendor.Doran.item4;

public class FauxInutilisee implements Listener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {

        if(event.getEntity() instanceof Player) {
            if (event.getDamager() instanceof Player) {
                Player player = (Player) event.getDamager();
                Player target = (Player) event.getEntity();
                ItemStack identifier = new ItemStack(Material.IRON_HOE);
                ItemMeta meta = identifier.getItemMeta();
                meta.setDisplayName(item4.getItemMeta().getDisplayName());
                identifier.setItemMeta(meta);
                // DOIT ETRE MODIFIE AUSSI DANS LA CLASS DU PNJ QUI VEND L'ITEM
                item4.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
                //
                if(player.getInventory().getItemInMainHand().getItemMeta() == null) return;
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§aFaux de fermier inutilisée")) {
                    target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 1));
                }
            }
        }
    }
}
