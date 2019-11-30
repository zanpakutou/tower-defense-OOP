package javafx13.entities;

import java.util.ArrayList;

import javafx13.Board;
import javafx13.entities.basic.Direction;

public class Path{
	private ArrayList< Direction > next_direction;
    private Board b, dir;
	
	public void setBoard(Board b) {
		this.b = b;
		dir.grid = new int[b.heigh][b.width];
	}
	private boolean isValid(int x, int y) {
		return (0 <= x && x < b.heigh && 0 <= y && y < b.width);

	}
	
	public Path(){
		next_direction = new ArrayList< Direction >();
		dir = new Board();
	}
	public int direct(int i, int j) {
		return dir.grid[i][j];
	}
	public void calculatePath() {
		next_direction.clear();
		int px = b.start.getPosX(), py = b.start.getPosY();
		Direction lastMove = null;
	//	System.out.println(1);
		while(isValid(px, py)) {
			
			if (isValid(px+ 1, py) && b.grid[px + 1][py] == 1 && lastMove != Direction.RIGHT) {
				next_direction.add(Direction.LEFT);
				dir.grid[px][py] = 1;
				px = px + 1;
				lastMove = Direction.LEFT;
				continue;
			}
			if (isValid(px - 1, py) && b.grid[px - 1][py] == 1 && lastMove != Direction.LEFT) {
				next_direction.add(Direction.RIGHT);
				dir.grid[px][py] = 2;
				px = px - 1;
				lastMove = Direction.RIGHT;
				continue;
			}
			if (isValid(px, py + 1) && b.grid[px][py + 1] == 1 && lastMove != Direction.UP) {
				
				next_direction.add(Direction.DOWN);
				dir.grid[px][py] = 3;
				py = py + 1;	
				lastMove = Direction.DOWN;	
				continue;
			}
			if (isValid(px, py - 1) && b.grid[px][py - 1] == 1 && lastMove != Direction.DOWN) {
				next_direction.add(Direction.UP);
				dir.grid[px][py] = 4;
				py = py - 1;
				lastMove = Direction.UP;
				continue;
			}
			
			break;
		}
	}
}
