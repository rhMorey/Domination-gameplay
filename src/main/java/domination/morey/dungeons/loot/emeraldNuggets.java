package domination.morey.dungeons.loot;

import domination.morey.economy.moneyManage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class emeraldNuggets implements Listener {

    static moneyManage myMoney = new moneyManage();
    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if(event.getItem().getType().equals(Material.AIR)) return;
        if(event.getItem().getType().equals(Material.GOLD_NUGGET) && event.getItem().getItemMeta().getDisplayName().equals("§aPièce d'émeraude")) {
            player.getInventory().removeItem(event.getItem());
            myMoney.addMoney(10, player);
        }
    }
}