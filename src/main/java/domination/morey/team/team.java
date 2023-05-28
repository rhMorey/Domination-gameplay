package domination.morey.team;

import domination.morey.main;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.Team;

import java.util.Objects;

public class team implements Listener {

    public static Team purple = Bukkit.getServer().getScoreboardManager().getMainScoreboard().getTeam("purple");
    public static Team yellow = Bukkit.getServer().getScoreboardManager().getMainScoreboard().getTeam("yellow");

    // Création des teams
    public void createTeam() {
        if(purple == null) {
            purple = Bukkit.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam("purple");
            purple.setDisplayName("Purple");
            purple.setColor(org.bukkit.ChatColor.DARK_PURPLE);
        }
        if(yellow == null) {
            yellow = Bukkit.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam("yellow");
            yellow.setDisplayName("Yellow");
            yellow.setColor(org.bukkit.ChatColor.YELLOW);
        }
    }

    // Détection si le joueur se connecte -> création des teams + téléportation au spawn
    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        createTeam();
        Player player = event.getPlayer();
        if(!purple.getEntries().contains(player.getName()) && !yellow.getEntries().contains(player.getName())) {

            Location spawn = new Location(Bukkit.getWorld("world"), -671.5, 200, 210.5);
            player.teleport(spawn);
            player.sendMessage(main.prefix + "§eVeuillez choisir une équipe.");
        }
    }

    // Clique sur le bloc qui correspond à l'équipe -> téléportation vers champs de bataille
    @EventHandler
    public void onClickTeam(PlayerInteractEvent event) {

        Location spawnv = new Location(Bukkit.getWorld("world"), -646.5, 66, 326.5);
        Location spawny = new Location(Bukkit.getWorld("world"), 833.5, 78, 338.5);
        Player player = event.getPlayer();
        if(event.getClickedBlock() == null) return;
        // Pour éviter que le joueur clique avec les deux mains
        if (Objects.equals(event.getHand(), EquipmentSlot.OFF_HAND)) return;
        //
        if(event.getClickedBlock().getType() == Material.PURPLE_GLAZED_TERRACOTTA) {
            purple.addEntry(event.getPlayer().getName());
            //player.teleport( BATTLEFIELD )
            player.sendMessage("§aVous êtes maintenant dans l'équipe §5Violet§a.");
            player.teleport(spawnv);
            player.playSound(player.getLocation(), Sound.BLOCK_PORTAL_TRIGGER, 1, 1);
            purpleInv(player);
        }
        if(event.getClickedBlock().getType() == Material.YELLOW_GLAZED_TERRACOTTA) {
            yellow.addEntry(event.getPlayer().getName());
            //player.teleport( BATTLEFIELD )
            player.sendMessage("§aVous êtes maintenant dans l'équipe §eJaune§a.");
            player.teleport(spawny);
            player.playSound(player.getLocation(), Sound.BLOCK_PORTAL_TRIGGER, 1, 1);
            yellowInv(player);
        }
    }

    public void yellowInv(Player player) {

        ItemStack helmety = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta helmetmetay = (LeatherArmorMeta) helmety.getItemMeta();
        assert helmetmetay != null;
        helmetmetay.setColor(Color.YELLOW);
        helmety.setItemMeta(helmetmetay);
        ItemStack chestplatey = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplatemetay = (LeatherArmorMeta) chestplatey.getItemMeta();
        assert chestplatemetay != null;
        chestplatemetay.setColor(Color.YELLOW);
        chestplatey.setItemMeta(chestplatemetay);
        ItemStack leggingsy = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta leggingsmetay = (LeatherArmorMeta) leggingsy.getItemMeta();
        assert leggingsmetay != null;
        leggingsmetay.setColor(Color.YELLOW);
        leggingsy.setItemMeta(leggingsmetay);
        ItemStack bootsy = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsmetay = (LeatherArmorMeta) bootsy.getItemMeta();
        assert bootsmetay != null;
        bootsmetay.setColor(Color.YELLOW);
        bootsy.setItemMeta(bootsmetay);
        ItemStack swordy = new ItemStack(Material.STONE_SWORD);
        player.getInventory().addItem(helmety, chestplatey, leggingsy, bootsy, swordy);
        player.sendMessage(main.prefix + "§aVoici le kit de l'équipe §eJaune.");

    }

    public void purpleInv(Player player) {

        ItemStack helmetp = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta helmetmetap = (LeatherArmorMeta) helmetp.getItemMeta();
        assert helmetmetap != null;
        helmetmetap.setColor(Color.PURPLE);
        helmetp.addEnchantment(org.bukkit.enchantments.Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        helmetp.setItemMeta(helmetmetap);
        ItemStack chestplatep = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta chestplatemetap = (LeatherArmorMeta) chestplatep.getItemMeta();
        assert chestplatemetap != null;
        chestplatemetap.setColor(Color.PURPLE);
        chestplatep.setItemMeta(chestplatemetap);
        ItemStack leggingsp = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta leggingsmetap = (LeatherArmorMeta) leggingsp.getItemMeta();
        assert leggingsmetap != null;
        leggingsmetap.setColor(Color.PURPLE);
        leggingsp.setItemMeta(leggingsmetap);
        ItemStack bootsp = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta bootsmetap = (LeatherArmorMeta) bootsp.getItemMeta();
        assert bootsmetap != null;
        bootsmetap.setColor(Color.PURPLE);
        bootsp.setItemMeta(bootsmetap);
        ItemStack swordp = new ItemStack(Material.STONE_SWORD);
        player.getInventory().addItem(helmetp, chestplatep, leggingsp, bootsp, swordp);
        player.sendMessage(main.prefix + "§aVoici le kit de l'équipe §5Violet.");

    }

    @EventHandler
    public void whichTeam(EntityDamageByEntityEvent event) {

        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getDamager();
            Entity target = event.getEntity();
            if(target instanceof Player) return;
            if (purple.getEntries().contains(player.getName()) && purple.getEntries().contains(target.getName())) {
                event.setCancelled(true);
            }
            if(yellow.getEntries().contains(player.getName()) && yellow.getEntries().contains(target.getName())) {
                event.setCancelled(true);
            }
        }
    }
}
