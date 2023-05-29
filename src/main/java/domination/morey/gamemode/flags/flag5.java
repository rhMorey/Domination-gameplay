package domination.morey.gamemode.flags;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import domination.morey.gamemode.capture;
import domination.morey.team.team;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Objects;

public class flag5 implements Listener {

    private int contest = 0;
    private int i = 0;
    static domination.morey.gamemode.capture capture = new capture();
    @EventHandler
    public void captureFlag(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        World w = BukkitAdapter.adapt(player.getWorld());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container.get(w);
        assert regions != null;
        Location playerLocation = player.getLocation();

        // MODIFICATION
        ProtectedRegion flag5 = regions.getRegion("flag5");
        assert flag5 != null;
        // MODIFICATION

        if(event.getClickedBlock() == null) return;
        if (Objects.equals(event.getHand(), EquipmentSlot.OFF_HAND)) return;

        // MODIFICATION
        if(regions.getRegion("flag5") == null) return;
        if(Objects.requireNonNull(regions.getRegion("flag5")).contains(playerLocation.getBlockX(), playerLocation.getBlockY(), playerLocation.getBlockZ())) {
            // MODIFICATION

            if (team.purple.getEntries().contains(player.getName()) && event.getClickedBlock().getType().equals(Material.YELLOW_WOOL)) {
                contest++;
                capture.effect(contest, player);
                String message = "§e " + contest + " §7/ §a20";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                if (contest == 20) {
                    contest = 0;
                    i = 0;
                    //
                    // MODIFICATION COORDONNÉES
                    //
                    capture.whatFlag(flag5, player, playerLocation, 75);
                }
            }
            if (team.purple.getEntries().contains(player.getName()) && event.getClickedBlock().getType().equals(Material.WHITE_WOOL)) {
                i++;
                capture.effect(i, player);
                String message = "§e " + i + " §7/ §a40";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                if (i == 40) {
                    i = 0;
                    contest = 0;
                    capture.whatFlag(flag5, player, playerLocation, 75);
                }
            }
            if (team.yellow.getEntries().contains(player.getName()) && event.getClickedBlock().getType().equals(Material.PURPLE_WOOL)) {
                contest++;
                capture.effect(contest, player);
                String message = "§e " + contest + " §7/ §a20";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                if (contest == 20) {
                    contest = 0;
                    i = 0;
                    capture.whatFlag(flag5, player, playerLocation, 75);
                }
            }
            if (team.yellow.getEntries().contains(player.getName()) && event.getClickedBlock().getType().equals(Material.WHITE_WOOL)) {
                i++;
                capture.effect(i, player);
                String message = "§e " + i + " §7/ §a40";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                if (i == 40) {
                    i = 0;
                    contest = 0;
                    capture.whatFlag(flag5, player, playerLocation, 75);
                }
            }
        }
    }

}
