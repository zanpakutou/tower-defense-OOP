package javafx13.entities.enemy;

import javafx13.Setting;
import javafx13.entities.abstracts.AbstractEnemy;
import javafx13.entities.basic.Point;

public class BrownChicken extends AbstractEnemy {

	private CharacterType type;
	public CharacterType getType() {
		return type;
	}

	public BrownChicken(Point position, boolean is_removed ) {
		super(position, is_removed, Setting.BROWN_CHICK_SPEED, Setting.ENEMY_HEALTH_POINT, Setting.BROWN_CHICK_DEFENSE);
		// TODO Auto-generated constructor stub
		this.type = CharacterType.BROWN;
		this.setAngle(0);
	}

}
