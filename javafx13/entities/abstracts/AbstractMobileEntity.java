package javafx13.entities.abstracts;

import javafx13.entities.basic.Point;

abstract public class AbstractMobileEntity extends AbstractGameEntity{

	private double speed;
	private double angle;

	public AbstractMobileEntity(Point position, boolean is_removed,double speed) {
		super(position, is_removed);
		// TODO Auto-generated constructor stub
		this.speed = speed;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public void move() {
		Point p = this.getPosition();
		double X = p.getX() + Math.cos(angle) * speed;
		double Y = p.getY() + Math.sin(angle) * speed;
		p.setX(X);
		p.setY(Y);
	}
}
