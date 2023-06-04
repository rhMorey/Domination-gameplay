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
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Olga implements Listener {

    Olga manage;

    public Olga() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

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
        item2.addItemFlags(ItemFlag.HIDE_DYE);
        item3.addItemFlags(ItemFlag.HIDE_DYE);
        item4.addItemFlags(ItemFlag.HIDE_DYE);
        // ITEM PARAMETER

        inv.setItem(0, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.IRON_CHESTPLATE, "§a§lVendeur d'armure", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
        inv.setItem(5, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(8, main.Item(Material.PAPER, "§6§lProfile§6: §e" + player.getName(), " ", "§aFragment d'émeraude§f: §a" + myMoney + " FE"));

        leatherMeta(item1, Color.GRAY);
        leatherMeta(item2, Color.GRAY);
        leatherMeta(item3, Color.GRAY);
        leatherMeta(item4, Color.GRAY);
        inv.setItem(20, item1);
        inv.setItem(21, item2);
        inv.setItem(22, item3);
        inv.setItem(23, item4);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§aOlga §8- §aGladiateur")) {
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().equals(item1)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item1.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GRAY);
                item1.setItemMeta(item1m);
                //
                purchaseItem(item1, (Player) event.getWhoClicked(), 300);
            }
            if (event.getCurrentItem().equals(item2)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item2.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GRAY);
                item2.setItemMeta(item1m);
                item2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
                //
                purchaseItem(item2, (Player) event.getWhoClicked(), 460);
            }
            if (event.getCurrentItem().equals(item3)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item3.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GRAY);
                item3.setItemMeta(item1m);
                //
                purchaseItem(item3, (Player) event.getWhoClicked(), 290);
            }
            if(event.getCurrentItem().equals(item4)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item4.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GRAY);
                item4.setItemMeta(item1m);
                //
                purchaseItem(item4, (Player) event.getWhoClicked(), 285);
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
            if(event.getItem().getItemMeta().getLore().contains("§6§lFS:")) {
                event.setCancelled(true);
            }
        }
    }

    public void leatherMeta(ItemStack item, Color color) {
        LeatherArmorMeta item1m = (LeatherArmorMeta) item.getItemMeta();
        assert item1m != null;
        item1m.setColor(color);
        item.setItemMeta(item1m);
    }

}
