package domination.morey.customItems.armor;

import domination.morey.customItems.ingredients.SolidificationArmure;
import domination.morey.main;
import domination.morey.npc.pnj.vendor.Olga;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static domination.morey.main.plugin;

public class GladiateurReinforced implements Listener {

    GladiateurReinforced gladiateurReinforced = new GladiateurReinforced();

    public GladiateurReinforced getGladiateurReinforced() {
        return gladiateurReinforced;
    }
    public static ShapedRecipe onCraft() {

        ItemStack item = new ItemStack(main.Item(Material.CHAINMAIL_CHESTPLATE, "§9Plastron du Gladiteur d'élite renforcé",
                "§7Cet objet appartient à l'ensemble §bGladiateur amateur",
                "§7Stats:",
                "§bProtection III"));
        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
        NamespacedKey nsKey = new NamespacedKey(plugin, "gladiateur_chestplate_reinforced");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, item);
        recipe.shape("CAC", "ABA", "CAC");

        Olga.item5.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        Olga.item5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        recipe.setIngredient('B', Olga.item5);
        recipe.setIngredient('A', SolidificationArmure.result);
        recipe.setIngredient('C', Material.AIR);
        return recipe;
    }

}
