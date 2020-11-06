package application;

public class GameRessourcen {

	
	
	public GameRessourcen(String name, int amount) {
		this.name = name;
		this.amount = amount;
	}
	
	private String name;
	private int amount;
	
	public void energy() {
		add(10*SolarPanel.getWorking());
	}
	
	public void metal(GameRessourcen en) {
		for(int i = 0; i<MetalDrill.getWorking(); i++) {
			if(en.remove(15)) {
				add(10);
			}
			else {
				break;
			}
		}
	}
	
	public void add(int amount) {
		this.amount += amount;
	}
	
	public boolean remove(int amount) {
		if(this.amount-amount < 0) {
			System.out.println("Not enough material");
			return false;
		}
		else {
			this.amount -= amount;
			return true;
		}
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
