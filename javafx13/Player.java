package javafx13;

public class Player{
	private int gold, health, score;
	
	Player(){};
	
	public Player(int gold, int health, int score) {
		this.gold = gold;
		this.health = health;
		this.score = score;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
