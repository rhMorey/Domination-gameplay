package domination.morey.customItems.items;

import domination.morey.customItems.armor.GladiateurReinforced;
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

public class ElectroLame implements Listener {

    ElectroLame electroLame = new ElectroLame();

    public ElectroLame getElectroLame() {
        return electroLame;
    }
    public static ShapedRecipe onCraft() {

        ItemStack item = new ItemStack(main.Item(Material.IRON_SWORD, "§9Electro lame",
                "§7Cette lame est électrifiée",
                "§6§lActif: §eClique droit pour faire apparaître un éclair §8(cooldown: 10s)",
                "§95 Mana",
                " "));
        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
        item.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        NamespacedKey nsKey = new NamespacedKey(plugin, "electrolame");
        ShapedRecipe recipe = new ShapedRecipe(nsKey, item);
        recipe.shape("CAC", "CAC", "BDB");

        recipe.setIngredient('B', Material.AIR);
        recipe.setIngredient('A', Material.IRON_INGOT);
        recipe.setIngredient('C', Material.REDSTONE);
        recipe.setIngredient('D', Material.STICK);
        return recipe;
    }

}
