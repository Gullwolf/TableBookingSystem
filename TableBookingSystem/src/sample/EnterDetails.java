package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.FileWriter;
import java.io.IOException;

public class EnterDetails {

    @FXML
    private javafx.scene.control.TextField titleTextField;

    @FXML
    private javafx.scene.control.TextField firstNameTextField;

    @FXML
    private javafx.scene.control.TextField lastNameTextField;

    @FXML
    private javafx.scene.control.TextField phoneNumberTextField;

    @FXML
    private AnchorPane rootPane;

    public void onBookButtonClick(ActionEvent actionEvent) throws IOException {
        if ((titleTextField.getText().equals("")) || (firstNameTextField.getText().equals("")) || (lastNameTextField.getText().equals("")) || (phoneNumberTextField.getText().equals(""))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Data Missing");
            alert.setContentText("Please fill in the required categories.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        } else {
            try {
                FileWriter myWriter = new FileWriter("BookingSlip.txt");
                myWriter.write(titleTextField.getText() + " " + firstNameTextField.getText() + " " + lastNameTextField.getText() + "\n");
                myWriter.write(phoneNumberTextField.getText() + "\n");

                DinerHolder numberOfDiners = DinerHolder.getInstance();

                int numberDinersInt = numberOfDiners.getNumberOfDiners();

                System.out.println(numberDinersInt);

                myWriter.write(Integer.toString(numberDinersInt));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

                AnchorPane pane = FXMLLoader.load(getClass().getResource("bookingHomepage.fxml"));
                rootPane.getChildren().setAll(pane);

                System.out.println("Booking made");

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
}
