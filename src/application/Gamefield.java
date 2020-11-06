package application;


import javafx.scene.canvas.GraphicsContext;

public class Gamefield {
	
	//Dev branch
	//Constructor
	public Gamefield(int[][] field, int vertical, int horizontal, int width, int heigth, GraphicsContext gc) {

		
		this.field = field;
		this.verticalTiles = vertical;
		this.horizontalTiles = horizontal;
		this.windowWidth = width;
		this.windowHeigth = heigth;
		this.gc = gc;
		this.tiles = new Tile[vertical][horizontal];
		
	}
	
	//Constructor with FieldGeneration
	//horizontal isch ahzahl tiles und width isch Pixel
	public Gamefield(int vertical, int horizontal, int width, int heigth, GraphicsContext gc) {

		super();
		this.field = generateField(vertical, horizontal);
		this.verticalTiles = vertical;
		this.horizontalTiles = horizontal;
		this.windowWidth = width;
		this.windowHeigth = heigth;
		this.gc = gc;
		this.tiles = new Tile[vertical][horizontal];
		addTilesObject();

	}

	//privates
	private int[][] field;
	private int verticalTiles, horizontalTiles, windowWidth, windowHeigth;
	private GraphicsContext gc;
	private Tile[][] tiles;
	
	public double verticalScalar() {
		return windowWidth/horizontalTiles; 
	}
	public double horizontalScalar() {
		return windowHeigth/verticalTiles;
	}
	
	//Generate all TileObjects
	public void addTilesObject() {
		for (int i= 0; i<this.horizontalTiles; i++) {
			for (int j = 0; j<this.verticalTiles; j++) {
				tiles[i][j] = new Tile(i, j, field[i][j], gc, this);
			}
		}
	}


	//Draw all Tiles
	public void drawTiles() {
		for (int i= 0; i<horizontalTiles; i++) {
			for (int j = 0; j<verticalTiles; j++) {
				tiles[i][j].draw();
			}
		}
	}
	

	
	//Fieldgeneration
	public int[][] generateField(int w, int h){
		int[][] genField = new int[w][h];
		float water = (float) 3/(h*w);
		for (int i = 0; i<w; i++) {
			for (int j = 0; j<h; j++) {
				double chance = Math.random();
				if(chance <= water) {
					genField[i][j] = 4;
				}
				else {
					genField[i][j] = 3;
				}
			}
		}
		return genField;
	}
	
	public int[][] getField() {
		return field;
	}

	public void setField(int[][] field) {
		this.field = field;
	}

	public int getVerticalTiles() {
		return verticalTiles;
	}

	public void setVerticalTiles(int vertical) {
		this.verticalTiles = vertical;
	}

	public int getHorizontalTiles() {
		return horizontalTiles;
	}

	public void setHorizontalTiles(int horizontal) {
		this.horizontalTiles = horizontal;
	}

	public int getWidth() {
		return windowWidth;
	}

	public void setWidth(int width) {
		this.windowWidth = width;
	}

	public int getHeigth() {
		return windowHeigth;
	}

	public void setHeigth(int heigth) {
		this.windowHeigth = heigth;
	}

	public GraphicsContext getGc() {
		return gc;
	}

	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
}
