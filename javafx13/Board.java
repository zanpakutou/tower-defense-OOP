package javafx13;

import javafx13.entities.tiles.Tile;
import javafx13.filehandle.FileMap;

public class Board {
	public int width, heigh;
	public Tile start ;
	public Tile end ;
	public int[][] grid;
	public void setBoard(FileMap fm) {

		this.width = fm.getWidth();
		this.heigh = fm.getHeigh();
		this.start = fm.getStart();
		this.end   = fm.getEnd();
		
		
		grid = new int[this.heigh][this.width];
		
		
		for(int i = 0; i < this.heigh; i++)
			for(int j = 0; j < this.width; j++) {
				grid[i][j] = fm.getGrid(i, j);
				//System.out.println(i + " " + j + " " + grid[i][j]);
			}
		//System.out.println(1);	
	}
}
