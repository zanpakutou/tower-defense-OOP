package javafx13.entities.tower;

import javafx13.Setting;
import javafx13.entities.abstracts.AbstractTower;
import javafx13.entities.basic.Point;

public class PeanutTower extends AbstractTower {
	public PeanutTower(Point position, boolean is_removed) {
		super(position, is_removed, Setting.PEANUT_TOWER_DAMAGE, Setting.PEANUT_TOWER_AS,  1, Setting.PEANUT_TOWER_COST, Setting.PEANUT_TOWER_RANGE);
		this.type = TowerType.PEANUT;
		// TODO Auto-generated constructor stub
	}
}
