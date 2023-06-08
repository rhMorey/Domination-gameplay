package domination.morey.npc.pnj.bank;

import domination.morey.main;
import io.papermc.paper.event.player.PlayerInventorySlotChangeEvent;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.EnderChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class Banquier implements Listener {

    @EventHandler
    public void interactNpc(NPCRightClickEvent event) {

        Player player = event.getClicker();
        if (event.getNPC().getName().equals("Banquier")) {
            player.openInventory(player.getEnderChest());
        }
    }
}
