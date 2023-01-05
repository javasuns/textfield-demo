package javasuns.demo.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javasuns.demo.application.paneltracker.PanelTracker;
import javasuns.demo.application.paneltracker.comps.PaneFXML;

public class Main2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			PanelTracker.init(root);
			root.setCenter(PanelTracker.getTracker().getPane(PaneFXML.SEARCH_FIELDS));
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
