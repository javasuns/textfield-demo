package javasuns.demo.application.paneltracker.comps;

public enum PaneFXML {
	SEARCH_FIELDS("SearchFields.fxml");

	public final String url;

	private PaneFXML(String url) {
		this.url = mainPath + url;
	}
	private static final String mainPath = "/javasuns/demo/view/";
};
