package javafx13.entities.abstracts;

//import javafx13.Board;
import javafx13.entities.basic.Point;

public interface GameEntity {
	
	public void setPosition(Point p);
	public void setPosition(double x, double y);
	public Point getPosition();
	//public void update(Board b);
	
}
