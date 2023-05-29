package domination.morey.npc.pnj;

import domination.morey.economy.moneyManage;
import domination.morey.main;
import domination.morey.npc.npcManager;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Doran implements Listener {

    Doran manage;

    public Doran() {
        manage = this;
    }
    static npcManager npc;
    static moneyManage money = new moneyManage();

    public static ItemStack item1 = new ItemStack(main.Item(Material.STONE_SWORD, "§fLame de Doran",
            " ",
            "§7Forgé par de nombreux forgerons local",
            " ",
            "§7Prix: §a10 FE"));
    public static ItemStack item2 = new ItemStack(main.Item(Material.STONE_AXE, "§fHache Dinhîste",
            " ",
            "§7Forgé par les forgerons de Dinhâm",
            " ",
            "§7Prix: §a30 FE"));
    public static ItemStack item3 = new ItemStack(main.Item(Material.IRON_SWORD, "§fÉpée d'arène brisée",
            " ",
            "§7Cette épée a été retrouvé dans le Dortmund",
            " ",
            "§7Prix: §a25 FE"));
    public static ItemStack item4 = new ItemStack(main.Item(Material.IRON_HOE, "§aFaux de fermier inutilisée",
            " ",
            "§7Cette faux a été retrouvé dans un champ",
            "§6§lP: §eInflige Lenteur II pendant 2 secondes à l'impact",
            " ",
            "§7Prix: §a50 FE"));

    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Doran")) {
            player.openInventory(invSword(player));
        }

    }
    public Inventory invSword(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§c§lVendeur d'arme");

        inv.setItem(0, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.IRON_SWORD, "§e§lVendeur d'épée", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
        inv.setItem(5, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(8, main.Item(Material.PAPER, "§6§lProfile", " ", "§aFragment d'émeraude§f: §a" + myMoney + " FE"));

        inv.setItem(20, item1);
        inv.setItem(21, item2);
        inv.setItem(22, item3);
        inv.setItem(24, item4);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§c§lVendeur d'arme")) {
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().equals(item1)) {
                purchaseItem(item1, (Player) event.getWhoClicked(), 10);
            }
            if (event.getCurrentItem().equals(item2)) {
                purchaseItem(item2, (Player) event.getWhoClicked(), 30);
            }
            if (event.getCurrentItem().equals(item3)) {
                purchaseItem(item3, (Player) event.getWhoClicked(), 25);
            }
            if(event.getCurrentItem().equals(item4)) {
                //
                item4.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
                item4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                //
                purchaseItem(item4, (Player) event.getWhoClicked(), 50);
            }
        }
    }

    public void purchaseItem(ItemStack item, Player player, int price) {
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

    @EventHandler
    public void repairWeapons(PlayerItemDamageEvent event){
        if(event.getItem() != null) {
            if(event.getItem().getItemMeta().getLore().contains("§6§lP:")) {
                event.setCancelled(true);
            }
        }
    }
}
