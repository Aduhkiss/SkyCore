package club.infinitygames.skycore;

import org.bukkit.Bukkit;

public abstract class Module {
	String _name;
	String _author;
	
	public Module(String name, String author) {
		_name = name;
		_author = author;
		
		// Let console know that we loaded the module
		Bukkit.getLogger().info("[Infinity SkyCore] Loaded module '" + _name + "' by " + _author);
	}
	
	public String getName() {
		return _name;
	}
	
	public String getAuthor() {
		return _author;
	}
}
