package domination.morey.dungeons.loot;

import domination.morey.economy.moneyManage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class emeraldNuggets implements Listener {

    static moneyManage myMoney = new moneyManage();
    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        if(item == null) return;
        if(item.getType().equals(Material.GOLD_NUGGET) && event.getItem().getItemMeta().getDisplayName().equals("§aPièce d'émeraude")) {
            player.getInventory().remove(event.getItem().asQuantity(1));
            myMoney.addMoney(10, player);
        } else {
            return;
        }
    }
}