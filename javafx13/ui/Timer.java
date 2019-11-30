package javafx13.ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx13.Board;
import javafx13.Player;
import javafx13.Setting;
import javafx13.entities.Path;
import javafx13.entities.TowerList;
import javafx13.entities.Wave;
import javafx13.entities.abstracts.AbstractEnemy;
import javafx13.entities.abstracts.AbstractProjectile;
import javafx13.entities.abstracts.AbstractTower;
import javafx13.entities.enemy.CharacterType;
import javafx13.entities.projectile.ProjectileType;
import javafx13.entities.tower.TowerType;

public class Timer extends AnimationTimer{
	
	private Wave w;
	private Board b;
	private Path p;
	private Player player;
	private TowerList towers;
	private GraphicsContext gc;
	private ArrayList<AbstractProjectile> projectiles = new ArrayList<AbstractProjectile>();
	int framecount = 0;

	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setB(Board b) {
		this.b = b;
	}
	public Board getBoard() {
		return b;
	}
	public void setW(Wave w) {
		this.w = w;
	}
	public Wave getWave() {
		return w;
	}
	public void setP(Path p) {
		this.p = p;
	}
	public void setTowerList(TowerList t) {
		towers = t;
	}
	public TowerList getTowerList() {
		return this.towers;
	}
	@Override
	public void handle(long now) {
		// TODO Auto-generated method stub
			p.calculatePath();
			Painter p = new Painter();
	    	try {
				p.paintTiles(gc, b);
		    	p.paintEnemies(gc, w, now);
		    	p.paintTower(gc, towers);
		    	p.paintProjectile(gc, projectiles, now);
		    	p.paintPlayerInfo(gc, player);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	    	move(w, now);
	}
	
	
	void move(Wave w, long now) {
		for(AbstractEnemy e : w.getEnemy_list()) {
			int x = (int)((e.getPosition().getY())/32),
				y = (int)((e.getPosition().getX())/32);
			
			if (e.isKilled()) continue;
			
			if (Math.abs(x*32 - e.getPosition().getY()) < e.getSpeed() 
				&& Math.abs(y*32 - e.getPosition().getX()) < e.getSpeed()
				&& x >= 0 && y >= 0) {
			
				if (p.direct(x, y) == 2) e.setAngle(-Math.PI/2);
				if (p.direct(x, y) == 1) e.setAngle(Math.PI/2);
				if (p.direct(x, y) == 4) e.setAngle(Math.PI);
				if (p.direct(x, y) == 3) e.setAngle(0);
				if (x == b.end.getPosX() && y == b.end.getPosY()) {
					player.setHealth(player.getHealth() - e.getHp());
					if (player.getHealth() <= 0) {
						this.stop();
						System.out.println("GAME OVER!");
					}
					e.setHp(-1);
				}
			}
			if (e.isKilled() == false)
				e.move();
		}
		for(AbstractTower tower : towers.getTower_list()) {
			AbstractProjectile pt = null;
			if (tower.getType() == TowerType.PEANUT)  pt = tower.shoot(ProjectileType.PEANUT, w, now);
			if (tower.getType() == TowerType.FIRE) pt = tower.shoot(ProjectileType.FIRE, w, now);
			if (tower.getType() == TowerType.ELECTRIC) pt = tower.shoot(ProjectileType.ELECTRIC, w, now);
			if (pt == null) continue;
			projectiles.add(pt);
		}
		for(AbstractProjectile pt: projectiles) {
			if (pt.is_removed()) continue;
			pt.moveToEnemy();
			if (pt.getEnemy().isKilled()) {
				pt.set_removed(true);
				continue;
			}
			if (pt.isReach()) {
				pt.set_removed(true);
				pt.getEnemy().setHp((int)(pt.getEnemy().getHp() - 1.0* pt.getDamage() * (1 - 1.0 * pt.getEnemy().getDefense()/20)));
			}
			if (pt.getEnemy().isKilled()) {
				pt.set_removed(true);
				int bonus  = 0;
				if (pt.getEnemy().getType() == CharacterType.WHITE) bonus = Setting.WHITE_CHICK_GOLD;
				if (pt.getEnemy().getType() == CharacterType.BLACK) bonus = Setting.BLACK_CHICK_GOLD;
				if (pt.getEnemy().getType() == CharacterType.GREEN) bonus = Setting.GREEN_CHICK_GOLD;
				if (pt.getEnemy().getType() == CharacterType.BROWN) bonus = Setting.BROWN_CHICK_GOLD;
				
				player.setGold(player.getGold() + bonus);
				player.setScore(player.getScore() + 1);
			}
		}
	}
}
