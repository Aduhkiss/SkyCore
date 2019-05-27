package club.infinitygames.skycore.experimental;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.util.Vector;

import club.infinitygames.skycore.Module;

public class VoidKaboom extends Module {
	public VoidKaboom() {
		super("Void Kaboom", "Atticus Zambrana");
	}
	
	@EventHandler
	public void onVoidDamage(EntityDamageEvent e) {
		if(!(e.getCause() == DamageCause.VOID)) {
			return;
		}
		if(!(e.getEntity().getLocation().getY() <= 0)) {
			return;
		}
		if(!(e.getEntity() instanceof Player)) {
			return;
		}
		
		// Kaboom.
		e.getEntity().getWorld().strikeLightningEffect(e.getEntity().getLocation());
		Vector vector = new Vector(0, 1, 0);
		e.getEntity().setVelocity(vector.multiply(5));
	}
}
