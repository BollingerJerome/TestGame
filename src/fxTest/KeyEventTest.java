package fxTest;

import application.Gamefield;
import application.PlayerCursor;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class KeyEventTest extends Application{




	@Override
	public void start(Stage primaryStage) {


		Canvas canvasField = new Canvas(600,600);
		GraphicsContext gc = canvasField.getGraphicsContext2D();

		final EventHandler<KeyEvent> keyEvent = new EventHandler<KeyEvent>() {
			public void handle(final KeyEvent keyEvent) {
				System.out.println("Taste getdrückt " + keyEvent.getCode());
				keyEvent.consume();
			}
		};

		primaryStage.setScene(new Scene(new Pane(canvasField)));
		primaryStage.setTitle("EventTesting");
		primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent);
		primaryStage.show();



	}

	public static void main(String[] args) {
		launch(args);
	}

}


