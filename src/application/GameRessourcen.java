package application;

public class GameRessourcen {

	
	
	public GameRessourcen(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}
	
	private String name;
	private int amount;
	
	public void produce() {
		add(10*SolarPanel.getWorking());
	}
	
	public void add(int amount) {
		this.amount += amount;
	}
	public void remove(int amount) {
		this.amount -= amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}
