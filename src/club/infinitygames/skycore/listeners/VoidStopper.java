package club.infinitygames.skycore.listeners;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerJoinEvent;

import club.infinitygames.skycore.Module;
import club.infinitygames.skycore.SkyCore;

public class VoidStopper extends Module implements Listener {
	
	public Map<Entity, Boolean> _allowed = new HashMap<Entity, Boolean>();
	
	public VoidStopper() {
		super("Void Stopper", "Atticus Zambrana");
		Bukkit.getPluginManager().registerEvents(this, SkyCore.getInstance());
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		_allowed.put(e.getPlayer(), true);
	}
	
	@EventHandler
	public void onVoidDamage(EntityDamageEvent e) {
		if(!(e.getCause() == DamageCause.VOID)) {
			return;
		}
		if(!(e.getEntity().getLocation().getY() <= 0)) {
			return;
		}
		if(!_allowed.get(e.getEntity())) {
			return;
		}
		if(e.getEntity() instanceof Player) {
			if(e.getEntity().getWorld().getName().equalsIgnoreCase("ASkyBlock")) {
				e.setCancelled(true);
				Bukkit.dispatchCommand(e.getEntity(), "is");
				_allowed.put(e.getEntity(), false);
				Thread t = new Thread() {
					@Override
					public void run() {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						_allowed.put(e.getEntity(), true);
					}
				};
				t.start();
				return;
			}
			if(e.getEntity().getWorld().getName().equalsIgnoreCase("world")) {
				e.setCancelled(true);
				Bukkit.dispatchCommand(e.getEntity(), "spawn");
				_allowed.put(e.getEntity(), false);
				Thread t = new Thread() {
					@Override
					public void run() {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						_allowed.put(e.getEntity(), true);
					}
				};
				t.start();
				return;
			}
		}
	}
}
