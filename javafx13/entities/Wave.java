package javafx13.entities;

import java.util.ArrayList;
import java.util.List;

import javafx13.entities.abstracts.*;

public class Wave {
	private List<AbstractEnemy> enemy_list;
	private int number_enemies;
	
	public Wave() {
		enemy_list = new ArrayList<AbstractEnemy>();
		number_enemies = 0;
	}
	public Wave(List<AbstractEnemy> enemy_list) {
		this.enemy_list = enemy_list;
		this.number_enemies = this.enemy_list.size();
	}
	public void addEnemy(AbstractEnemy e) {
		this.enemy_list.add(e);
		this.number_enemies++;
	}
	public List<AbstractEnemy> getEnemy_list() {
		return enemy_list;
	}
	public void setEnemy_list(List<AbstractEnemy> enemy_list) {
		this.enemy_list = enemy_list;
	}
	public int getNumber_enemies() {
		return number_enemies;
	}
	public void setNumber_enemies(int number_enemies) {
		this.number_enemies = number_enemies;
	}
	
	
}
