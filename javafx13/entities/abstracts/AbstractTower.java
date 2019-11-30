package javafx13.entities.abstracts;

import javafx13.entities.Wave;
import javafx13.entities.basic.Point;
import javafx13.entities.projectile.ElectricProjectile;
import javafx13.entities.projectile.FireProjectile;
import javafx13.entities.projectile.PeanutProjectile;
import javafx13.entities.projectile.ProjectileType;
import javafx13.entities.tiles.Tile;
import javafx13.entities.tower.TowerType;

abstract public class AbstractTower extends AbstractGameEntity{
	private int damage, level, cost;
	private long last_shoot_time = -1;
	private double range, attack_speed;
	protected TowerType type;
	private Tile tile;
	
	public TowerType getType() {
		return type;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		if (this.tile != null) this.tile.setOccupied(false);
		this.tile = tile;
		tile.setOccupied(true);
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getAttack_speed() {
		return attack_speed;
	}

	public void setAttack_speed(double attack_speed) {
		this.attack_speed = attack_speed;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	

	public AbstractTower(Point position, boolean is_removed, int damage, double as, int level, int cost,
			double range) {
		super(position, is_removed);
		this.damage = damage;
		this.attack_speed = as;
		this.level = level;
		this.cost = cost;
		this.range = range;
	}
	private double calculateDistance(AbstractEnemy e) {
		double posx = e.getPosition().getX() + 15, posy = e.getPosition().getY() + 15;
		return Math.sqrt((posx - this.getPosition().getX()) * (posx - this.getPosition().getX())
			+	(posy - this.getPosition().getY()) * ((posy - this.getPosition().getY())));
	}
	public AbstractEnemy lockTarget(Wave w) {
		double current_distance = 100000;
		AbstractEnemy target = null;
		for(AbstractEnemy e : w.getEnemy_list())
			if (calculateDistance(e) <= range && calculateDistance(e) < current_distance) {
				if (e.getPosition().getX() < 0 || e.getPosition().getY() < 0) continue;
				if (e.isKilled()) continue;
				current_distance = calculateDistance(e); 
				target =  e;
			}
		return target;
	}
	public AbstractProjectile shoot(ProjectileType p, Wave w, long now) {
		long time_passed = now/100000000 - this.last_shoot_time/100000000;
		if (time_passed * 1.0 > (1.0/this.attack_speed)) {
			this.last_shoot_time = now;
			AbstractEnemy target = lockTarget(w);
			if (target == null) return null;
			if (p == ProjectileType.PEANUT)
				return new PeanutProjectile(new Point(this.getPosition().getX(), this.getPosition().getY()),  false, this.damage, target);
			if (p == ProjectileType.FIRE)
				return new FireProjectile(new Point(this.getPosition().getX(), this.getPosition().getY()),  false, this.damage, target);
			if (p == ProjectileType.ELECTRIC)
				return new ElectricProjectile(new Point(this.getPosition().getX(), this.getPosition().getY()),  false, this.damage, target);
		}
		return null;
	}
	public void upgrade() {
		if (this.level >= 3) return;
		this.level++;
		this.damage = this.damage + this.damage/3;
		this.attack_speed+= 0.2;
		this.range+= 10;
	}
}
