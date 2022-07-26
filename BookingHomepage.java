package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;

import java.io.FileWriter;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import java.io.IOException;
import java.sql.*;
import java.util.ResourceBundle;

public class BookingHomepage implements Initializable {

    @FXML
    private DatePicker dateSelector;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ComboBox<String> comboBox;

    ObservableList<String> list = FXCollections.observableArrayList("12:00", "12:15", "12:30", "12:45",
            "13:00", "13:15", "13:30", "13:45",
            "14:00", "14:15", "14:30", "14:45",
            "15:00", "15:15", "15:30", "15:45",
            "16:00", "16:15", "16:30", "16:45",
            "17:00", "17:15", "17:30", "17:45",
            "18:00", "18:15", "18:30", "18:45",
            "19:00", "19:15", "19:30", "19:45",
            "20:00", "20:15", "20:30", "20:45",
            "21:00", "21:15", "21:30", "21:45",
            "22:00");

    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(list);

    }

    public void onPrintTableButtonOnClick(ActionEvent actionEvent) throws IOException {
//        //variables
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//        //Loading or registering Oracle JDBC driver class
//        try {
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//        } catch (ClassNotFoundException cnfex) {
//            System.out.println("Problem in loading or " + "registering MS Access JDBC driver");
//            cnfex.printStackTrace();
//        }
//
//        //Opening database connection
//        try {
//            String msAccDB = "D:/TableBookingSystem/BookingDatabase.accdb";
//            String dbURL = "jdbc:ucanaccess://" + msAccDB;
//
//            connection = DriverManager.getConnection(dbURL);
//
//            statement = connection.createStatement();
//
//            resultSet = statement.executeQuery("SELECT * FROM BookingReservations");
//
//            try {
//                FileWriter myWriter = new FileWriter("table.html");
//                myWriter.write("<!DOCTYPE html>\n");
//                myWriter.write("<html> <body> <table align='left' border='2'>\n");
//                myWriter.write("<tr>\n");
//                myWriter.write("<td>ID</td>\n");
//                myWriter.write("<td>Title</td>\n");
//                myWriter.write("<td>FirstName</td>\n");
//                myWriter.write("<td>LastName</td>\n");
//                myWriter.write("<td>CustomerMessage</td>\n");
//                myWriter.write("<td>PhoneNumber</td>\n");
//                myWriter.write("<td>BookingDate</td>\n");
//                myWriter.write("<td>NumberOfPeople</td>\n");
//                myWriter.write("</tr>\n");
//
//                //Processing Data Returned.
//                while (resultSet.next()) {
//                    myWriter.write("<tr>\n");
//                    myWriter.write("<td>" + resultSet.getInt(1) + "</td>\n");
//                    myWriter.write("<td>" + resultSet.getString(2) + "</td>\n");
//                    myWriter.write("<td>" + resultSet.getString(3) + "</td>\n");
//                    myWriter.write("<td>" + resultSet.getString(4) + "</td>\n");
//                    myWriter.write("<td>" + resultSet.getString(6) + "</td>\n");
//                    myWriter.write("<td>" + resultSet.getString(5) + "</td>\n");
//                    myWriter.write("<td>" + resultSet.getString(7) + "</td>\n");
//                    myWriter.write("<td>" + resultSet.getString(8) + "</td>\n");
//                    myWriter.write("</tr>\n");
//                }
//                myWriter.write("</table></body></html>");
//                myWriter.close();
//                System.out.println("Successfully wrote to the file.");
//            } catch (IOException e) {
//                System.out.println("An error occurred.");
//                e.printStackTrace();
//            }
//        } catch (SQLException sqlex) {
//            sqlex.printStackTrace();
//        } finally {
//            try {
//                if (null != connection) {
//                    resultSet.close();
//                    statement.close();
//
//                    connection.close();
//                }
//            } catch (SQLException sqlex) {
//                sqlex.printStackTrace();
//            }
//        }

        AnchorPane pane = FXMLLoader.load(getClass().getResource("printBookingPage.fxml"));
        rootPane.getChildren().setAll(pane);


    }

    public void onViewTableButtonOnClick(ActionEvent actionEvent) throws IOException {
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

            resultSet = statement.executeQuery("SELECT * FROM BookingReservations");

            System.out.println("ID\tTitle\tFirstName\tLastName\tCustomerMessage\tPhoneNumber\tBookingDate\tNumberOfPeople");
            System.out.println("==\t=====\t=========\t========\t===============\t===========\t===========\t==============");
            //Processing Data Returned.
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(8) + "\t" +//id
                        resultSet.getString(1) + "\t\t" +//title
                        resultSet.getString(2) + "\t\t" +//first name
                        resultSet.getString(3) + "\t\t" +//last name
                        resultSet.getString(5) + "\t\t" +//customer message
                        resultSet.getString(4) + "\t\t" +//phone number
                        resultSet.getString(6) + "\t\t" +
                        resultSet.getString(7));
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

    /**
     * Logs the user out and takes them back to the Login page.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onLogoutButtonClick(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Logged out.");

    }

    /**
     * All diner dining button.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onDinerButtonClick(ActionEvent actionEvent) throws IOException {
        boolean dataCorrect = false;
        DinerHolder dinerHolder = DinerHolder.getInstance();

        Node source = (Node) actionEvent.getSource();
        String id = source.getId();
        System.out.println(id);
        System.out.println(comboBox.getValue());

        switch (id) {
            case "oneDiner":
                dinerHolder.setNumberOfDiners(1);
                dataCorrect = true;
                break;
            case "twoDiners":
                dinerHolder.setNumberOfDiners(2);
                dataCorrect = true;
                break;
            case "threeDiners":
                dinerHolder.setNumberOfDiners(3);
                dataCorrect = true;
                break;
            case "fourDiners":
                dinerHolder.setNumberOfDiners(4);
                dataCorrect = true;
                break;
            case "fiveDiners":
                dinerHolder.setNumberOfDiners(5);
                dataCorrect = true;
                break;
            case "sixDiners":
                dinerHolder.setNumberOfDiners(6);
                dataCorrect = true;
                break;
            case "sevenDiners":
                dinerHolder.setNumberOfDiners(7);
                dataCorrect = true;
                break;
            case "eightDiners":
                dinerHolder.setNumberOfDiners(8);
                dataCorrect = true;
                break;
            case "nineDiners":
                dinerHolder.setNumberOfDiners(9);
                dataCorrect = true;
                break;
            case "tenDiners":
                dinerHolder.setNumberOfDiners(10);
                dataCorrect = true;
                break;
            case "elevenDiners":
                dinerHolder.setNumberOfDiners(11);
                dataCorrect = true;
                break;
            case "twelveDiners":
                dinerHolder.setNumberOfDiners(12);
                dataCorrect = true;
                break;
            case "thirteenDiners":
                dinerHolder.setNumberOfDiners(13);
                dataCorrect = true;
                break;
            case "fourteenDiners":
                dinerHolder.setNumberOfDiners(14);
                dataCorrect = true;
                break;
            case "fifteenDiners":
                dinerHolder.setNumberOfDiners(15);
                dataCorrect = true;
                break;
            case "sixteenDiners":
                dinerHolder.setNumberOfDiners(16);
                dataCorrect = true;
                break;
            case "seventeenDiners":
                dinerHolder.setNumberOfDiners(17);
                dataCorrect = true;
                break;
            case "eighteenDiners":
                dinerHolder.setNumberOfDiners(18);
                dataCorrect = true;
                break;
            case "nineteenDiners":
                dinerHolder.setNumberOfDiners(19);
                dataCorrect = true;
                break;
            case "twentyDiners":
                dinerHolder.setNumberOfDiners(20);
                dataCorrect = true;
                break;
            case "twentyOneDiners":
                dinerHolder.setNumberOfDiners(21);
                dataCorrect = true;
                break;
            case "twentyTwoDiners":
                dinerHolder.setNumberOfDiners(22);
                dataCorrect = true;
                break;
            case "TwentyThreeDiners":
                dinerHolder.setNumberOfDiners(23);
                dataCorrect = true;
                break;
            case "twentyFourDiners":
                TextInputDialog td = new TextInputDialog("");
                td.setTitle("Number of diners needed");
                td.setHeaderText("Number of diners");
                td.setContentText("Please enter the number of diners: ");
                td.showAndWait();
                if (!td.getEditor().getText().matches("[0-9]+")) {
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
                    int tempDiners = Integer.parseInt(td.getEditor().getText());
                    dinerHolder.setNumberOfDiners(tempDiners);
                    dataCorrect = true;
                    break;
                }
        }

        //boolean test = (Integer.valueOf(comboBox.getValue().replace(":", "")) <= Integer.valueOf(LocalTime.now().toString().replace(":","")));

        System.out.println(comboBox.getValue().replace(":", ""));
        System.out.println(LocalTime.now().getHour() + "" + LocalTime.now().getMinute());
        System.out.println(LocalTime.now().isBefore(LocalTime.parse(comboBox.getValue())));
        int timeNow = Integer.parseInt(LocalTime.now().getHour() + "" + LocalTime.now().getMinute());
        int bookingTime = Integer.valueOf(comboBox.getValue().replace(":", ""));

        if (dataCorrect) {
            if ((dateSelector.getValue() == null) || (dateSelector.getValue().isBefore(LocalDate.now())) || (comboBox.getValue() == null) || (!(dateSelector.getValue().isBefore(LocalDate.now())) && (bookingTime <= timeNow))) {
                System.out.println(LocalDate.now());
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
                DateHolder dateHolder = DateHolder.getInstance();
                dateHolder.setDate(dateSelector.getValue().toString());
                System.out.println(dateSelector.getValue().toString());

                TimeHolder timeHolder = TimeHolder.getInstance();
                timeHolder.setTimeOfBooking(comboBox.getValue());

                AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
                rootPane.getChildren().setAll(pane);

                System.out.println("Selected diner.");
            }
        }

    }

}
