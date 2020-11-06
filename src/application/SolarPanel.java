package application;

import javafx.scene.canvas.GraphicsContext;

public class SolarPanel extends Tile {

	public SolarPanel(double positionX, double positionY, GraphicsContext gc, Gamefield gf,
			GameRessourcen construction, GameRessourcen product) {
		super(positionX, positionY, 20, gc, gf);
		this.construction = construction;
		this.product = product;
		this.active = true;
		this.health = 200;
		this.working++;
		
		construction.remove(100);
		int[][] field = getGameField().getField();
		field[(int) positionX][(int) positionY] = 20;
		getGameField().setField(field);
		getGameField().addTilesObject();
		System.out.println("Solarpanel created");
	}

	private GameRessourcen construction;
	private GameRessourcen product;
	private boolean active;
	private int health;
	private static int working;
	

	
	

	public GameRessourcen getConstruction() {
		return construction;
	}

	public void setConstruction(GameRessourcen construction) {
		this.construction = construction;
	}

	public GameRessourcen getProduct() {
		return product;
	}

	public void setProduct(GameRessourcen product) {
		this.product = product;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public static int getWorking() {
		return working;
	}

	public static void setWorking(int working) {
		SolarPanel.working = working;
	}
	
	
}
