package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class BookingHomepage {

    @FXML
    private javafx.scene.control.Button oneDiner;

    @FXML
    private javafx.scene.control.Button twoDiners;

    @FXML
    private AnchorPane rootPane;

    /**
     * Logs the user out and takes them back to the Login page.
     * @param actionEvent
     * @throws IOException
     */
    public void onLogoutButtonClick(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Logged out.");

    }

    /**
     * One person dining button.
     * @param actionEvent
     * @throws IOException
     */
    public void onDinerButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(oneDiner.getText()));
        System.out.println(Integer.parseInt(oneDiner.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected one diner.");

    }

    /**
     * Two people dining button.
     * @param actionEvent
     * @throws IOException
     */
    public void onTwoDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(twoDiners.getText()));
        System.out.println(Integer.parseInt(twoDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }
}
