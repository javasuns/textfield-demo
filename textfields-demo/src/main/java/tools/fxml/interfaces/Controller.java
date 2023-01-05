package tools.fxml.interfaces;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.Region;

public abstract class Controller {

	private FreezeProperty freezeProperty;
	public static final String FREEZE_PROPERTY = "freezeProperty";

	
	public void setFrozen(boolean frozen) {
		if(freezeProperty == null)
			return;
		freezeProperty.set(frozen);
	} // setFrozen()

	public FreezeProperty getFreezeProperty(Parent rootNode) {
		if(freezeProperty == null)
			freezeProperty = new FreezeProperty();
		rootNode.getProperties().put(FREEZE_PROPERTY, freezeProperty);
		return freezeProperty;
	} // getFrozenProperty()






	public static class FreezeProperty {
		ChangeListener changeListener;

		public void set(boolean freeze) {
			changeListener.handle(freeze);
		}

		public void addListener(ChangeListener listener) {
			changeListener = listener;
		};

		public static interface ChangeListener {
			public void handle(boolean freeze);
		}
	}
}

