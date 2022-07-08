package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class PrintBookingPage {

    @FXML
    private DatePicker dateSelector;

    @FXML
    private AnchorPane rootPane;

    public void onPrintTableButtonOnClick(ActionEvent actionEvent) {

        if (dateSelector.getValue() == null) {
            System.out.println(dateSelector.getValue());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Date Error");
            alert.setContentText("Please enter a valid date");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        } else {
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

                resultSet = statement.executeQuery("SELECT * FROM BookingReservations WHERE BookingDate='" + dateSelector.getValue() + "'");

                try {
                    FileWriter myWriter = new FileWriter("table Bookings " + dateSelector.getValue() + ".html");
                    myWriter.write("<!DOCTYPE html>\n");
                    myWriter.write("<html> <h1>Table Bookings for: " + dateSelector.getValue() + "</h1> <body> <table align='left' border='2'>\n");
                    myWriter.write("<tr>\n");
                    myWriter.write("<td>ID</td>\n");
                    myWriter.write("<td>Title</td>\n");
                    myWriter.write("<td>FirstName</td>\n");
                    myWriter.write("<td>LastName</td>\n");
                    myWriter.write("<td>CustomerMessage</td>\n");
                    myWriter.write("<td>PhoneNumber</td>\n");
                    myWriter.write("<td>BookingDate</td>\n");
                    myWriter.write("<td>NumberOfPeople</td>\n");
                    myWriter.write("</tr>\n");

                    //Processing Data Returned.
                    while (resultSet.next()) {
                        myWriter.write("<tr>\n");
                        myWriter.write("<td>" + resultSet.getInt(1) + "</td>\n");
                        myWriter.write("<td>" + resultSet.getString(2) + "</td>\n");
                        myWriter.write("<td>" + resultSet.getString(3) + "</td>\n");
                        myWriter.write("<td>" + resultSet.getString(4) + "</td>\n");
                        myWriter.write("<td>" + resultSet.getString(6) + "</td>\n");
                        myWriter.write("<td>" + resultSet.getString(5) + "</td>\n");
                        myWriter.write("<td>" + resultSet.getString(7) + "</td>\n");
                        myWriter.write("<td>" + resultSet.getString(8) + "</td>\n");
                        myWriter.write("</tr>\n");
                    }
                    myWriter.write("</table></body></html>");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            } finally {
                try {
                    if (null != connection) {
                        resultSet.close();
                        statement.close();

                        connection.close();
                    }
                } catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }

        }
    }
}
