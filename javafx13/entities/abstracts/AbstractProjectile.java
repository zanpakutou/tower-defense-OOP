package javafx13.entities.abstracts;

import javafx13.entities.basic.Point;
import javafx13.entities.projectile.ProjectileType;

public class AbstractProjectile extends AbstractMobileEntity{
	
	protected ProjectileType type;
	private AbstractEnemy e;
	private int damage;
	public ProjectileType getType() {
		return type;
	} 
	public int getDamage() {
		return this.damage;
	}
	public AbstractProjectile(Point position, boolean is_removed, int damage,  AbstractEnemy e) {
		super(position, is_removed, 3.5);
		this.damage = damage;
		this.e = e;
		// TODO Auto-generated constructor stub
	}
	
	public AbstractEnemy getEnemy() {
		return e;
	}
	public void lockEnemy(AbstractEnemy e) {
		this.e = e;
	}
	public void moveToEnemy() {
		double deltaX = e.getPosition().getX() + 15 - this.getPosition().getX();
		double deltaY = e.getPosition().getY() + 15 - this.getPosition().getY();
		this.setAngle(Math.atan2(deltaY, deltaX));
		this.move();
	}
	public boolean isReach() {
		double x = e.getPosition().getX();
		double y = e.getPosition().getY();
		
		return (x + 10 <= this.getPosition().getX() && this.getPosition().getX() <= x + 25 && (y + 10  <= this.getPosition().getY()
				&& this.getPosition().getY() <= y + 25));
	}
}
