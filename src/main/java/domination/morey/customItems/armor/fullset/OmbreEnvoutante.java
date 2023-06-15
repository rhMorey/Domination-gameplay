package domination.morey.customItems.armor.fullset;

import domination.morey.customItems.ingredients.CuirEnergie;
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

public class OmbreEnvoutante implements Listener {

    OmbreEnvoutante ombreEnvoutante = new OmbreEnvoutante();

    public OmbreEnvoutante getOmbreEnvoutante() {
        return ombreEnvoutante;
    }

    public static ItemStack helmet = new ItemStack(main.Item(Material.LEATHER_HELMET, "§5Coiffe de l'Ombre envoûtante",
            "§7Cet objet appartient à l'ensemble §bOmbre envoûtante"
    ));
    public static ItemStack chestplate = new ItemStack(main.Item(Material.LEATHER_CHESTPLATE, "§5Plastron de l'Ombre envoûtante",
            "§7Cet objet appartient à l'ensemble §bOmbre envoûtante",
            "§7Stats:",
            "§bProtection III"
    ));
    public static ItemStack leggings = new ItemStack(main.Item(Material.LEATHER_LEGGINGS, "§5Guêtres de l'Ombre envoûtante",
            "§7Cet objet appartient à l'ensemble §bOmbre envoûtante"
    ));
    public static ItemStack boots = new ItemStack(main.Item(Material.LEATHER_BOOTS, "§5Chaussures de l'Ombre envoûtante",
            "§7Cet objet appartient à l'ensemble §bOmbre envoûtante",
            "§6FS: §eEffet vitesse II tant que vous portez l'ensemble §bOmbre envoûtante §8(épée incluse)"
    ));
    public static ItemStack sword = new ItemStack(main.Item(Material.IRON_SWORD, "§5Lame de l'Ombre envoûtante",
            "§7Cet objet appartient à l'ensemble §bOmbre envoûtante",
            "§7Stats:",
            "§bTranchant I"
    ));

    public static ShapedRecipe onCraftHelmet() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_helmet");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, helmet);
        recipe.shape("BAB", "CDC", "DDD");

        recipe.setIngredient('A', FragmentOmbre.result);
        recipe.setIngredient('B', Material.AMETHYST_SHARD);
        recipe.setIngredient('C', CuirEnergie.result);
        recipe.setIngredient('D', Material.AIR);
        return recipe;
    }

    public static ShapedRecipe onCraftChestplate() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_chestplate");
        chestplate.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        chestplate.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        ShapedRecipe recipe = new ShapedRecipe(nsKey, chestplate);
        recipe.shape("BDB", "BAB", "CBC");

        recipe.setIngredient('A', FragmentOmbre.result);
        recipe.setIngredient('B', Material.AMETHYST_SHARD);
        recipe.setIngredient('C', CuirEnergie.result);
        recipe.setIngredient('D', Material.AIR);
        return recipe;
    }

    public static ShapedRecipe onCraftLeggings() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_leggings");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, leggings);
        recipe.shape("BCB", "BDB", "CDC");

        recipe.setIngredient('B', Material.AMETHYST_SHARD);
        recipe.setIngredient('C', CuirEnergie.result);
        recipe.setIngredient('D', Material.AIR);
        return recipe;
    }

    public static ShapedRecipe onCraftBoots() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_boots");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, boots);
        recipe.shape("DDD", "BDB", "CDC");

        recipe.setIngredient('B', Material.AMETHYST_SHARD);
        recipe.setIngredient('C', CuirEnergie.result);
        recipe.setIngredient('D', Material.AIR);
        return recipe;
    }

    public static ShapedRecipe onCraftSword() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "shadow_sword");
        sword.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
        ShapedRecipe recipe = new ShapedRecipe(nsKey, sword);
        recipe.shape("DBD", "DAD", "DCD");

        recipe.setIngredient('A', FragmentOmbre.result);
        recipe.setIngredient('B', Material.AMETHYST_SHARD);
        recipe.setIngredient('C', Material.STICK);
        recipe.setIngredient('D', Material.AIR);
        return recipe;
    }

}
