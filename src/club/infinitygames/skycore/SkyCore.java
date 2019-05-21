package club.infinitygames.skycore;

import org.bukkit.plugin.java.JavaPlugin;

import club.infinitygames.skycore.experimental.FishCatching;
import club.infinitygames.skycore.help.HelpCommand;
import club.infinitygames.skycore.listeners.JoinFirework;
import club.infinitygames.skycore.listeners.VoidStopper;

public class SkyCore extends JavaPlugin {
	
	static SkyCore instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		new VoidStopper();
		new FishCatching();
		new JoinFirework();
		new HelpCommand();
		
	}
	
	public static SkyCore getInstance() {
		return instance;
	}

}
