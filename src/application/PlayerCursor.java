package application;

import javafx.scene.canvas.GraphicsContext;

public class PlayerCursor extends Tile{
	
	public PlayerCursor(GraphicsContext gc,
			Gamefield gf) {
		super(0, 0, 0, gc, gf);
		// TODO Auto-generated constructor stub
	}
	

	public boolean right() {
		if(getX() != getGameField().getHorizontalTiles()-1) {
			setX(getX() + 1);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean left() {
		if(getX() != 0) {
			setX(getX()- 1);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean down() {
		if(getY() != getGameField().getVerticalTiles()-1) {
			setY(getY()+1);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean up() {
		if(getY() != 0) {
			setY(getY() - 1);
			return true;
		}
		else {
			return false;
		}
	}
	
	/*public boolean machine () {
		int[][] colorField = getGameField().getField();
		int posX = (int) getX();
		int posY = (int) getY();
		if(colorField[posX][posY] != 4) {
			colorField[posX][posY] = 9;
			getGameField().setField(colorField);
			getGameField().addTilesObject();			
			System.out.println("Machine set");
			return true;
		}
		else {
			System.out.println("Can't place Machine on WaterBlock");
			return false;
		}
	}*/
	
	
}
