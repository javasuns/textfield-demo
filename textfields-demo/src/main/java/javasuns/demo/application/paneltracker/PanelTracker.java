package javasuns.demo.application.paneltracker;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javasuns.demo.application.paneltracker.comps.PaneFXML;
import javasuns.demo.application.paneltracker.comps.PanelList;
import tools.fxml.interfaces.Controller;

public class PanelTracker {

	private static PanelTracker panelTracker;

	private PanelList panelList;
	private Pane scenePane;
	private Pane activeTab;

	public static PanelTracker init(Pane scenePane) {
		panelTracker = new PanelTracker(scenePane);
		return panelTracker;
	} // init()

	public static PanelTracker getTracker() {
		if (panelTracker == null) {
			System.err.println("PanelTracker not initialized!");
			System.exit(-100);
		} // if
		return panelTracker;
	} // getTracker()

	private PanelTracker(Pane scenePane) {
		this.scenePane = scenePane; // Make sure that root pane is in Anchorpane
		panelList = new PanelList();
	} // Constructor Method

	public Pane getScenePane() {
		return scenePane;
	}

	public Controller getController(Pane p) {
		return panelList.getController(p);
	}

	public Parent getPane(PaneFXML paneFXML) {
		return panelList.getPane(paneFXML);
	} // getPane()

	public Controller getController(PaneFXML paneFXML) {
		return panelList.getController(paneFXML);
	} // getController()
}

