package domination.morey.npc.pnj.cp;

import domination.morey.economy.moneyManage;
import domination.morey.main;
import domination.morey.npc.pnj.vendor.Olga;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;

public class cp1 {

    cp1 manage;

    public cp1() {
        manage = this;
    }
    static moneyManage money = new moneyManage();
    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Commissaire-priseur")) {
            player.openInventory(invcp1(player));
        }

    }

    public Inventory invcp1(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§2Commissaire-priseur");

        // ITEM PARAMETER

        // ITEM PARAMETER

        inv.setItem(0, main.Item(Material.LIGHT_BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.LIGHT_BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.LIGHT_BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.LIGHT_BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.GOLD_INGOT, "§2§lCommissaire-priseur", " ", "§7Vendez vos items ici."));
        inv.setItem(5, main.Item(Material.LIGHT_BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.LIGHT_BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.LIGHT_BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(8, main.Item(Material.PAPER, "§6§lProfile§6: §e" + player.getName(), " ", "§aFragment d'émeraude§f: §a" + myMoney + " FE"));

        return inv;
    }
}
