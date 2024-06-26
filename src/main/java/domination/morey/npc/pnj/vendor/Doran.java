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

import static domination.morey.npc.npcManager.paper;
import static domination.morey.npc.npcManager.purchaseItem;

public class Doran implements Listener {

    Doran manage;

    public Doran() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

    public static ItemStack item1 = new ItemStack(main.Item(Material.STONE_SWORD, "§fLame de Doran",
            "§7Forgé par de nombreux forgerons local",
            " ",
            "§7Prix: §a10 FE"));
    public static ItemStack item2 = new ItemStack(main.Item(Material.STONE_AXE, "§fHache Dinhîste",
            "§7Forgé par les forgerons de Dinhâm",
            " ",
            "§7Prix: §a30 FE"));
    public static ItemStack item3 = new ItemStack(main.Item(Material.IRON_SWORD, "§fÉpée d'arène brisée",
            "§7Cette épée a été retrouvé dans le Dortmund",
            " ",
            "§7Prix: §a25 FE"));
    public static ItemStack item4 = new ItemStack(main.Item(Material.IRON_HOE, "§aFaux de fermier inutilisée",
            "§7Cette faux a été retrouvé dans un champ",
            "§6§lP: §eInflige Lenteur II pendant 2 secondes à l'impact",
            " ",
            "§7Prix: §a110 FE"));

    //
    // TANK SET
    //
    public static ItemStack item5 = new ItemStack(main.Item(Material.STONE_SWORD, "§aÉpée du Gladiateur amateur",
            "§7Cet objet appartient à l'ensemble §bGladiateur amateur",
            " ",
            "§7Prix: §a190 FE"));

    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Doran")) {
            player.openInventory(invSword(player));
        }

    }
    public Inventory invSword(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§aDoran §8- §aVendeur de lame");

        inv.setItem(0, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.IRON_SWORD, "§a§lVendeur de lame", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
        inv.setItem(5, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(8, paper(player));

        inv.setItem(20, item1);
        inv.setItem(21, item2);
        inv.setItem(22, item3);
        inv.setItem(23, item4);
        inv.setItem(24, item5);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§aDoran §8- §aVendeur de lame")) {
            if (event.getCurrentItem() == null) return;
            if(event.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                event.setCancelled(true);
            }
            else if (event.getCurrentItem().equals(item1)) {
                purchaseItem(event, item1, (Player) event.getWhoClicked(), 10);
            }
            else if (event.getCurrentItem().equals(item2)) {
                purchaseItem(event, item2, (Player) event.getWhoClicked(), 30);
            }
            else if (event.getCurrentItem().equals(item3)) {
                purchaseItem(event, item3, (Player) event.getWhoClicked(), 25);
            }
            else if(event.getCurrentItem().equals(item4)) {
                //
                item4.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
                item4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                //
                purchaseItem(event, item4, (Player) event.getWhoClicked(), 110);
            }
            else if(event.getCurrentItem().equals(item5)) {
                purchaseItem(event, item5, (Player) event.getWhoClicked(), 190);
            } else {
                event.setCancelled(true);
            }
        }
    }
}
