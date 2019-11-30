package javafx13.entities.tower;

import javafx13.Setting;
import javafx13.entities.abstracts.AbstractTower;
import javafx13.entities.basic.Point;

public class ElectricTower extends AbstractTower{

	public ElectricTower(Point position, boolean is_removed) {
		super(position, is_removed, Setting.ELECTRIC_TOWER_DAMAGE, Setting.ELECTRIC_TOWER_AS, 1, Setting.ELECTRIC_TOWER_COST, Setting.ELECTRIC_TOWER_RANGE);
		// TODO Auto-generated constructor stub
		this.type = TowerType.ELECTRIC;
	}

}
