package domination.morey.customItems.ingredients;

import domination.morey.main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static domination.morey.main.plugin;

public class CuirEnergie implements Listener {

    CuirEnergie cuirEnergie = new CuirEnergie();

    public CuirEnergie getCuirEnergie() {
        return cuirEnergie;
    }

    public static ItemStack result = new ItemStack(main.Item(Material.LEATHER, "§fCuir compressé",
            "§7Le Cuir compressé est bien plus résistant que le cuir."));

    public static ShapedRecipe onCraft() {

        NamespacedKey nsKey = new NamespacedKey(plugin, "reinforced_leather");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, result);
        recipe.shape("ABA", "BCB", "ABA");

        recipe.setIngredient('A', Material.AIR);
        recipe.setIngredient('B', Material.LEATHER);
        recipe.setIngredient('C', Material.BLAZE_POWDER);
        return recipe;
    }

}
