package javafx13.entities;

import java.util.ArrayList;
import java.util.List;
import javafx13.entities.abstracts.AbstractTower;

public class TowerList {
	private List<AbstractTower> tower_list;
	private int number_tower;

	public List<AbstractTower> getTower_list() {
		return tower_list;
	}
	
	public void setTower_list(List<AbstractTower> tower_list) {
		this.tower_list = tower_list;
	}
	public int getNumber_tower() {
		return number_tower;
	}
	public void setNumber_tower(int number_tower) {
		this.number_tower = number_tower;
	}
	public TowerList(){
			tower_list = new ArrayList<AbstractTower>();
			number_tower = 0;
	}
	public TowerList(List<AbstractTower> tower_list) {
		this.tower_list = tower_list;
		this.number_tower = tower_list.size();
	}
	
}
