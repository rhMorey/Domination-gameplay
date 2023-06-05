package domination.morey.npc.customItem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ElectrolyseurSchesein implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if(event.getItem() == null) return;
        if(event.getItem().getType().equals(Material.LIGHTNING_ROD)) {
            ItemStack item = new ItemStack(Material.LIGHTNING_ROD, 1);
            ItemMeta meta = item.getItemMeta();
            item.setItemMeta(meta);
            if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§9Électryseur de Schesein")) {
                player.getWorld().strikeLightning(player.getTargetBlock(null, 100).getLocation());
                player.getWorld().createExplosion(player.getTargetBlock(null, 100).getLocation(), 2, false, false, player);
                player.getInventory().removeItem(player.getInventory().getItemInMainHand().asQuantity(1));
            }
        }
    }
}
