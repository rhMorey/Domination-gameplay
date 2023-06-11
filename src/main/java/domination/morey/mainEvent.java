package domination.morey;

import com.sk89q.worldguard.bukkit.event.block.BreakBlockEvent;
import domination.morey.economy.moneyManage;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.PiglinAbstract;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityTransformEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Crops;

import java.util.ArrayList;

import static domination.morey.experience.level.addXP;
import static domination.morey.main.plugin;

public class mainEvent implements Listener {

    static moneyManage myMoney = new moneyManage();

    //
    //

    static String patch = "§6§lPatch§6: V0.9-DEV";
    // MODIFIER LE BUKKITSCHEDULER DANS MAINEVENT.CLASS

    //
    //

    @EventHandler
    public void onDie(PlayerDeathEvent event) {

        Player player = event.getPlayer();
        player.sendMessage("§cVous êtes mort");
        int random = (int) (Math.random() * 20);
        myMoney.removeMoney(random, player);
        if (player.getKiller() != null) {
            Player killer = player.getKiller();
            killer.sendMessage("§aVous avez tué §c" + player.getName());
            myMoney.addMoney(random, killer);
        }
    }

    @EventHandler
    public void deathMessage(PlayerDeathEvent event) {

        event.deathMessage(null);
    }

    @EventHandler
    public void onWalk(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if (player.getWorld().getName().equals("world")) {
            Block block = player.getLocation().getBlock();
            if (block.getType().equals(Material.DIRT_PATH) || block.getType().equals(Material.COARSE_DIRT) || block.getType().equals(Material.ROOTED_DIRT)) {
                player.addPotionEffect(new org.bukkit.potion.PotionEffect(org.bukkit.potion.PotionEffectType.SPEED, 20, 1));
            }
        }
    }

    @EventHandler
    public void onConnect(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        event.setJoinMessage("§a+ §7" + player.getName());
        info(event);
        if(!player.hasPlayedBefore()) {
            Bukkit.getServer().broadcastMessage("§f§lFIRST TIME! " + "§d"+player.getName());
        }
    }

    @EventHandler
    public void onDisconnect(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        event.setQuitMessage("§c- §7" + player.getName());
    }

    public void info(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        player.sendMessage("§f§lNEWS §7§l» \n§7NEI ou JEI sont conseillés pour une bonne expérience sur ce serveur.\n" + patch);
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 1, 1);
    }

    @EventHandler
    public void onSleep(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("§cVous ne pouvez pas dormir pour l'instant, il pourrait s'agir d'une futur mise à jour.");
        event.setCancelled(true);
    }
    @EventHandler
    public void onPortal(PlayerPortalEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("§cVous ne pouvez pas utiliser de portail pour l'instant, il pourrait s'agir d'une futur mise à jour.");
        event.setCancelled(true);
    }

    @EventHandler
    public void onBuild(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if(player.isOp()) {
            return;
        }
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new net.md_5.bungee.api.chat.TextComponent(main.prefix + "§cVous ne pouvez pas construire."));
        event.setCancelled(true);
    }

    @EventHandler
    public void onUseAnvil(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getClickedBlock().getType() == Material.ANVIL) {
                event.setCancelled(true);
                player.sendMessage("§cVous ne pouvez pas utiliser d'enclume pour l'instant, il pourrait s'agir d'une futur mise à jour.");
            }
        }
    }

    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setFormat("§e[§f" + plugin.getConfig().get("eco." + player.getUniqueId() + ".xp") + "§e] §f" + event.getPlayer().getName() + " §7§l» §r" + event.getMessage());
    }

    public static ArrayList<Material> listore = new ArrayList<Material>() {
        {
            add(Material.IRON_ORE);
            add(Material.COAL_ORE);
            add(Material.GOLD_ORE);
            add(Material.DIAMOND_ORE);
            add(Material.EMERALD_ORE);
            add(Material.REDSTONE_ORE);
            add(Material.LAPIS_ORE);
        }
    };

    public static ArrayList<Material> listwood = new ArrayList<Material>() {
        {
            add(Material.OAK_LOG);
            add(Material.BIRCH_LOG);
            add(Material.SPRUCE_LOG);
            add(Material.JUNGLE_LOG);
            add(Material.ACACIA_LOG);
            add(Material.DARK_OAK_LOG);
            //add(Material.CRIMSON_STEM);
            //add(Material.WARPED_STEM);
        }
    };

    public static ArrayList<Material> listpickaxe = new ArrayList<Material>() {
        {
            add(Material.WOODEN_PICKAXE);
            add(Material.STONE_PICKAXE);
            add(Material.IRON_PICKAXE);
            add(Material.GOLDEN_PICKAXE);
            add(Material.DIAMOND_PICKAXE);
            add(Material.NETHERITE_PICKAXE);
        }
    };

    public static ArrayList<Material> listaxe = new ArrayList<Material>() {
        {
            add(Material.WOODEN_AXE);
            add(Material.STONE_AXE);
            add(Material.IRON_AXE);
            add(Material.GOLDEN_AXE);
            add(Material.DIAMOND_AXE);
            add(Material.NETHERITE_AXE);
        }
    };

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Material blocktype = event.getBlock().getType();
        if(player.isOp()) {
            return;
        }
        if (listore.contains(blocktype)) {
            if (listpickaxe.contains(player.getInventory().getItemInMainHand().getType())) {
                event.getBlock().setType(Material.STONE);
                player.getInventory().addItem(new ItemStack(getIngot(blocktype, player), 1));
                player.getInventory().getItemInMainHand().setDurability((short) (player.getInventory().getItemInMainHand().getDurability() - 1));

                Bukkit.getScheduler().runTaskLater(main.plugin, () -> {
                    event.getBlock().setType(blocktype);
                //}, 100L);

                // DOIT ETRE MODIFIE POUR VERSION ALPHA

                }, 72000L);

                // DOIT ETRE MODIFIE POUR VERSION ALPHA

                event.setCancelled(true);
            } else {
                player.sendMessage(main.prefix + "Vous devez avoir une pioche pour casser ce bloc.");
                event.setCancelled(true);
            }
        } else if (listwood.contains(blocktype)) {
            if (listaxe.contains(player.getInventory().getItemInMainHand().getType())) {
                event.getBlock().setType(Material.BROWN_CONCRETE);
                player.getInventory().addItem(new ItemStack(getWood(blocktype, player), 1));
                player.getInventory().getItemInMainHand().setDurability((short) (player.getInventory().getItemInMainHand().getDurability() - 1));

                Bukkit.getScheduler().runTaskLater(main.plugin, () -> {
                    event.getBlock().setType(blocktype);
                //}, 100L);

                // DOIT ETRE MODIFIE POUR VERSION ALPHA

                }, 72000L);

                // DOIT ETRE MODIFIE POUR VERSION ALPHA

                event.setCancelled(true);
            } else {
                player.sendMessage(main.prefix + "Vous devez avoir une hache pour casser ce bloc.");
                event.setCancelled(true);
            }
        } else {
            event.setCancelled(true);
            player.sendMessage(main.prefix + "Vous ne pouvez pas casser ce bloc");
        }
    }

    public Material getIngot(Material mat, Player player) {
        switch (mat) {
            case IRON_ORE:
                addXP(3, player);
                return Material.IRON_INGOT;
            case GOLD_ORE:
                addXP(5, player);
                return Material.GOLD_INGOT;
            case DIAMOND_ORE:
                addXP(10, player);
                return Material.DIAMOND;
            case EMERALD_ORE:
                addXP(10, player);
                return Material.EMERALD;
            case REDSTONE_ORE:
                addXP(2, player);
                return Material.REDSTONE;
            case LAPIS_ORE:
                addXP(3, player);
                return Material.LAPIS_LAZULI;
            case COAL_ORE:
                addXP(2, player);
                return Material.COAL;
        }
        return mat;
    }

    public Material getWood(Material mat, Player player) {
        switch (mat) {
            case OAK_WOOD:
                addXP(1, player);
                return Material.OAK_LOG;
        }
        return mat;
    }

    public ArrayList<Material> blacklist = new ArrayList<Material>() {
        {
            add(Material.IRON_SWORD);
            add(Material.IRON_AXE);
            add(Material.STONE_AXE);
            add(Material.STONE_SWORD);
            add(Material.DIAMOND_AXE);
            add(Material.DIAMOND_SWORD);
            add(Material.GOLDEN_AXE);
            add(Material.GOLDEN_SWORD);
            add(Material.NETHERITE_AXE);
            add(Material.NETHERITE_SWORD);
            add(Material.BOW);
            add(Material.CROSSBOW);
            add(Material.SHIELD);
            add(Material.DIAMOND_HELMET);
            add(Material.DIAMOND_CHESTPLATE);
            add(Material.DIAMOND_LEGGINGS);
            add(Material.DIAMOND_BOOTS);
            add(Material.IRON_HELMET);
            add(Material.IRON_CHESTPLATE);
            add(Material.IRON_LEGGINGS);
            add(Material.IRON_BOOTS);
            add(Material.GOLDEN_HELMET);
            add(Material.GOLDEN_CHESTPLATE);
            add(Material.GOLDEN_LEGGINGS);
            add(Material.GOLDEN_BOOTS);
            add(Material.NETHERITE_HELMET);
            add(Material.NETHERITE_CHESTPLATE);
            add(Material.NETHERITE_LEGGINGS);
            add(Material.NETHERITE_BOOTS);
            add(Material.DIAMOND_PICKAXE);
            add(Material.IRON_PICKAXE);
            add(Material.GOLDEN_PICKAXE);
            add(Material.NETHERITE_PICKAXE);
            add(Material.STONE_PICKAXE);
        }
    };

    @EventHandler
    public void onCrafting(CraftItemEvent event) {

        if(blacklist.contains(event.getRecipe().getResult().getType())) {
            event.setCancelled(true);
            event.getWhoClicked().sendMessage(main.prefix + "Vous ne pouvez pas crafter cet item.");
        }
    }
}

