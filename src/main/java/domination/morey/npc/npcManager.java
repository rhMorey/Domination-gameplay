package domination.morey.npc;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import domination.morey.economy.moneyManage;


public class npcManager implements Listener {

    npcManager manage;
    static moneyManage money = new moneyManage();

    public npcManager() {
        manage = this;
    }

    public Material skull(Player player) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(player.getName());
        item.setItemMeta(meta);
        return item.getType();
    }

    public static void purchaseItem(ItemStack item, Player player, int price) {
        if(money.getMoney(player) < price) {
            player.sendMessage("§cVous n'avez pas assez de FE");
            player.closeInventory();
            return;
        }
        player.getInventory().addItem(item);
        player.closeInventory();
        player.sendMessage("§aAchat effectué : " + item.getItemMeta().getDisplayName());
        money.removeMoney(price, player);
    }
}
