package domination.morey.npc;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
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
        player.sendMessage("§aAchat effectué: " + item.getItemMeta().getDisplayName());
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 2);
        money.removeMoney(price, player);
    }

    public static void spiritPurchaseItem(ItemStack item, Player player, int price) {
        if(player.getLevel() < price) {
            player.sendMessage("§cVous n'avez pas assez d'§bâmes§c.");
            player.closeInventory();
            return;
        }
        player.getInventory().addItem(item);
        player.closeInventory();
        player.sendMessage("§aAchat effectué: " + item.getItemMeta().getDisplayName());
        player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_CHIME, 1, 1);
        player.playSound(player.getLocation(), "block.amethyst_block.resonate", 1, 1);
        player.setLevel(player.getLevel() - price);
    }

    public static void leatherMeta(ItemStack item, Color color) {
        LeatherArmorMeta item1m = (LeatherArmorMeta) item.getItemMeta();
        assert item1m != null;
        item1m.setColor(color);
        item.setItemMeta(item1m);
    }
}
