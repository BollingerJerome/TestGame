package application;

import java.util.Vector;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

//üben des dev to master merge

public class Main extends Application {
	

	
	GameRessourcen energy = new GameRessourcen("Energy", 50);
	GameRessourcen metal = new GameRessourcen("Metal", 500);
	Vector <SolarPanel> solars = new Vector <SolarPanel> () ;
	Label zugLabel = new Label();
	Label coordinate = new Label();
	Label energyLabel = new Label(energy.getName() + ": " + energy.getAmount());
	Label metalLabel = new Label(metal.getName() + ": " + metal.getAmount());
	Label H2O2 = new Label("H2O2: 0");
	Label Hoelit = new Label("Hoelit: 0");
	
	static int Zug;
	
	public void update(boolean moved, Gamefield field, PlayerCursor pc, Label zugLabel, Label coordinate) {
		if(moved) {
			Zug++;
		
		energy.produce();
		energyLabel.setText(energy.getName() + ": " + energy.getAmount());
		metalLabel.setText(metal.getName() + ": " + metal.getAmount());
		coordinate.setText("X: " + Double.toString(pc.getX()) + "\tY: " + Double.toString(pc.getY()));
		zugLabel.setText("Zug Nr." + Integer.toString(Zug));
		field.drawTiles();
		pc.draw();
		}
		
	
	}
	


	@Override
	public void start(Stage primaryStage) {



		Canvas canvasField = new Canvas(600,600);
		GraphicsContext gc = canvasField.getGraphicsContext2D();

		Gamefield gamefield = new Gamefield(20, 20, 400, 400, gc);
		gamefield.drawTiles();

		PlayerCursor pc = new PlayerCursor(gc, gamefield);

		final EventHandler<KeyEvent> keyEvent = new EventHandler<KeyEvent>() {
			public void handle(final KeyEvent keyEvent) {
				String keyPressed = keyEvent.getCode().toString();

				switch(keyPressed) {
				case ("RIGHT"):
					
					update(pc.right(), gamefield, pc, zugLabel, coordinate);
				break;
				case("LEFT"):
					
					update(pc.left(), gamefield, pc, zugLabel, coordinate);
				break;
				case ("UP"):
					
					update(pc.up(), gamefield, pc, zugLabel, coordinate);
				break;
				case ("DOWN"):
					
					update(pc.down(), gamefield, pc, zugLabel, coordinate);
				break;
				case ("ENTER"):
					if( gamefield.getField()[(int) pc.getX()][(int) pc.getY()] != 4) {
						if(metal.remove(SolarPanel.getCost())) {
							solars.add(new SolarPanel(pc.getX(), pc.getY(), gc, gamefield, metal, energy));
							update(true, gamefield, pc, zugLabel, coordinate);
							System.out.println("solarpanel placed?");
						}
					}
				break;
					
				}

			System.out.println("Taste getdrückt " + keyEvent.getCode());
			keyEvent.consume();
			
			}
	};

	pc.draw();
	
	GridPane gridPane = new GridPane();
	gridPane.add(energyLabel, 0, 0);
	gridPane.add(metalLabel,0, 1);
	gridPane.add(H2O2, 0, 2);
	gridPane.add(Hoelit, 0, 3);
	BorderPane root = new BorderPane();
	root.setTop(zugLabel);
	root.setLeft(gridPane);
	root.setBottom(coordinate);
	root.setCenter(canvasField);
	primaryStage.setScene(new Scene(new Pane(root)));
	primaryStage.setTitle("Playground");
	primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent);
	primaryStage.show();



}








public static void main(String[] args) {
	launch(args);
}
}
