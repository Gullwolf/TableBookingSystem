package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.io.IOException;

public class BookingHomepage {

    @FXML
    private javafx.scene.control.Button oneDiner;

    @FXML
    private AnchorPane rootPane;

    /**
     * Logs the user out and takes them back to the Login page.
     * @param actionEvent
     * @throws IOException
     */
    public void onLogoutButtonClick(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Logged out.");

    }

    //One person dining button.
    public void onDinerButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(oneDiner.getText()));
        System.out.println(Integer.parseInt(oneDiner.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected one diner.");

    }
}
