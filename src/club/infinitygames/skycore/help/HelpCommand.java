package club.infinitygames.skycore.help;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import club.infinitygames.api.command.CommandUtil;
import club.infinitygames.skycore.Module;
import club.infinitygames.skycore.SkyCore;
import net.md_5.bungee.api.ChatColor;

public class HelpCommand extends Module implements CommandExecutor {
	
	public HelpCommand() {
		super("Help Command", "Atticus Zambrana");
		SkyCore.getInstance().getCommand("help").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!CommandUtil.canRun("infinitygames.help", sender, false)) {
			sender.sendMessage(ChatColor.RED + "You are not allowed to run this command!");
			return false;
		}
		
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Welcome to Infinity Sky!");
		sender.sendMessage("\n");
		sender.sendMessage(ChatColor.GREEN + "If you have any questions or concerns, please connect to our Discord Server:");
		sender.sendMessage(ChatColor.GOLD + "https://discord.gg/NZVg33g");
		
		return true;
	}

}
