package javasuns.demo.application.paneltracker.comps;


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLPane<T> {

	private Pane pane;
	private T paneController;

	public FXMLPane(String url, boolean visible) throws IOException {
		long startTime = System.currentTimeMillis();

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(url));

		pane = fxmlLoader.load();
		paneController = fxmlLoader.<T> getController();

		AnchorPane.setTopAnchor(pane, 0.0);
		AnchorPane.setBottomAnchor(pane, 0.0);
		AnchorPane.setLeftAnchor(pane, 0.0);
		AnchorPane.setRightAnchor(pane, 0.0);

		pane.setVisible(visible);
		fxmlLoader = null;

		double time = (System.currentTimeMillis() - startTime);
		if(time > 15)
			System.out.println(Thread.currentThread() + " =======> Loaded " + paneController + " in " + time + "ms");
	}

	public FXMLPane(String url) throws IOException {
		this(url, true);
	}

	public Pane getPane() {
		return pane;
	}

	public T getController() {
		return paneController;
	}

	public String toString() {
		return this.getController().getClass().toString();
	}
}
