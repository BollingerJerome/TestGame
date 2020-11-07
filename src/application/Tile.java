package application;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Tile {
	
	
	public Tile(double positionX, double positionY, 
			int color, GraphicsContext gc, Gamefield gf) {

		this.x = positionX;
		this.y = positionY;
		this.gc = gc;
		this.gameField = gf;
		this.colorInt = color;
		
		switch(color) {
		case(0):
			this.color = Color.GRAY;
		break;
		case(1):
			this.color = Color.RED;
		break;
		case(2):
			this.color = Color.FORESTGREEN;
		break;
		case(3):
			this.color = Color.PERU;
		break;
		
		case(9):
			this.color = Color.BLACK;
		break;
		case(20):
			this.color = Color.BLUE;
		break;
		case(21):
			this.color = Color.DODGERBLUE;
		break;
		case(22):
			this.color = Color.LIGHTSALMON;
		break;
		
		case(23):
			this.color = Color.DARKGOLDENROD;
		break;
		
		}
	}

	private double x, y, width, height;
	private Color color;
	private GraphicsContext gc;
	private Gamefield gameField;
	private int colorInt;
	
	public void draw() {
		gc.setFill(color);
		gc.fillRoundRect(x*gameField.horizontalScalar(), y*gameField.verticalScalar(), gameField.horizontalScalar(), gameField.verticalScalar(), 5, 5);
	}



	public double getX() {
		return x;
	}



	public void setX(double x) {
		this.x = x;
	}



	public double getY() {
		return y;
	}



	public void setY(double y) {
		this.y = y;
	}



	public double getWidth() {
		return width;
	}



	public void setWidth(double width) {
		this.width = width;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}



	public GraphicsContext getGc() {
		return gc;
	}



	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}



	public Gamefield getGameField() {
		return gameField;
	}



	public void setGameField(Gamefield gameField) {
		this.gameField = gameField;
	}



	public int getColorInt() {
		return colorInt;
	}



	public void setColorInt(int colorInt) {
		this.colorInt = colorInt;
	}
	
}
