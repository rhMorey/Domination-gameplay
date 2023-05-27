package domination.morey.gamemode.flags;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import domination.morey.gamemode.capture;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Objects;

public class flag2 implements Listener {

    static domination.morey.gamemode.capture capture = new capture();
    @EventHandler
    public void captureFlag(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        World w = BukkitAdapter.adapt(player.getWorld());
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container.get(w);
        assert regions != null;

        // MODIFICATION
        ProtectedRegion flag2 = regions.getRegion("flag2");
        assert flag2 != null;

        Location playerLocation = player.getLocation();
        if (Objects.equals(event.getHand(), EquipmentSlot.OFF_HAND)) return;
        if(event.getClickedBlock() == null) return;

        // MODIFICATION
        capture.whatFlag(flag2, player, playerLocation, event.getClickedBlock(), 69);
    }

}
