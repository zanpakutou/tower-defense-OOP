package javafx13;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx13.entities.Path;
import javafx13.entities.TowerList;
import javafx13.entities.Wave;
import javafx13.filehandle.FileMap;
import javafx13.ui.InGameMenu;
import javafx13.ui.Timer; 


public class HelloFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	
    	Canvas canvas = new Canvas(960, 640);
    	GraphicsContext gc = canvas.getGraphicsContext2D();
    	Player player = new Player(Setting.PLAYER_INIT_GOLD, Setting.PLAYER_INIT_HEALTH, Setting.PLAYER_INIT_SCORE);

    	FileMap fm = new FileMap();
    	Wave w = new Wave();
    	Path p = new Path();
    	TowerList towers = new TowerList();
    	Board b = new Board();
    	
    	fm.readMap(Setting.stage);
    	b.setBoard(fm);
    	p.setBoard(b);  	
    	
    	Timer run = new Timer();
    	run.setB(b);
    	run.setGc(gc);
    	run.setW(w);
    	run.setP(p);
    	run.setPlayer(player);
    	run.setTowerList(towers);
    	run.start();
    	//--------------------------------------------------------------------------------
    	Group root = new Group();
    	root.getChildren().add(canvas);
       	InGameMenu ccc = new  InGameMenu(canvas, root);
       	
    	ccc.setCanvas(canvas);
    	ccc.setGroup(root);
    	ccc.setTimer(run);
    	ccc.serBoard(b);
    	ccc.setPlayer(player);
    	
    	
    	stage.setScene(
                new Scene(
                		root
                )
            );
    	
        // Set the Title of the Stage
        stage.setTitle("TOWER DEFENSE");
        // Display the Stage
        stage.show();   
    }

    public static void main(String[] args) { launch(args); }
}