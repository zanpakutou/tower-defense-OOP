package javafx13.filehandle;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx13.entities.tiles.Tile;
import javafx13.entities.tiles.TileType;

public class FileMap {
	private int width , heigh;
	private Tile start, end;
	private int[][] grid;
	
	public int getWidth() {
		return width;
	}

	public int getHeigh() {
		return heigh;
	}

	public Tile getStart() {
		return start;
	}

	public Tile getEnd() {
		return end;
	}

	public int getGrid(int i, int j) {
		return grid[i][j];
	}

	public void readMap(int number) throws IOException {
		Scanner scanner = new Scanner(new File("src\\data\\map\\map" + number + ".layout"));
		this.heigh = scanner.nextInt(); this.width = scanner.nextInt(); 
		this.start = new Tile(TileType.START, scanner.nextInt(), scanner.nextInt(), false);
		this.end = new Tile(TileType.END, scanner.nextInt(), scanner.nextInt(), false);
		grid = new int[this.heigh][this.width];
		for(int i = 0 ; i < this.heigh; i++)
			for(int j = 0; j < this.width; j++) {
				grid[i][j] = scanner.nextInt();
				//System.out.println(i + " " + j + " " + grid[i][j]);
			}
		scanner.close();
	}
}
