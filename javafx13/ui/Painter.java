package javafx13.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx13.Board;
import javafx13.Player;
import javafx13.entities.TowerList;
import javafx13.entities.Wave;
import javafx13.entities.abstracts.AbstractEnemy;
import javafx13.entities.abstracts.AbstractProjectile;
import javafx13.entities.abstracts.AbstractTower;
import javafx13.entities.enemy.CharacterType;
import javafx13.entities.tower.TowerType;
import javafx13.entities.projectile.ProjectileType;

public class Painter {
	//final private int SCREEN_WIDTH = 640;
	//final private int SCREEN_LENGTH = 960;
	public static boolean equals(double a, double b){
	    return a == b ? true : Math.abs(a - b) < 0.1;
	}
	public void paintTiles(GraphicsContext gc, Board b) throws FileNotFoundException {
		Image flower = new Image(new FileInputStream("src\\assets\\ground\\flower.png"));
    	Image path_tile = new Image(new FileInputStream("src\\assets\\ground\\path.png"));
    	Image base_tile = new Image(new FileInputStream("src\\assets\\ground\\base.png"));
		for(int i = 0; i < b.heigh; i++)
    		for(int j = 0; j < b.width; j++) {
    			if (b.grid[i][j] == 1) gc.drawImage(path_tile, 32 * j, 32 * i, 32, 32);
    			if (b.grid[i][j] <= 0) gc.drawImage(flower,0, 0, 31, 31, 32 * j, 32 * i, 32, 32);
    			if (b.grid[i][j] == 3) gc.drawImage(flower, i % 5 * 32, (j % 2 + 2)*32, 31, 31, 32 * j, 32 * i, 32, 32);
    		}
		gc.drawImage(base_tile, 32*4, 0, 32, 32, b.end.getPosY() * 32, b.end.getPosX() * 32, 32,32);
	}
	public void paintEnemies(GraphicsContext gc, Wave w, long time) throws FileNotFoundException {
		Image bat_image = new Image(new FileInputStream("src\\assets\\enemies\\chick.png"));
		int frame = (int)((time / 100000000) % 3);
		for(AbstractEnemy e : w.getEnemy_list()) {
			if (e.isKilled() == true) continue;
			if (e.getPosition().getX() < 0 || e.getPosition().getY() < 0) continue; 
			double angle = e.getAngle();
			int x = frame * 48, y = 0;
			if (equals(angle, -Math.PI/2)) y = 3;
			if (equals(angle, Math.PI/2)) y = 0;
			if (equals(angle, Math.PI)) y = 1;
			if (equals(angle, 0)) y = 2;
			y *= 48;
			if (e.getType() == CharacterType.GREEN)
				x+= 48*3;
			if (e.getType() == CharacterType.BLACK)
				x+= 48*6;
			if (e.getType() == CharacterType.BROWN)
				x+= 48*9;
			gc.drawImage(bat_image, x , y, 48, 48, e.getPosition().getX(), e.getPosition().getY(), 32, 32);
			gc.setFill(Color.AQUAMARINE);
			if (e.getType() == CharacterType.BLACK)
				gc.setFill(Color.DARKBLUE);
			gc.fillRect(e.getPosition().getX() - 6, e.getPosition().getY() - 3, e.getHp(), 3);
		}
	}
	public void paintTower(GraphicsContext gc, TowerList towers) throws FileNotFoundException {
		for(AbstractTower t : towers.getTower_list()) {
			if (t.is_removed()) continue;
			Image tower_image  = null;
			if (t.getType() == TowerType.FIRE) tower_image = new Image(new FileInputStream("src\\assets\\towers\\tower_fireball.png"));
			if (t.getType() == TowerType.PEANUT) tower_image = new Image(new FileInputStream("src\\assets\\towers\\tower_peanut.png"));
			if (t.getType() == TowerType.ELECTRIC) tower_image = new Image(new FileInputStream("src\\assets\\towers\\tower_sniper.png"));
			gc.drawImage(tower_image, 0, 48 * (t.getLevel() - 1), 32, 48, t.getPosition().getX(), t.getPosition().getY(), 32, 32);
		}
	}
	public void paintProjectile(GraphicsContext gc, ArrayList<AbstractProjectile> projectiles, long time) throws FileNotFoundException {
		Image peanut_image = new Image(new FileInputStream("src\\assets\\projectile\\peanut.png"));
		Image fire_image = new Image(new FileInputStream("src\\assets\\projectile\\fireball.png"));
		Image electric_image = new Image(new FileInputStream("src\\assets\\projectile\\heart.png"));
		int frame = (int)((time / 50000000) % 6);
		for(AbstractProjectile pt : projectiles) {
			if (pt.is_removed()) continue;
			if (pt.getType() == ProjectileType.PEANUT)
				gc.drawImage(peanut_image, frame * 32, 0, 32, 32, pt.getPosition().getX(), pt.getPosition().getY(), 24, 24);
			if (pt.getType() == ProjectileType.FIRE)
				gc.drawImage(fire_image, frame * 16, 0, 16, 16, pt.getPosition().getX(), pt.getPosition().getY(), 12, 12);
			if (pt.getType() == ProjectileType.ELECTRIC) {
				int new_frame = (int)((time / 180000000) % 32);
				int x = new_frame % 8, y = new_frame/8;
				gc.drawImage(electric_image, x * 32, y * 32, 32, 32, pt.getPosition().getX(), pt.getPosition().getY(), 32, 32);
			}
		}
	}
	public void paintPlayerInfo(GraphicsContext gc, Player p) {

		gc.strokeText("Gold: " + p.getGold(), 48, 24);
		gc.strokeText("Health: " + p.getHealth(), 200, 24);
		gc.strokeText("Score: " + p.getScore(), 300, 24);
	}
}
