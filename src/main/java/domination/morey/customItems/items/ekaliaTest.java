package domination.morey.customItems.items;

import domination.morey.main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

public class ekaliaTest implements Listener {

    public void giveitem(Player player) {

        ItemStack item = new ItemStack(main.Item(Material.IRON_SWORD, "§8§lBélier du Bifrost",
                " ",
                "§7§l» §r§fEffet",
                "§7N'explose pas mais se promène",
                "§7dans le drakkar adverse pendant 15 secondes",
                "§7et inflige blindness pendant 8 secondes"));
        player.getInventory().setItem(0, item);
    }
    @EventHandler
    public void ekalia(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if(event.getMessage().equals("/ekalia")) {
            event.setCancelled(true);
            giveitem(event.getPlayer());
        }
    }
}
