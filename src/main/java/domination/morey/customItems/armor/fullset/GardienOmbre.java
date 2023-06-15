package domination.morey.customItems.armor.fullset;

import domination.morey.customItems.ingredients.FerEnergie;
import domination.morey.customItems.ingredients.FragmentOmbre;
import domination.morey.main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static domination.morey.main.plugin;

public class GardienOmbre implements Listener {

    GardienOmbre gardienOmbre = new GardienOmbre();

    public GardienOmbre getGardienOmbre() {
        return gardienOmbre;
    }

    public static ItemStack helmet = new ItemStack(main.Item(Material.IRON_HELMET, "§5Heaume du Gardien d'ombre",
            "§7Cet objet appartient à l'ensemble §bGardien d'ombre"
            ));
    public static ItemStack chestplate = new ItemStack(main.Item(Material.IRON_CHESTPLATE, "§5Tablier du Gardien d'ombre",
            "§7Cet objet appartient à l'ensemble §bGardien d'ombre",
            "§7Stats:",
            "§bProtection III"
    ));
    public static ItemStack leggings = new ItemStack(main.Item(Material.IRON_LEGGINGS, "§5Jambières du Gardien d'ombre",
            "§7Cet objet appartient à l'ensemble §bGardien d'ombre",
            "§7Stats:",
            "§bProtection II"
    ));
    public static ItemStack boots = new ItemStack(main.Item(Material.IRON_BOOTS, "§5Bottes du Gardien d'ombre",
            "§7Cet objet appartient à l'ensemble §bGardien d'ombre",
            "§6FS: §eEffet résistance II tant que vous portez l'ensemble §bGardien d'ombre"
    ));

    public static ShapedRecipe onCraftHelmet() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_guardian_helmet");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, helmet);
        recipe.shape("BAB", "CDC", "DDD");

        recipe.setIngredient('A', FragmentOmbre.result);
        recipe.setIngredient('B', Material.AMETHYST_SHARD);
        recipe.setIngredient('C', FerEnergie.result);
        recipe.setIngredient('D', Material.AIR);
        return recipe;
    }

    public static ShapedRecipe onCraftChestplate() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_guardian_chestplate");
        chestplate.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        ShapedRecipe recipe = new ShapedRecipe(nsKey, chestplate);
        recipe.shape("BDB", "BAB", "CBC");

        recipe.setIngredient('A', FragmentOmbre.result);
        recipe.setIngredient('B', Material.AMETHYST_SHARD);
        recipe.setIngredient('C', FerEnergie.result);
        recipe.setIngredient('D', Material.AIR);
        return recipe;
    }

    public static ShapedRecipe onCraftLeggings() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_guardian_leggings");
        leggings.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        leggings.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        ShapedRecipe recipe = new ShapedRecipe(nsKey, leggings);
        recipe.shape("BCB", "BDB", "CDC");

        recipe.setIngredient('B', Material.AMETHYST_SHARD);
        recipe.setIngredient('C', FerEnergie.result);
        recipe.setIngredient('D', Material.AIR);
        return recipe;
    }

    public static ShapedRecipe onCraftBoots() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_guardian_boots");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, boots);
        recipe.shape("DDD", "BDB", "CDC");

        recipe.setIngredient('B', Material.AMETHYST_SHARD);
        recipe.setIngredient('C', FerEnergie.result);
        recipe.setIngredient('D', Material.AIR);
        return recipe;
    }

}
