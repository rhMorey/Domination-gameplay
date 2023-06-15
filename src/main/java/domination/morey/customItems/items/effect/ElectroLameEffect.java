package domination.morey.customItems.items.effect;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static domination.morey.customItems.customItems.getTimer;
import static domination.morey.experience.level.addMana;
import static domination.morey.experience.level.getMana;

public class ElectroLameEffect implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {

        int cost = 5;
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if(event.getAction().isRightClick() && item.getItemMeta().getDisplayName().equals("§9Electro lame")) {
            if(player.getCooldown(item.getType()) <= 0) {
                if (getMana(player) >= 5) {
                    player.getWorld().strikeLightning(player.getTargetBlock(null, 20).getLocation());
                    player.setCooldown(item.getType(), 200);
                    addMana(player, getMana(player) - cost);
                    String message = "§eIl vous reste §9" + getMana(player) + " Mana";
                    player.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent.fromLegacyText(message));
                } else {
                    String message = "§cVous n'avez pas assez de mana";
                    player.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent.fromLegacyText(message));
                }
            } else {
                String message = "§cCooldown: §e" + getTimer(player, item) + " secondes";
                player.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR, net.md_5.bungee.api.chat.TextComponent.fromLegacyText(message));
            }
        }
    }
}
