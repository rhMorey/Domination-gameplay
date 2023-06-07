package domination.morey.team.whichclass.tabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class classeTabCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("classe")) {
            if (args.length == 1) {
                List<String> suggestions = new ArrayList<>();
                suggestions.add("tank");
                suggestions.add("healer");
                suggestions.add("dps");
                suggestions.add("autofill");
                return suggestions;
            }
        }
        return null;
    }
}
