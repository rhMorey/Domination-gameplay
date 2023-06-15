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

public class Lazsnite implements Listener {

    Lazsnite manage;

    public Lazsnite() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

    public static ItemStack item1 = new ItemStack(main.Item(Material.CHAINMAIL_HELMET, "§9Heaume du Fort",
            "§7Cet objet appartient à l'ensemble du §bFort",
            " ",
            "§7Prix: §a630 FE"));
    public static ItemStack item2 = new ItemStack(main.Item(Material.IRON_CHESTPLATE, "§9Plastron du Fort",
            "§7Cet objet appartient à l'ensemble du §bFort",
            "§7Stats:",
            "§bProtection I",
            " ",
            "§7Prix: §a760 FE"));
    public static ItemStack item3 = new ItemStack(main.Item(Material.IRON_LEGGINGS, "§9Cuirasse du Fort",
            "§7Cet objet appartient à l'ensemble du §bFort",
            "§7Stats:",
            "§bProtection I",
            " ",
            "§7Prix: §a710 FE"));
    public static ItemStack item4 = new ItemStack(main.Item(Material.CHAINMAIL_BOOTS, "§9Bottes du Fort",
            "§7Cet objet appartient à l'ensemble du §bFort",
            "§6§lFS: §eEffet résistance II tant que vous portez l'ensemble §bFort",
            " ",
            "§7Prix: §a650 FE"));

    public static ItemStack item5 = new ItemStack(main.Item(Material.LEATHER_HELMET, "§9Casque du Bourreau",
            "§7Cet objet appartient à l'ensemble du §bBourreau",
            " ",
            "§7Prix: §a610 FE"));
    public static ItemStack item6 = new ItemStack(main.Item(Material.CHAINMAIL_CHESTPLATE, "§9Poitrail du Bourreau",
            "§7Cet objet appartient à l'ensemble du §bBourreau",
            " ",
            "§7Prix: §a740 FE"));
    public static ItemStack item7 = new ItemStack(main.Item(Material.CHAINMAIL_LEGGINGS, "§9Cuirasse du Bourreau",
            "§7Cet objet appartient à l'ensemble du §bBourreau",
            " ",
            "§7Prix: §a680 FE"));
    public static ItemStack item8 = new ItemStack(main.Item(Material.LEATHER_BOOTS, "§9Bottes du Bourreau",
            "§7Cet objet appartient à l'ensemble du §bBourreau",
            "§6§lFS: §eEffet vitesse I tant que vous portez l'ensemble §bBourreau",
            " ",
            "§7Prix: §a600 FE"));
    public static ItemStack item9 = new ItemStack(main.Item(Material.STONE_AXE, "§9Hache du Bourreau",
            "§7Cet objet appartient à l'ensemble du §bBourreau",
            "§6§lFS: §eEffet vitesse I tant que vous portez l'ensemble §bBourreau §8(épée incluse)",
            " ",
            "§7Prix: §a810 FE"));

    // FULL SET DU BOURREAU
    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Maître-forge Lazsnite")) {
            player.openInventory(invElise(player));
        }
    }

    public Inventory invElise(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§aLazsnite §8- §aMaître-forge");

        // ITEM PARAMETER
        item2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        item3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        item9.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
        // ITEM PARAMETER

        inv.setItem(0, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.ENDER_EYE, "§a§lMaître-forge", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
        inv.setItem(5, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(8, paper(player));

        inv.setItem(20, item1);
        inv.setItem(21, item2);
        inv.setItem(22, item3);
        inv.setItem(23, item4);
        inv.setItem(29, item5);
        inv.setItem(30, item6);
        inv.setItem(31, item7);
        inv.setItem(32, item8);
        inv.setItem(33, item9);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§aLazsnite §8- §aMaître-forge")) {
            if (event.getCurrentItem() == null) return;
            if(event.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                event.setCancelled(true);
            }
            else if (event.getCurrentItem().equals(item1)) {
                purchaseItem(event, item1, (Player) event.getWhoClicked(), 630);
            }
            else if (event.getCurrentItem().equals(item2)) {
                //
                item2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                item2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                //
                purchaseItem(event, item2, (Player) event.getWhoClicked(), 760);
            }
            else if (event.getCurrentItem().equals(item3)) {
                //
                item3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                item3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
                //
                purchaseItem(event, item3, (Player) event.getWhoClicked(), 710);
            }
            else if(event.getCurrentItem().equals(item4)) {
                purchaseItem(event, item4, (Player) event.getWhoClicked(), 650);
            }
            else if(event.getCurrentItem().equals(item5)) {
                purchaseItem(event, item5, (Player) event.getWhoClicked(), 610);
            }
            else if(event.getCurrentItem().equals(item6)) {
                purchaseItem(event, item6, (Player) event.getWhoClicked(), 740);
            }
            else if(event.getCurrentItem().equals(item7)) {
                purchaseItem(event, item7, (Player) event.getWhoClicked(), 680);
            }
            else if(event.getCurrentItem().equals(item8)) {
                purchaseItem(event, item8, (Player) event.getWhoClicked(), 600);
            }
            else if(event.getCurrentItem().equals(item9)) {
                //
                item9.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                item9.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
                //
                purchaseItem(event, item9, (Player) event.getWhoClicked(), 810);
            } else {
                event.setCancelled(true);
            }
        }
    }

}
