package domination.morey.customItems.ingredients;

import domination.morey.main;
import domination.morey.npc.pnj.vendor.Alduan;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static domination.morey.main.plugin;

public class GraineSoralite implements Listener {

    GraineSoralite graineSoralite = new GraineSoralite();

    public GraineSoralite getGraineSoralite() {
        return graineSoralite;
    }

    public static ShapedRecipe onCraft() {

        ItemStack item = new ItemStack(main.Item(Material.WHEAT_SEEDS, "§9Graine en Soralite", "§7Cette graine a une puissance incroyable"));
        NamespacedKey nsKey = new NamespacedKey(plugin, "graine_soralite");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, item);
        recipe.shape("CAC", "ABA", "CAC");

        recipe.setIngredient('B', Alduan.item5.getType());
        recipe.setIngredient('C', Material.LEATHER);
        recipe.setIngredient('A', Material.AIR);
        return recipe;
    }

}
