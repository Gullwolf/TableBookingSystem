package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class loginScreen {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private AnchorPane rootPane;

    public void onLoginButtonClick(ActionEvent actionEvent) throws IOException {
        String username = "";
        String password = "";

        System.out.println(username);
        System.out.println(password);

        System.out.println(usernameTextField.getText());
        System.out.println(passwordField.getText());

        username = usernameTextField.getText();
        password = passwordField.getText();

        System.out.println(username);
        System.out.println(password);

        if ((username.equals("")) || (password.equals(""))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Username or Password Error");
            alert.setContentText("Please enter both a Username and a Password");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        } else {
            try {
                FileWriter myWriter = new FileWriter("loginDetails.txt");
                myWriter.write(username + "\n");
                myWriter.write(password);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

                UserHolder userHolder = UserHolder.getInstance();
                userHolder.setUser(usernameTextField.getText());
                System.out.println(userHolder.getUser());

                AnchorPane pane = FXMLLoader.load(getClass().getResource("bookingHomepage.fxml"));
                rootPane.getChildren().setAll(pane);

                System.out.println("Logged in.");

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }

    }
}
