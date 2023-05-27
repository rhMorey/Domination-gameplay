package domination.morey.gamemode;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldedit.world.World;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import domination.morey.main;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Objects;

public class capture implements Listener {

    capture manage;
    public int i = 0;

    public capture() {
        manage = this;
    }

    /*@EventHandler
    public void captureFlag(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        World w = BukkitAdapter.adapt(player.getWorld());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container.get(w);

        assert regions != null;
        ProtectedRegion flag1 = regions.getRegion("flag1");
        ProtectedRegion flag2 = regions.getRegion("flag2");

        Location playerLocation = player.getLocation();
        if (Objects.equals(event.getHand(), EquipmentSlot.OFF_HAND)) return;
        if(event.getClickedBlock() == null) return;
        assert flag1 != null;
        assert flag2 != null;
        whatFlag(flag1, player, playerLocation, event.getClickedBlock(), 66);
        whatFlag(flag2, player, playerLocation, event.getClickedBlock(), 69);

    }*/

    public void whatFlag(ProtectedRegion flag, Player player, Location playerLocation, Block clicked, int y) {
        if (flag.contains(playerLocation.getBlockX(), playerLocation.getBlockY(), playerLocation.getBlockZ())) {
            if(clicked.getType().equals(Material.WHITE_WOOL)) {
                i++;
                System.out.println(i);
                String message = "§e " + i + " §7/ §a40";
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
                if (i == 40) {
                    player.sendMessage("§aVous avez capturé le drapeau");
                    player.sendMessage(main.getCenter(flag, y).toString());
                    if(main.getCenter(flag, y).getType().equals(Material.WHITE_WOOL)) {
                        main.getCenter(flag, y).setType(Material.PURPLE_WOOL);

                    }
                    i = 0;
                }
            }
        }
    }
}
