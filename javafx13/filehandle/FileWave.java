package javafx13.filehandle;


import java.io.IOException;
import java.io.RandomAccessFile;

import javafx13.entities.Wave;
import javafx13.entities.basic.Point;
import javafx13.entities.enemy.BlackChicken;
import javafx13.entities.enemy.BrownChicken;
import javafx13.entities.enemy.GreenChicken;
import javafx13.entities.enemy.WhiteChicken;

public class FileWave {
	private String loc;
	
	public FileWave(String loc) {
		this.loc = loc;
	}

	public void readWaveToList(Wave w, int ordinary_of_wave,int start_x, int start_y) throws IOException {
		RandomAccessFile file = new RandomAccessFile(this.loc, "r");
		int count = 0;
		String str = null;
		while(count < ordinary_of_wave) {
			count++;
			str = file.readLine();
		}
		for(int i = 0; i < str.length(); i++) {
			int new_x = start_x * 32 - 64 * i;
			int new_y = start_y * 32;
			if (str.charAt(i) == 'W')
				w.addEnemy(new WhiteChicken(new Point(new_x, new_y), false));
			if (str.charAt(i) == 'B')
				w.addEnemy(new BlackChicken(new Point(new_x, new_y), false));
			if (str.charAt(i) == 'G')
				w.addEnemy(new GreenChicken(new Point(new_x, new_y), false));
			if (str.charAt(i) == 'O')
				w.addEnemy(new BrownChicken(new Point(new_x, new_y), false));
		}
		file.close();
	}
}
