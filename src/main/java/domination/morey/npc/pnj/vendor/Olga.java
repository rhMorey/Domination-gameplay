package domination.morey.npc.pnj.vendor;

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
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import static domination.morey.npc.npcManager.*;

public class Olga implements Listener {

    Olga manage;

    public Olga() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

    //
    // DPS SET
    //
    public static ItemStack item1 = new ItemStack(main.Item(Material.LEATHER_HELMET, "§aChapeau Dortiate",
            "§7Cet objet appartient à l'ensemble §bDortiate",
            " ",
            "§7Prix: §a300 FE"));
    public static ItemStack item2 = new ItemStack(main.Item(Material.LEATHER_CHESTPLATE, "§9Tablier Dortiate",
            "§7Cet objet appartient à l'ensemble §bDortiate",
            "§7Stats:",
            "§bProtection II",
            " ",
            "§7Prix: §a460 FE"));
    public static ItemStack item3 = new ItemStack(main.Item(Material.LEATHER_LEGGINGS, "§aCuirasse Dortiate",
            "§7Cet objet appartient à l'ensemble §bDortiate",
            " ",
            "§7Prix: §a290 FE"));
    public static ItemStack item4 = new ItemStack(main.Item(Material.LEATHER_BOOTS, "§aBottines Dortiate",
            "§7Cet objet appartient à l'ensemble §bDortiate",
            "§6§lFS: §eEffet vitesse I tant que vous portez l'ensemble §bDortiate",
            " ",
            "§7Prix: §a285 FE"));
    public static ItemStack item5 = new ItemStack(main.Item(Material.CHAINMAIL_CHESTPLATE, "§9Plastron du Gladiateur d'élite",
            "§7Cet objet appartient à l'ensemble §bGladiateur amateur",
            "§7Stats:",
            "§bProtection II",
            " ",
            "§7Prix: §a680 FE"));
    //
    // TANK SET
    //
    public static ItemStack item6 = new ItemStack(main.Item(Material.CHAINMAIL_HELMET, "§aCasque du Gladiateur amateur",
            "§7Cet objet appartient à l'ensemble §bGladiateur amateur",
            " ",
            "§7Prix: §a320 FE"));
    public static ItemStack item7 = new ItemStack(main.Item(Material.IRON_CHESTPLATE, "§aPlastron du Gladiateur amateur",
            "§7Cet objet appartient à l'ensemble §bGladiateur amateur",
            "§7Stats:",
            "§bProtection I",
            " ",
            "§7Prix: §a490 FE"));
    public static ItemStack item8 = new ItemStack(main.Item(Material.CHAINMAIL_LEGGINGS, "§aJambières du Gladiateur amateur",
            "§7Cet objet appartient à l'ensemble §bGladiateur amateur",
            " ",
            "§7Prix: §a310 FE"));
    public static ItemStack item9 = new ItemStack(main.Item(Material.CHAINMAIL_BOOTS, "§aBottes du Gladiateur amateur",
            "§7Cet objet appartient à l'ensemble §bGladiateur amateur",
            "§6§lFS: §eEffet résistance I tant que vous portez l'ensemble §bGladiateur amateur §8(épée incluse)",
            " ",
            "§7Prix: §a300 FE"));

    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Olga")) {
            player.openInventory(invOlga(player));
        }

    }

    public Inventory invOlga(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§aOlga §8- §aGladiateur");

        // ITEM PARAMETER
        item1.addItemFlags(ItemFlag.HIDE_DYE);
        item2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item2.addItemFlags(ItemFlag.HIDE_DYE);
        item3.addItemFlags(ItemFlag.HIDE_DYE);
        item4.addItemFlags(ItemFlag.HIDE_DYE);
        leatherMeta(item1, Color.GRAY);
        leatherMeta(item2, Color.GRAY);
        leatherMeta(item3, Color.GRAY);
        leatherMeta(item4, Color.GRAY);
        // ITEM PARAMETER

        inv.setItem(0, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.IRON_CHESTPLATE, "§a§lVendeur d'armure", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
        inv.setItem(5, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(8, paper(player));

        inv.setItem(20, item1);
        inv.setItem(21, item2);
        inv.setItem(22, item3);
        inv.setItem(23, item4);
        inv.setItem(24, item5);
        inv.setItem(29, item6);
        inv.setItem(30, item7);
        inv.setItem(31, item8);
        inv.setItem(32, item9);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§aOlga §8- §aGladiateur")) {
            if (event.getCurrentItem() == null) return;
            if(event.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                event.setCancelled(true);
            }
            else if (event.getCurrentItem().equals(item1)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item1.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GRAY);
                item1.setItemMeta(item1m);
                //
                purchaseItem(event, item1, (Player) event.getWhoClicked(), 300);
            }
            else if (event.getCurrentItem().equals(item2)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item2.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GRAY);
                item2.setItemMeta(item1m);
                item2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                //
                purchaseItem(event, item2, (Player) event.getWhoClicked(), 460);
            }
            else if (event.getCurrentItem().equals(item3)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item3.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GRAY);
                item3.setItemMeta(item1m);
                //
                purchaseItem(event, item3, (Player) event.getWhoClicked(), 290);
            }
            else if(event.getCurrentItem().equals(item4)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item4.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GRAY);
                item4.setItemMeta(item1m);
                //
                purchaseItem(event, item4, (Player) event.getWhoClicked(), 285);
            }
            else if(event.getCurrentItem().equals(item5)) {
                //
                item5.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                //
                purchaseItem(event, item5, (Player) event.getWhoClicked(), 680);
            }
            else if(event.getCurrentItem().equals(item6)) {
                purchaseItem(event, item6, (Player) event.getWhoClicked(), 320);
            }
            else if(event.getCurrentItem().equals(item7)) {
                //
                item7.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                //
                purchaseItem(event, item7, (Player) event.getWhoClicked(), 490);
            }
            else if(event.getCurrentItem().equals(item8)) {
                purchaseItem(event, item8, (Player) event.getWhoClicked(), 310);
            }
            else if(event.getCurrentItem().equals(item9)) {
                purchaseItem(event, item9, (Player) event.getWhoClicked(), 300);
            } else {
                event.setCancelled(true);
            }
        }
    }
}
