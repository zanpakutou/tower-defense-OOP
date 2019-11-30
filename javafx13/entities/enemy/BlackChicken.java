package javafx13.entities.enemy;

import javafx13.Setting;
import javafx13.entities.abstracts.AbstractEnemy;
import javafx13.entities.basic.Point;

public class BlackChicken extends AbstractEnemy {

	private CharacterType type;
	public CharacterType getType() {
		return type;
	}

	public BlackChicken(Point position, boolean is_removed) {
		super(position, is_removed, Setting.BLACK_CHICK_SPEED, Setting.ENEMY_HEALTH_POINT, Setting.BLACK_CHICK_DEFENSE);
		// TODO Auto-generated constructor stub
		this.type = CharacterType.BLACK;
		this.setAngle(0);
	}

}
