package javafx13.entities.tower;

import javafx13.Setting;
import javafx13.entities.abstracts.AbstractTower;
import javafx13.entities.basic.Point;

public class FireTower extends AbstractTower{
	public FireTower(Point position, boolean is_removed) {
		super(position, is_removed, Setting.FIRE_TOWER_DAMAGE, Setting.FIRE_TOWER_AS,  1, Setting.FIRE_TOWER_COST, Setting.FIRE_TOWER_RANGE);
		this.type = TowerType.FIRE;
		// TODO Auto-generated constructor stub
	}

}
