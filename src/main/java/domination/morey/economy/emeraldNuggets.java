package domination.morey.economy;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class emeraldNuggets implements Listener {

    static moneyManage manage;
    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if(event.getItem().getType().equals(Material.AIR)) return;
        if(event.getItem().getType().equals(Material.GOLD_NUGGET)) {
            player.sendMessage("§aVous avez cliqué sur un nugget d'or");
            manage.addMoney(1, player);
        }
    }
}
