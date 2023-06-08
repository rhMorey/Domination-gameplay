package domination.morey.npc.pnj.seller;

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

import static domination.morey.npc.npcManager.sellItem;

public class EchangeurFortune implements Listener {

    EchangeurFortune manage;

    public EchangeurFortune() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

    public static ItemStack item1 = new ItemStack(main.Item(Material.GOLD_NUGGET, "§fPépite d'or",
            "§7Clique gauche pour vendre cet objet",
            " ",
            "§7Vente: §a2 Pépite d'émeraude §8(10 PE = 1 FE)"));
    public static ItemStack item2 = new ItemStack(main.Item(Material.RAW_COPPER, "§fMinerai de cuivre brut",
            "§7Clique gauche pour vendre cet objet",
            " ",
            "§7Vente: §a4 Pépite d'émeraude §8(10 PE = 1 FE)"));
    public static ItemStack item3 = new ItemStack(main.Item(Material.PRISMARINE_CRYSTALS, "§fCrystal de prismarine",
            "§7Clique gauche pour vendre cet objet",
            " ",
            "§7Vente: §a2 Pépite d'émeraude §8(10 PE = 1 FE)"));
    public static ItemStack item4 = new ItemStack(main.Item(Material.PRISMARINE_SHARD, "§fFragment de prismarine",
            "§7Clique gauche pour vendre cet objet",
            " ",
            "§7Vente: §a3 Pépite d'émeraude §8(10 PE = 1 FE)"));
    public static ItemStack item5 = new ItemStack(main.Item(Material.MAGMA_CREAM, "§fBoule de magma",
            "§7Clique gauche pour vendre cet objet",
            " ",
            "§7Vente: §a4 Pépite d'émeraude §8(10 PE = 1 FE)"));


    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Échangeur de fortune")) {
            player.openInventory(invFortune(player));
        }

    }
    public Inventory invFortune(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§9Échangeur de fortune");

        inv.setItem(0, main.Item(Material.BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.DIAMOND, "§9Échangeur de fortune", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
        inv.setItem(5, main.Item(Material.BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.BLUE_STAINED_GLASS_PANE, " "));
        inv.setItem(8, main.Item(Material.PAPER, "§6§lProfile§6: §e" + player.getName(), " ", "§aFragment d'émeraude§f: §a" + myMoney + " FE"));

        inv.setItem(20, item1);
        inv.setItem(21, item2);
        inv.setItem(22, item3);
        inv.setItem(23, item4);
        inv.setItem(24, item5);
        //inv.setItem(29, item6);
        //inv.setItem(30, item7);
        //inv.setItem(31, item8);
        //inv.setItem(32, item9);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        ItemStack sell1 = new ItemStack(Material.GOLD_NUGGET);
        ItemStack sell2 = new ItemStack(Material.RAW_COPPER);
        ItemStack sell3 = new ItemStack(Material.PRISMARINE_CRYSTALS);
        ItemStack sell4 = new ItemStack(Material.PRISMARINE_SHARD);
        ItemStack sell5 = new ItemStack(Material.MAGMA_CREAM);

        ItemStack reward1 = new ItemStack(Material.GOLD_NUGGET);

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals("§9Échangeur de fortune")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().equals(item1)) {
                sellItem(player, sell1, reward1, 2);
            }
            if (event.getCurrentItem().equals(item2)) {
                sellItem(player, sell2, reward1, 4);
            }
            if (event.getCurrentItem().equals(item3)) {
                sellItem(player, sell3, reward1, 2);
            }
            if (event.getCurrentItem().equals(item4)) {
                sellItem(player, sell4, reward1, 3);
            }
            if (event.getCurrentItem().equals(item5)) {
                sellItem(player, sell5, reward1, 4);
            }
        }
    }
}
