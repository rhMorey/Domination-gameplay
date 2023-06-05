package domination.morey.npc.pnj;

import domination.morey.economy.moneyManage;
import domination.morey.main;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import static domination.morey.npc.npcManager.purchaseItem;

public class Lorient implements Listener {

    Lorient manage;

    public Lorient() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

    public static ItemStack item1 = new ItemStack(main.Item(Material.FLINT, "§fSilex",
            " ",
            "§7Prix: §a10 FE"));
    public static ItemStack item2 = new ItemStack(main.Item(Material.STICK, "§fBâton",
            " ",
            "§7Prix: §a2 FE"));
    public static ItemStack item3 = new ItemStack(main.Item(Material.DRIED_KELP, "§fKelp Séché",
            " ",
            "§7Prix: §a1 FE"));
    public static ItemStack item4 = new ItemStack(main.Item(Material.CROSSBOW, "§aArbalète Marodienne",
            "§7Nécessite des flèches",
            " ",
            "§7Prix: §a270 FE"));

    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Lorient")) {
            player.openInventory(invLorient(player));
        }

    }

    public Inventory invLorient(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§aLorient §8- §aMineur des basses-grottes");

        // ITEM PARAMETER

        // ITEM PARAMETER

        inv.setItem(0, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.IRON_CHESTPLATE, "§a§lVendeur Utilitaire", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
        inv.setItem(5, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(8, main.Item(Material.PAPER, "§6§lProfile§6: §e" + player.getName(), " ", "§aFragment d'émeraude§f: §a" + myMoney + " FE"));

        inv.setItem(20, item1);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§aLorient §8- §aMineur des basses-grottes")) {
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().equals(item1)) {
                purchaseItem(item1, (Player) event.getWhoClicked(), 10);
            }
            if(event.getCurrentItem().equals(item2)) {
                purchaseItem(item2, (Player) event.getWhoClicked(), 2);
            }
            if(event.getCurrentItem().equals(item3)) {
                purchaseItem(item3, (Player) event.getWhoClicked(), 1);
            }
            if(event.getCurrentItem().equals(item4)) {
                purchaseItem(item4, (Player) event.getWhoClicked(), 270);
            }
        }
    }
}
