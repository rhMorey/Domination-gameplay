package domination.morey.npc.pnj.seller;

import domination.morey.customItems.ingredients.FragmentOmbre;
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

import static domination.morey.npc.npcManager.*;

public class MembreCreynois implements Listener {

    MembreCreynois manage;

    public MembreCreynois() {
        manage = this;
    }
    static moneyManage money = new moneyManage();

    public static ItemStack need1 = new ItemStack(FragmentOmbre.result);

    public static ItemStack item1 = new ItemStack(main.Item(Material.ECHO_SHARD, "§3Fragment d'ombre", "§7ᛏᚺᛁᛊ ᛟᛒᛃᛖᚲᛏ ᚺᛟᛚᛞᛊ ᚨᚾ ᛟᚢᛖᚱᚹᚺᛖᛚᛗᛁᛜ ᛈᛟᚹᛖᚱ", // Cet objet détient une puissance débordante
            " ",
            "§7Vente: §b1 Âme§7, §d1 Améthyste"));


    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if(event.getNPC().getName().equals("Membre du Creynois")) {
            player.openInventory(invCreynois(player));
        }

    }
    public Inventory invCreynois(Player player) {

        int myMoney = money.getMoney(player);
        Inventory inv = Bukkit.createInventory(player, 54, "§3Membre du ᚲᚱᛖᛁᚾᛟᛁᛊ");

        //

        //

        inv.setItem(0, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(1, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(2, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(3, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(4, main.Item(Material.DISC_FRAGMENT_5, "§3§lMembre du ᚲᚱᛖᛁᚾᛟᛁᛊ", " ", "§3§lRunique"));
        inv.setItem(5, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(6, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(7, main.Item(Material.CYAN_STAINED_GLASS_PANE, " "));
        inv.setItem(8, paper(player));

        inv.setItem(20, item1);

        //inv.setItem(29, item6);
        //inv.setItem(30, item7);
        //inv.setItem(31, item8);
        //inv.setItem(32, item9);

        return inv;
    }

    @EventHandler
    public void ifClicking(InventoryClickEvent event) {

        ItemStack sell1 = new ItemStack(FragmentOmbre.result);

        ItemStack reward1 = new ItemStack(Material.AMETHYST_SHARD);

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals("§3Membre du ᚲᚱᛖᛁᚾᛟᛁᛊ")) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) return;
            else if (event.getCurrentItem().equals(item1)) {
                sellCustomItem(player, sell1, reward1, 1);
                expreward(player, sell1, 1);
            } else {
                event.setCancelled(true);
            }
        }
    }

}
