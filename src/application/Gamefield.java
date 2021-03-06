package application;


import javafx.scene.canvas.GraphicsContext;

public class Gamefield {
	
	//Dev branch
	//Constructor
	public Gamefield(int[][] field, int horizontal, int vertical,  int width, int heigth, GraphicsContext gc) {

		
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
	public Gamefield(int horizontal, int vertical,  int width, int heigth, GraphicsContext gc) {

		super();
		this.field = generateField(horizontal, vertical);
		this.verticalTiles = vertical;
		this.horizontalTiles = horizontal;
		this.windowWidth = width;
		this.windowHeigth = heigth;
		this.gc = gc;
		this.tiles = new Tile[horizontal][vertical];
		addTilesObject();

	}

	//privates
	private int[][] field;
	private int verticalTiles, horizontalTiles, windowWidth, windowHeigth;
	private GraphicsContext gc;
	private Tile[][] tiles;
	
	public double horizontalScalar() {
		return windowWidth/horizontalTiles; 
	}
	public double verticalScalar() {
		return windowHeigth/verticalTiles;
	}
	
	//Generate all TileObjects
	public void addTilesObject() {
		for (int i= 0; i < horizontalTiles; i++) {
			for (int j = 0; j < verticalTiles; j++) {
				tiles[i][j] = 
						new Tile(i, j, 
						field[i][j], gc, this);
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
	
	//returns the color of the current tile
	public int onTileColor(int x, int y) {
		return field[x][y];
	}

	
	//Fieldgeneration
	public int[][] generateField(int w, int h){
		int[][] genField = new int[w][h];
		float water = (float) 3/(h*w);
		float metal = (float) 3/(h*w);
		for (int i = 0; i<w; i++) {
			for (int j = 0; j<h; j++) {
				double chance = Math.random();
				double metalchance = Math.random();
				if(chance <= water) {
					genField[i][j] = 21;
				}
				else if (metalchance <= metal){
					genField[i][j] = 22;
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
