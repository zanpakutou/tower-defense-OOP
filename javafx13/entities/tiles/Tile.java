package javafx13.entities.tiles;

public class Tile {
	private TileType type;
	private int posX, posY;
	private boolean is_occupied;
	
	public Tile() {};
	
	public Tile(TileType type, int posX, int posY, boolean is_occupied) {
		super();
		this.type = type;
		this.posX = posX;
		this.posY = posY;
		this.is_occupied = is_occupied;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public boolean isOccupied() {
		return is_occupied;
	}
	public void setOccupied(boolean is_occupied) {
		this.is_occupied = is_occupied;
	}
	public TileType getType() {
		return type;
	}
	public boolean canAcross() {
		return (this.type != TileType.BLOCK) && (this.type != TileType.GROUND);
	}
}
