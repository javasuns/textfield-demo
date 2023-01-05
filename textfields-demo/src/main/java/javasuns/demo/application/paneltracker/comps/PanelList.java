package javasuns.demo.application.paneltracker.comps;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.layout.Pane;
import tools.fxml.interfaces.Controller;

public class PanelList {

	HashMap<PaneFXML, FXMLPane<Controller>> panes = new HashMap<>();

	private FXMLPane<Controller> initPane(PaneFXML paneFXML) {
		try {
			FXMLPane<Controller> fxmlP = new FXMLPane<>(paneFXML.url);
			panes.put(paneFXML, fxmlP);
			
			
			return fxmlP;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	} // initPane()

	public synchronized Pane getPane(PaneFXML id) {
		return getFXMLPane(id).getPane();
	} // getPane()
	
	private synchronized FXMLPane<Controller> getFXMLPane(PaneFXML id) {
		FXMLPane<Controller> fxmlPane = panes.get(id);
		if(fxmlPane == null )
			fxmlPane = initPane(id);

		return fxmlPane;
	}

	@SuppressWarnings("unchecked")
	public <T> T getController(PaneFXML id) {
		return (T) getFXMLPane(id).getController();
	} // getController()	
	
	@SuppressWarnings("unchecked")
	public <T> T getController(Pane pane) {
		T paneController = null;
		for(Map.Entry<PaneFXML,FXMLPane<Controller>> e : panes.entrySet()){
	        if(e.getValue().getPane().equals(pane))
	        	paneController = (T) e.getValue().getController();
	    }
			
		return paneController;
	}
	

} // class PanelList
