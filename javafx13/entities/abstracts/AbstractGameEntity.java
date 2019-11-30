package javafx13.entities.abstracts;

import javafx13.entities.basic.Point;

abstract public class AbstractGameEntity implements GameEntity{
	private Point position;
	protected boolean is_removed;
	
	
	public AbstractGameEntity(Point position, boolean is_removed) {
		this.position = position;
		this.is_removed = is_removed;
	}
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	
	public boolean is_removed() {
		return is_removed;
	}
	public void set_removed(boolean is_removed) {
		this.is_removed = is_removed;
	}

	@Override
	public void setPosition(double x, double y) {
		// TODO Auto-generated method stub
		this.position.setX(x);
		this.position.setY(y);
	}
}
