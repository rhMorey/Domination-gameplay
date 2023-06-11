package domination.morey.npc.pnj.vendor;

import domination.morey.economy.moneyManage;
import domination.morey.main;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
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

public class Mila implements Listener {

    Mila manage;

    public Mila() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

    //
    // HEALER SET
    // CELION
    //
    public static ItemStack item1 = new ItemStack(main.Item(Material.LEATHER_HELMET, "§aChapeau Célion",
            "§7Cet objet appartient à l'ensemble §bcélion",
            " ",
            "§7Prix: §a310 FE"));
    public static ItemStack item2 = new ItemStack(main.Item(Material.LEATHER_CHESTPLATE, "§aTunique Célion",
            "§7Cet objet appartient à l'ensemble §bcélion",
            " ",
            "§7Prix: §a475 FE"));
    public static ItemStack item3 = new ItemStack(main.Item(Material.LEATHER_LEGGINGS, "§aJambières Célion",
            "§7Cet objet appartient à l'ensemble §bcélion",
            " ",
            "§7Prix: §a300 FE"));
    public static ItemStack item4 = new ItemStack(main.Item(Material.LEATHER_BOOTS, "§aBottes Célion",
            "§7Cet objet appartient à l'ensemble §bcélion",
            "§6§lFS: §eOctroie régénération I autour du porteur sur une distance de 5 blocks",
            " ",
            "§7Prix: §a290 FE"));
    //
    // HEALER SET
    // RESTAURATEUR
    //
    public static ItemStack item5 = new ItemStack(main.Item(Material.LEATHER_HELMET, "§9Chapeau du Restaurateur",
            "§7Cet objet appartient à l'ensemble §arestaurateur",
            " ",
            "§7Prix: §a410 FE"));
    public static ItemStack item6 = new ItemStack(main.Item(Material.LEATHER_CHESTPLATE, "§9Tunique du Restaurateur",
            "§7Cet objet appartient à l'ensemble §arestaurateur",
            " ",
            "§7Prix: §a580 FE"));
    public static ItemStack item7 = new ItemStack(main.Item(Material.LEATHER_LEGGINGS, "§9Jambières du Restaurateur",
            "§7Cet objet appartient à l'ensemble §arestaurateur",
            " ",
            "§7Prix: §a470 FE"));
    public static ItemStack item8 = new ItemStack(main.Item(Material.LEATHER_BOOTS, "§9Bottes du Restaurateur",
            "§7Cet objet appartient à l'ensemble §arestaurateur",
            "§6§lFS: §eOctroie régénération II et absorption II autour du porteur sur une distance de 5 blocks",
            " ",
            "§7Prix: §a400 FE"));

    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Mila")) {
            player.openInventory(invMila(player));
        }

    }

    public Inventory invMila(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§aMila §8- §aSoigneur célion");

        // ITEM PARAMETER
        item1.addItemFlags(ItemFlag.HIDE_DYE);
        item2.addItemFlags(ItemFlag.HIDE_DYE);
        item3.addItemFlags(ItemFlag.HIDE_DYE);
        item4.addItemFlags(ItemFlag.HIDE_DYE);
        leatherMeta(item1, Color.WHITE);
        leatherMeta(item2, Color.RED);
        leatherMeta(item3, Color.WHITE);
        leatherMeta(item4, Color.WHITE);
        item5.addItemFlags(ItemFlag.HIDE_DYE);
        item6.addItemFlags(ItemFlag.HIDE_DYE);
        item7.addItemFlags(ItemFlag.HIDE_DYE);
        item8.addItemFlags(ItemFlag.HIDE_DYE);
        leatherMeta(item5, Color.GRAY);
        leatherMeta(item6, Color.GREEN);
        leatherMeta(item7, Color.GREEN);
        leatherMeta(item8, Color.GRAY);
        // ITEM PARAMETER

        inv.setItem(0, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.GRAY_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.IRON_CHESTPLATE, "§a§lSoigneur célion", " ", "§fCommun, §aAtypique§f, §9Rare§f, §5Épique§f, §6Mythique"));
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

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        if (event.getView().getTitle().equals("§aMila §8- §aSoigneur célion")) {
            if (event.getCurrentItem() == null) return;
            if(event.getAction().equals(InventoryAction.MOVE_TO_OTHER_INVENTORY)) {
                event.setCancelled(true);
            }
            else if (event.getCurrentItem().equals(item1)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item1.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.WHITE);
                item1.setItemMeta(item1m);
                //
                purchaseItem(event, item1, (Player) event.getWhoClicked(), 310);
            }
            else if(event.getCurrentItem().equals(item2)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item2.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.RED);
                item2.setItemMeta(item1m);
                //
                purchaseItem(event, item2, (Player) event.getWhoClicked(), 475);
            }
            else if(event.getCurrentItem().equals(item3)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item3.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.WHITE);
                item3.setItemMeta(item1m);
                //
                purchaseItem(event, item3, (Player) event.getWhoClicked(), 300);
            }
            else if(event.getCurrentItem().equals(item4)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item4.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.WHITE);
                item4.setItemMeta(item1m);
                //
                purchaseItem(event, item4, (Player) event.getWhoClicked(), 290);
            }
            else if (event.getCurrentItem().equals(item5)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item5.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GRAY);
                item5.setItemMeta(item1m);
                //
                purchaseItem(event, item5, (Player) event.getWhoClicked(), 310);
            }
            else if(event.getCurrentItem().equals(item6)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item6.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GREEN);
                item6.setItemMeta(item1m);
                //
                purchaseItem(event, item6, (Player) event.getWhoClicked(), 475);
            }
            else if(event.getCurrentItem().equals(item7)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item7.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GREEN);
                item7.setItemMeta(item1m);
                //
                purchaseItem(event, item7, (Player) event.getWhoClicked(), 300);
            }
            else if(event.getCurrentItem().equals(item8)) {
                //
                LeatherArmorMeta item1m = (LeatherArmorMeta) item8.getItemMeta();
                assert item1m != null;
                item1m.setColor(Color.GRAY);
                item8.setItemMeta(item1m);
                //
                purchaseItem(event, item8, (Player) event.getWhoClicked(), 290);
            } else {
                event.setCancelled(true);
            }
        }
    }

}
