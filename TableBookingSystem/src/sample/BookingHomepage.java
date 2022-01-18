package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BookingHomepage {

    @FXML
    private AnchorPane rootPane;

    public void onLogoutButtonClick(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Logged out.");

    }
}
