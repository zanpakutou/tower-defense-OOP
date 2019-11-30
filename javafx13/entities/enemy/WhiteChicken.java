package javafx13.entities.enemy;

import javafx13.Setting;
//import javafx13.Board;
import javafx13.entities.abstracts.AbstractEnemy;
import javafx13.entities.basic.Point;

public class WhiteChicken extends AbstractEnemy{

	public WhiteChicken(Point position, boolean is_removed) {
		super(position, is_removed, Setting.WHITE_CHICK_SPEED, Setting.ENEMY_HEALTH_POINT, Setting.WHITE_CHICK_DEFENSE);
		// TODO Auto-generated constructor stub
		this.type = CharacterType.WHITE;
		this.setAngle(0);
	}
	

}
