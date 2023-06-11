package domination.morey.npc.pnj.vendor;

import domination.morey.economy.moneyManage;
import domination.morey.main;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static domination.morey.npc.npcManager.paper;
import static domination.morey.npc.npcManager.purchaseItem;

public class Schesein implements Listener {

    Schesein manage;

    public Schesein() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

    public static ItemStack item1 = new ItemStack(main.Item(Material.LIGHTNING_ROD, "§9Électryseur de Schesein",
            "§7Cet objet a été créer par Schesein",
            "§6§lActif: §eInflige des dégâts de foudre à l'impact",
            " ",
            "§7Prix: §a320 FE"));
    public static ItemStack item2 = new ItemStack(main.Item(Material.REDSTONE, "§9Module de rapidité",
            "§7Cet objet a été créer par Schesein",
            "§6§lActif: §eDonne 10 secondes de vitesse III",
            " ",
            "§7Prix: §a290 FE"));

    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Schesein")) {
            player.openInventory(invSchesein(player));
        }

    }

    public Inventory invSchesein(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§aSchesein §8- §aIngénieur");

        // ITEM PARAMETER

        // ITEM PARAMETER

        inv.setItem(0, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.REDSTONE_TORCH, "§a§lIngénieur", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
        inv.setItem(5, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(8, paper(player));

        inv.setItem(20, item1);
        inv.setItem(21, item2);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§aSchesein §8- §aIngénieur")) {
            if (event.getCurrentItem() == null) return;
            if(event.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                event.setCancelled(true);
            }
            else if (event.getCurrentItem().equals(item1)) {
                purchaseItem(event, item1, (Player) event.getWhoClicked(), 320);
            }
            else if(event.getCurrentItem().equals(item2)) {
                purchaseItem(event, item2, (Player) event.getWhoClicked(), 290);
            } else {
                event.setCancelled(true);
            }
        }
    }
}
