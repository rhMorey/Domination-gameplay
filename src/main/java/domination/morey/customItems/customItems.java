package domination.morey.customItems;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class customItems implements Listener {

    public static int getTimer(Player player, ItemStack item) {
        return player.getCooldown(item.getType()) / 20;
    }

}
