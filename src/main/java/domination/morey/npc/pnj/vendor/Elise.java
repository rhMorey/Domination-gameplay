package domination.morey.npc.pnj.vendor;

import domination.morey.economy.moneyManage;
import domination.morey.main;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import static domination.morey.npc.npcManager.*;

public class Elise implements Listener {

    Elise manage;

    public Elise() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

    public static ItemStack item1 = new ItemStack(main.Item(Material.NETHERITE_HOE, "§5Faux en Dealite",
            " ",
            "§6§lP: §eLorsque cette faux tue un joueur/monstre, le détenteur gagne §b4 âmes§e/§b1 âme§e.",
            " ",
            "§7Prix: §b75 Âmes"));
    public static ItemStack item2 = new ItemStack(main.Item(Material.HEART_OF_THE_SEA, "§5Cœur de la Mer",
            " ",
            "§6§lP: §eCe coeur vous donne Résistance I et Absorption II",
            "§6§lActif: §eVous donne Résistance III, Absorption IV, Régénération II pendant 30 secondes",
            " ",
            "§7Prix: §b215 Âmes"));
    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Elise")) {
            player.openInventory(invElise(player));
        }
    }

    public Inventory invElise(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§3§lElise");

        // ITEM PARAMETER
        item1.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        // ITEM PARAMETER

        inv.setItem(0, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.ENDER_EYE, "§3§lElise", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
        inv.setItem(5, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(8, paper(player));

        inv.setItem(20, item1);
        inv.setItem(21, item2);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§3§lElise")) {
            if (event.getCurrentItem() == null) return;
            if(event.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                event.setCancelled(true);
            }
            else if (event.getCurrentItem().equals(item1)) {
                //
                item1.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 8);
                //
                spiritPurchaseItem(item1, (Player) event.getWhoClicked(), 75);
            }
            else if(event.getCurrentItem().equals(item2)) {
                spiritPurchaseItem(item2, (Player) event.getWhoClicked(), 215);
            } else {
                event.setCancelled(true);
            }
        }
    }
}
