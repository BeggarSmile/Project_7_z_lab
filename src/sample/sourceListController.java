package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class sourceListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    void loadRootPage(ActionEvent event) throws IOException {
        Parent about_grad_page = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene about_grad_scene = new Scene(about_grad_page);
        Stage about_grad_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        about_grad_stage.setScene(about_grad_scene);
        about_grad_stage.show();
    }

    @FXML
    void initialize() {
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file 'sourceList.fxml'.";

    }
}

