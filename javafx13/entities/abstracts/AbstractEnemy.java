package javafx13.entities.abstracts;

import javafx13.entities.basic.Point;
import javafx13.entities.enemy.CharacterType;

abstract public class AbstractEnemy extends AbstractMobileEntity{
	private int hp, defense, entry;
	protected CharacterType type;
	public CharacterType getType() {
		return type;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getEntry() {
		return entry;
	}

	public void setEntry(int entry) {
		this.entry = entry;
	}
	
	public boolean isKilled() {
		return (this.hp <= 0);
	}
	public AbstractEnemy(Point position, boolean is_removed, double speed, int hp, int defense) {
		super(position, is_removed, speed);
		this.hp = hp;
		this.defense = defense;
		// TODO Auto-generated constructor stub
	}

}
