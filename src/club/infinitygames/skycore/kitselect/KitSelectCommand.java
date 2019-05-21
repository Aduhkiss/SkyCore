package club.infinitygames.skycore.kitselect;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import club.infinitygames.api.command.CommandUtil;
import club.infinitygames.skycore.Module;
import net.md_5.bungee.api.ChatColor;

public class KitSelectCommand extends Module implements CommandExecutor {
	
	public KitSelectCommand() {
		super("Kit Select Command", "Atticus Zambrana");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(CommandUtil.canRun("infinitygames.kitselect", sender, true)) {
			sender.sendMessage(ChatColor.RED + "You are not allowed to run this command.");
			return false;
		}
		
		Player player = (Player) sender;
		
		return true;
	}

}
