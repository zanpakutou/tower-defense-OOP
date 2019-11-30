package javafx13.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx13.Board;
import javafx13.Player;
import javafx13.Setting;
import javafx13.entities.abstracts.AbstractEnemy;
import javafx13.entities.abstracts.AbstractTower;
import javafx13.entities.basic.Point;
import javafx13.entities.tower.PeanutTower;
import javafx13.entities.tower.TowerType;
import javafx13.filehandle.FileMap;
import javafx13.filehandle.FileWave;
import javafx13.entities.tower.ElectricTower;
import javafx13.entities.tower.FireTower;

public class InGameMenu {
	private Board b;
	private Timer timer;
	private Player player;
	int ordinary_of_wave = 1;
	
	public void setTimer(Timer timer) { this.timer = timer; }
	public void setPlayer(Player player) { this.player = player; }
	public void serBoard(Board b) { this.b = b; }
	public void setCanvas(Canvas canvas) { };
	public void setGroup(Group root) { }
	
	public InGameMenu(Canvas canvas, Group root) throws FileNotFoundException { 
	 Rectangle2D croppedPortion = new Rectangle2D(0, 0, 32, 48);
	 
	 Image tower = new Image(new FileInputStream("src\\assets\\towers\\tower_peanut.png"));
	 ImageView imageView = new ImageView(tower);
	 imageView.setViewport(croppedPortion);
	 imageView.setFitWidth(32);
	 imageView.setFitHeight(48);
	 Button button1 = new Button("", imageView);
	 
	 tower = new Image(new FileInputStream("src\\assets\\towers\\tower_fireball.png"));
	 imageView = new ImageView(tower);
	 imageView.setViewport(croppedPortion);
	 imageView.setFitWidth(32);
	 imageView.setFitHeight(48);
	 Button button2 = new Button("", imageView);
	 
	 tower = new Image(new FileInputStream("src\\assets\\towers\\tower_sniper.png"));
	 imageView = new ImageView(tower);
	 imageView.setViewport(croppedPortion);
	 imageView.setFitWidth(32);
	 imageView.setFitHeight(48);
	 Button button3 = new Button("", imageView);
	 
	 button2.relocate(0, 56);
	 button1.setOnAction(new EventHandler<ActionEvent>() {
		  public void handle(ActionEvent e) {
			  canvas.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent t) {
					if (t.getEventType() != MouseEvent.MOUSE_PRESSED) return;
					int x = (int)((t.getY())/32),
						y = (int)((t.getX())/32);
					if (b.grid[x][y] == -1 && player.getGold() >= Setting.UPGRADE_TOWER_COST) {
						for(AbstractTower tower : timer.getTowerList().getTower_list()) {
							if (tower.getPosition().getX() == 32 * y && tower.getPosition().getY() == 32 * x) {
								if (tower.getLevel() >= 3) continue;
								if (tower.getType() != TowerType.PEANUT) continue;
								tower.upgrade();
								player.setGold(player.getGold() - Setting.UPGRADE_TOWER_COST);
							}
						}	
					}
					if (b.grid[x][y] == 0 && player.getGold() >= Setting.PEANUT_TOWER_COST) {
						b.grid[x][y] = -1;
						timer.getTowerList().getTower_list().add(new PeanutTower(new Point(32 * y, 32 * x), false) );
						player.setGold(player.getGold() - Setting.PEANUT_TOWER_COST);
					}
					
					
				};
		    });
		  }
	});
	 button2.setOnAction(new EventHandler<ActionEvent>() {
		  public void handle(ActionEvent e) {
			  canvas.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent t) {
					if (t.getEventType() != MouseEvent.MOUSE_PRESSED) return;
					int x = (int)((t.getY())/32),
							y = (int)((t.getX())/32);
					if (b.grid[x][y] == -1 && player.getGold() >= Setting.UPGRADE_TOWER_COST) {
						for(AbstractTower tower : timer.getTowerList().getTower_list()) {
							if (tower.getPosition().getX() == 32 * y && tower.getPosition().getY() == 32 * x) {
								if (tower.getLevel() >= 3) continue;
								if (tower.getType() != TowerType.FIRE) continue;
								tower.upgrade();
								player.setGold(player.getGold() - Setting.UPGRADE_TOWER_COST);
							}
						}	
					}
						if (b.grid[x][y] == 0 && player.getGold() >= Setting.FIRE_TOWER_COST) {
							b.grid[x][y] = -1;
							timer.getTowerList().getTower_list().add(new FireTower(new Point(32 * y, 32 * x), false) );
							player.setGold(player.getGold() - Setting.FIRE_TOWER_COST);
						}
						
					
				};
		    });
		  }
	});
	 
	 button3.relocate(0, 112);
	 button3.setOnAction(new EventHandler<ActionEvent>() {
		  public void handle(ActionEvent e) {
			  canvas.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent t) {
					if (t.getEventType() != MouseEvent.MOUSE_PRESSED) return;
					int x = (int)((t.getY())/32),
							y = (int)((t.getX())/32);
					if (b.grid[x][y] == -1 && player.getGold() >= Setting.UPGRADE_TOWER_COST) {
						for(AbstractTower tower : timer.getTowerList().getTower_list()) {
							if (tower.getPosition().getX() == 32 * y && tower.getPosition().getY() == 32 * x) {
								if (tower.getLevel() >= 3) continue;
								if (tower.getType() != TowerType.ELECTRIC) continue;
								tower.upgrade();
								player.setGold(player.getGold() - Setting.UPGRADE_TOWER_COST);
							}
						}	
					}
						if (b.grid[x][y] == 0 && player.getGold() >= Setting.ELECTRIC_TOWER_COST) {
							b.grid[x][y] = -1;
							timer.getTowerList().getTower_list().add(new ElectricTower(new Point(32 * y, 32 * x), false) );
							player.setGold(player.getGold() - Setting.ELECTRIC_TOWER_COST);
						}
				};
		    });
		  }
	});
	 
	 Image next_button = new Image(new FileInputStream("src\\assets\\button\\next_button.png"));
	 imageView = new ImageView(next_button);
	 imageView.setFitWidth(32);
	 imageView.setFitHeight(32);
	 Button next_button_ = new Button("", imageView);
	 next_button_.relocate(0, 168);
	 
	 next_button_.setOnMousePressed(e -> {
			// TODO show a menu of several choices of background music
		  FileWave filewave = new FileWave("src\\data\\wave\\wave" + Setting.stage  + ".txt");
		  
		try {
			if (ordinary_of_wave <= Setting.NUMBER_OF_WAVES)
				filewave.readWaveToList(timer.getWave(), ordinary_of_wave, timer.getBoard().start.getPosY(), timer.getBoard().start.getPosX());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ordinary_of_wave = ordinary_of_wave + 1;
		if (ordinary_of_wave > Setting.NUMBER_OF_WAVES) {
			for(AbstractEnemy e1 : timer.getWave().getEnemy_list()) {
				if (e1.isKilled() == false) return;
			}
				
			Setting.stage++;
			FileMap fm = new FileMap();
			try {
				fm.readMap(Setting.stage);
				timer.getBoard().setBoard(fm);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			player.setGold(Setting.PLAYER_INIT_GOLD * Setting.stage);
			player.setHealth(Setting.PLAYER_INIT_HEALTH);
			ordinary_of_wave = 1;
			timer.getTowerList().getTower_list().clear();
		} 
		});
	 
	 Image auto = new Image(new FileInputStream("src\\assets\\button\\auto.png"));
	 imageView = new ImageView(auto);
	 imageView.setFitWidth(32);
	 imageView.setFitHeight(32);
	 Button auto_button = new Button("", imageView);
	 auto_button.relocate(0, 168 + 34);
	 
	 auto_button.setOnMousePressed(e -> {
		 double fire_dps = 1.0 * Setting.FIRE_TOWER_DAMAGE * Setting.FIRE_TOWER_AS, 
				peanut_dps = 1.0 * Setting.PEANUT_TOWER_DAMAGE * Setting.PEANUT_TOWER_AS, 
				electric_dps = 1.0 * Setting.ELECTRIC_TOWER_DAMAGE * Setting.ELECTRIC_TOWER_AS;
		 if (player.getGold() < Setting.FIRE_TOWER_COST) fire_dps = 0;
		 if (player.getGold() < Setting.PEANUT_TOWER_COST) peanut_dps = 0;
		 if (player.getGold() < Setting.ELECTRIC_TOWER_COST) electric_dps = 0;
		 int type = 1, _i = -1, _j = -1;
		 double current_f = 0;
		 for(int i = 0; i < b.heigh; i++)
			 for(int j = 0; j < b.width; j++) {
				 if (b.grid[i][j] !=0 ) continue;
				 Point p = new Point(i * 32, j * 32), q;
				 int reached_fire = 0, reached_pea = 0, reached_elec = 0;
				 for(int i1 = 0; i1 < b.heigh; i1++)
					 for(int j1 = 0; j1 < b.width; j1++) {
						 if (b.grid[i1][j1] != 1) continue;
						 q = new Point(i1 * 32, j1 * 32);
						 double distance =  Math.sqrt((q.getX() - p.getX()) * (q.getX() - p.getX())
									+	(q.getY() - p.getY()) * ((q.getY() - p.getY())));
						 if (distance <= Setting.FIRE_TOWER_RANGE) reached_fire++;
						 if (distance <= Setting.PEANUT_TOWER_RANGE) reached_pea++;
						 if (distance <= Setting.ELECTRIC_TOWER_RANGE) reached_elec++;
					 }
				 if (reached_fire * fire_dps > current_f) { 
					 current_f = reached_fire * fire_dps;
					 type = 1;
					 _i = i;
					 _j = j;
				 }
				 if (reached_pea * peanut_dps > current_f) { 
					 current_f = reached_pea * peanut_dps;
					 type = 2;
					 _i = i;
					 _j = j;
				 }
				 if (reached_elec * electric_dps > current_f) { 
					 current_f = reached_elec * electric_dps;
					 type = 3;
					 _i = i;
					 _j = j;
				 }
			 }
		 if (current_f <= 0) return;
		 if (type == 1) {
			 timer.getTowerList().getTower_list().add(new FireTower(new Point(_j * 32, _i * 32), false));
			 player.setGold(player.getGold() - Setting.FIRE_TOWER_COST);
			 b.grid[_i][_j] = -1;
		 }
		 if (type == 2) {
			 timer.getTowerList().getTower_list().add(new PeanutTower(new Point(_j * 32, _i * 32), false));
			 player.setGold(player.getGold() - Setting.PEANUT_TOWER_COST);
			 b.grid[_i][_j] = -1;
		 }
		 if (type == 3) {
			 timer.getTowerList().getTower_list().add(new ElectricTower(new Point(_j * 32, _i * 32), false));
			 player.setGold(player.getGold() - Setting.ELECTRIC_TOWER_COST);
			 b.grid[_i][_j] = -1;
		 }
	 });
	 
	 root.getChildren().add(button1);
	 root.getChildren().add(button2);
	 root.getChildren().add(button3);
	 root.getChildren().add(next_button_);
	 root.getChildren().add(auto_button);
	}
	
	
}
