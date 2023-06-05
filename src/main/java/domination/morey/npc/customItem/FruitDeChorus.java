package domination.morey.npc.customItem;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FruitDeChorus implements Listener {

    @EventHandler
    public void onEat(PlayerItemConsumeEvent event) {

        Player player = event.getPlayer();
        if(event.getItem().getItemMeta().getDisplayName().equals("§9Fruit de chorus")) {
            event.setCancelled(true);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 240, 0));
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§aVous vous sentez bien nourri."));
        }
    }
}
