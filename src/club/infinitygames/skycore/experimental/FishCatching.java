package club.infinitygames.skycore.experimental;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import club.infinitygames.skycore.Module;
import club.infinitygames.skycore.SkyCore;

public class FishCatching extends Module implements Listener {
	public FishCatching() {
		super("Fish Catching (Experimental)", "Atticus Zambrana");
		Bukkit.getPluginManager().registerEvents(this, SkyCore.getInstance());
	}
	
	@EventHandler
	public void fishing(PlayerFishEvent e) {
	}
}
