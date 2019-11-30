package javafx13.entities.projectile;

import javafx13.entities.abstracts.AbstractEnemy;
import javafx13.entities.abstracts.AbstractProjectile;
import javafx13.entities.basic.Point;

public class FireProjectile extends AbstractProjectile{
	public FireProjectile(Point position, boolean is_removed, int damage, AbstractEnemy e) {
		super(position, is_removed, damage, e);
		// TODO Auto-generated constructor stub
		this.type = ProjectileType.FIRE;
	}
}
