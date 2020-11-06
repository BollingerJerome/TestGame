package application;

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


public class Main extends Application {

	static int Zug;
	
	public void update(boolean moved, Gamefield field, PlayerCursor pc, Label zugLabel, Label coordinate) {
		if(moved) {
			Zug++;
		}
		
		coordinate.setText("X: " + Double.toString(pc.getX()) + "\tY: " + Double.toString(pc.getY()));
		zugLabel.setText("Zug Nr." + Integer.toString(Zug));
		field.drawTiles();
		pc.draw();
	}
	


	@Override
	public void start(Stage primaryStage) {

		Label zugLabel = new Label();
		Label coordinate = new Label();
		Label energy = new Label("Energy: 200");
		Label metal = new Label("Metal: 50");
		Label H2O2 = new Label("H2O2: 0");
		Label Hoelit = new Label("Hoelit: 0");
		

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
					update(pc.machine(), gamefield, pc, zugLabel, coordinate);
					
				}

			System.out.println("Taste getdrückt " + keyEvent.getCode());
			keyEvent.consume();
			
			}
	};

	pc.draw();
	
	GridPane gridPane = new GridPane();
	gridPane.add(energy, 0, 0);
	gridPane.add(metal,0, 1);
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
