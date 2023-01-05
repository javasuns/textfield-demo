module javasuns.demo {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens javasuns.demo.application to javafx.graphics, javafx.fxml;
	opens javasuns.demo.controller to javafx.fxml;
}
