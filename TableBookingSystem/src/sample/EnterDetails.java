package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

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
        } else if (!phoneNumberTextField.getText().matches("[0-9]+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Wrong Data Type");
            alert.setContentText("Please only put numerical values in the phone number box.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        } else {
//            try {
//                FileWriter myWriter = new FileWriter("BookingSlip.txt");
//                myWriter.write(titleTextField.getText() + " " + firstNameTextField.getText() + " " + lastNameTextField.getText() + "\n");
//                myWriter.write(phoneNumberTextField.getText() + "\n");
//
//                DinerHolder numberOfDiners = DinerHolder.getInstance();
//                int numberDinersInt = numberOfDiners.getNumberOfDiners();
//                System.out.println(numberDinersInt);
//                myWriter.write(numberDinersInt + "\n");
//
//                UserHolder user = UserHolder.getInstance();
//                String userString = user.getUser();
//                System.out.println(userString);
//                myWriter.write("Booked by: " + userString);
//
//                myWriter.close();
//                System.out.println("Successfully wrote to the file.");
//
//                AnchorPane pane = FXMLLoader.load(getClass().getResource("bookingHomepage.fxml"));
//                rootPane.getChildren().setAll(pane);
//
//                System.out.println("Booking made");
//
//            } catch (IOException e) {
//                System.out.println("An error occurred.");
//                e.printStackTrace();
//            }


            DinerHolder numberOfDiners = DinerHolder.getInstance();
            int numberDinersInt = numberOfDiners.getNumberOfDiners();

            DateHolder dateHolder = DateHolder.getInstance();
            String dateOfBooking = dateHolder.getDate();

            //Adding To Database

            //variables
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            //Loading or registering Oracle JDBC driver class
            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            } catch (ClassNotFoundException cnfex) {
                System.out.println("Problem in loading or " + "registering MS Access JDBC driver");
                cnfex.printStackTrace();
            }

            //Opening database connection
            try {
                String msAccDB = "D:/TableBookingSystem/BookingDatabase.accdb";
                String dbURL = "jdbc:ucanaccess://" + msAccDB;

                connection = DriverManager.getConnection(dbURL);

                statement = connection.createStatement();

                String query = "INSERT INTO BookingReservations (Title, FirstName, LastName, PhoneNumber, NumberOfDiners, BookingDate) VALUES ('" + titleTextField.getText() +
                        "', '" + firstNameTextField.getText() +
                        "', '" + lastNameTextField.getText() +
                        "', '" + phoneNumberTextField.getText() +
                        "', '" + numberDinersInt +
                        "', '" + dateOfBooking + "');";
                System.out.println(query);

                statement.executeUpdate(query);
                System.out.println("INSERT Statement run.");

//                resultSet = statement.executeQuery("SELECT * FROM BookingReservations");
//                System.out.println("ID\tTitle\tFirstName\tLastName\tCustomerMessage\tPhoneNumber\tBookingDate\tNumberOfPeople");
//                System.out.println("==\t=====\t=========\t========\t===============\t===========\t===========\t==============");
//                //Processing Data Returned.
//                while (resultSet.next()) {
//                    System.out.println(resultSet.getString(8) + "\t" +
//                            resultSet.getString(1) + "\t" +
//                            resultSet.getString(2) + "\t" +
//                            resultSet.getString(3) + "\t" +
//                            resultSet.getString(4) + "\t" +
//                            resultSet.getString(5) + "\t" +
//                            resultSet.getString(6) + "\t" +
//                            resultSet.getString(7));
//                }
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            } finally {
                try {
                    if (null != connection) {
//                        resultSet.close();
                        statement.close();

                        connection.close();
                    }
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
                AnchorPane pane = FXMLLoader.load(getClass().getResource("bookingHomepage.fxml"));
                rootPane.getChildren().setAll(pane);

                System.out.println("Booking made");
            }
        }

    }

    public void onGoBackButtonClick(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("bookingHomepage.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Went Back");
    }
}
