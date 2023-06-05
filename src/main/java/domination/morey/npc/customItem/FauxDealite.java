package domination.morey.npc.customItem;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.UUID;

public class FauxDealite implements Listener {

    @EventHandler
    public void onKillWithFauxDealite(EntityDeathEvent event) {

        if (event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getKiller();
            Entity entity = event.getEntity();
            if (entity instanceof Monster) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§5Faux en Dealite")) {
                    player.setLevel(player.getLevel() + 1);
                }
            }
            if(entity instanceof Player) {
                if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals("§5Faux en Dealite")) {
                    player.setLevel(player.getLevel() + 4);
                    player.sendMessage("§b+4 Âmes");
                }
            }
        }
    }
}
