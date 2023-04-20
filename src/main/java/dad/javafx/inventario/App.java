package dad.javafx.inventario;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	private Controller control;

	@Override
	public void start(Stage primaryStage) throws Exception {
		control=new Controller();
		
		primaryStage.setTitle("Inventario");
		
		primaryStage.setScene(new Scene(control.getGridpan()));
	
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}