package domination.morey.npc.pnj.vendor;

import domination.morey.economy.moneyManage;
import domination.morey.main;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static domination.morey.npc.npcManager.purchaseItem;

public class Alduan implements Listener {

    public static ItemStack item1 = new ItemStack(main.Item(Material.APPLE, "§fPomme",
            " ",
            "§7Prix: §a8 FE"));
    public static ItemStack item2 = new ItemStack(main.Item(Material.CHARCOAL, "§fCharbon de bois",
            " ",
            "§7Prix: §a2 FE"));
    public static ItemStack item3 = new ItemStack(main.Item(Material.PORKCHOP, "§fCôtelette de porc",
            " ",
            "§7Prix: §a6 FE"));
    public static ItemStack item4 = new ItemStack(main.Item(Material.SUSPICIOUS_STEW, "§aRagoût de champignons jaunes",
            " ",
            "§6§lConso: §eRégénération I pendant 6 secondes.",
            " ",
            "§7Prix: §a60 FE"));
    public static ItemStack item5 = new ItemStack(main.Item(Material.CHORUS_FRUIT, "§9Fruit de chorus",
            "§7Le chorus est connue pour endurcir la peau.",
            "§6§lConso: §eRésistance I pendant 12 secondes",
            " ",
            "§7Prix: §a220 FE"));
    public static ItemStack item6 = new ItemStack(main.Item(Material.CHICKEN, "§fPoulet",
            " ",
            "§7Prix: §a5 FE"));
    public static ItemStack item7 = new ItemStack(main.Item(Material.FEATHER, "§fPlume",
            " ",
            "§7Prix: §a3 FE"));

    Alduan manage;

    public Alduan() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Alduan")) {
            player.openInventory(invAlduan(player));
        }
    }

    public Inventory invAlduan(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§aAlduan §8- §aTanneur");

        // ITEM PARAMETER

        // ITEM PARAMETER

        inv.setItem(0, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.LEATHER, "§a§lTanneur", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
        inv.setItem(5, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(8, main.Item(Material.PAPER, "§6§lProfile§6: §e" + player.getName(), " ", "§aFragment d'émeraude§f: §a" + myMoney + " FE"));

        inv.setItem(20, item1);
        inv.setItem(21, item2);
        inv.setItem(22, item3);
        inv.setItem(23, item4);
        inv.setItem(24, item5);
        inv.setItem(29, item6);
        inv.setItem(30, item7);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§aAlduan §8- §aTanneur")) {
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().equals(item1)) {
                purchaseItem(item1, (Player) event.getWhoClicked(), 8);
            }
            if(event.getCurrentItem().equals(item2)) {
                purchaseItem(item2, (Player) event.getWhoClicked(), 2);
            }
            if(event.getCurrentItem().equals(item3)) {
                purchaseItem(item3, (Player) event.getWhoClicked(), 6);
            }
            if(event.getCurrentItem().equals(item4)) {
                purchaseItem(item4, (Player) event.getWhoClicked(), 60);
            }
            if(event.getCurrentItem().equals(item5)) {
                purchaseItem(item5, (Player) event.getWhoClicked(), 220);
            }
            if(event.getCurrentItem().equals(item6)) {
                purchaseItem(item6, (Player) event.getWhoClicked(), 5);
            }
            if(event.getCurrentItem().equals(item7)) {
                purchaseItem(item7, (Player) event.getWhoClicked(), 3);
            }
        }
    }

}
