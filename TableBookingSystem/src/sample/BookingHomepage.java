package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Node;

import java.io.IOException;
import java.sql.*;

public class BookingHomepage {

    @FXML
    private javafx.scene.control.Button oneDiner;

    @FXML
    private javafx.scene.control.Button twoDiners;

    @FXML
    private javafx.scene.control.Button threeDiners;

    @FXML
    private javafx.scene.control.Button fourDiners;

    @FXML
    private javafx.scene.control.Button fiveDiners;

    @FXML
    private javafx.scene.control.Button sixDiners;

    @FXML
    private javafx.scene.control.Button sevenDiners;

    @FXML
    private javafx.scene.control.Button eightDiners;

    @FXML
    private javafx.scene.control.Button nineDiners;

    @FXML
    private javafx.scene.control.Button tenDiners;

    @FXML
    private javafx.scene.control.Button elevenDiners;

    @FXML
    private javafx.scene.control.Button twelveDiners;

    @FXML
    private javafx.scene.control.Button thirteenDiners;

    @FXML
    private javafx.scene.control.Button fourteenDiners;

    @FXML
    private javafx.scene.control.Button fifteenDiners;

    @FXML
    private javafx.scene.control.Button sixteenDiners;

    @FXML
    private javafx.scene.control.Button seventeenDiners;

    @FXML
    private javafx.scene.control.Button eighteenDiners;

    @FXML
    private javafx.scene.control.Button nineteenDiners;

    @FXML
    private javafx.scene.control.Button twentyDiners;

    @FXML
    private javafx.scene.control.Button twentyOneDiners;

    @FXML
    private javafx.scene.control.Button twentyTwoDiners;

    @FXML
    private javafx.scene.control.Button twentyThreeDiners;

    @FXML
    private javafx.scene.control.Button twentyFourDiners;

    @FXML
    private DatePicker dateSelector;

    @FXML
    private AnchorPane rootPane;

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

        if (dataCorrect) {
            if (dateSelector.getValue() == null) {
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

                AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
                rootPane.getChildren().setAll(pane);

                System.out.println("Selected diner.");
            }
        }

    }

    /**
     * Two people dining button.
     *
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

    /**
     * Three people dining button
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onThreeDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(threeDiners.getText()));
        System.out.println(Integer.parseInt(threeDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected three diners.");

    }

    /**
     * Four people dining button
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onFourDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(fourDiners.getText()));
        System.out.println(Integer.parseInt(fourDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected four diners.");

    }

    /**
     * Five people dining button
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onFiveDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(fiveDiners.getText()));
        System.out.println(Integer.parseInt(fiveDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected five diners.");

    }

    /**
     * Six people dining button
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onSixDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(sixDiners.getText()));
        System.out.println(Integer.parseInt(sixDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected six diners.");

    }

    /**
     * Seven people dining button
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onSevenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(sevenDiners.getText()));
        System.out.println(Integer.parseInt(sevenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected seven diners.");

    }

    /**
     * Eight people dining button
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onEightDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(eightDiners.getText()));
        System.out.println(Integer.parseInt(eightDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected eight diners.");

    }

    /**
     * Nine people dining button
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onNineDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(nineDiners.getText()));
        System.out.println(Integer.parseInt(nineDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected nine diners.");

    }

    public void onTenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(tenDiners.getText()));
        System.out.println(Integer.parseInt(tenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onElevenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(elevenDiners.getText()));
        System.out.println(Integer.parseInt(elevenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onTwelveDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(twelveDiners.getText()));
        System.out.println(Integer.parseInt(twelveDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onThirteenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(thirteenDiners.getText()));
        System.out.println(Integer.parseInt(thirteenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onFourteenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(fourteenDiners.getText()));
        System.out.println(Integer.parseInt(fourteenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onFifteenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(fifteenDiners.getText()));
        System.out.println(Integer.parseInt(fifteenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onSixteenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(sixteenDiners.getText()));
        System.out.println(Integer.parseInt(sixteenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onSeventeenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(seventeenDiners.getText()));
        System.out.println(Integer.parseInt(seventeenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onEighteenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(eighteenDiners.getText()));
        System.out.println(Integer.parseInt(eighteenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onNineteenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(nineteenDiners.getText()));
        System.out.println(Integer.parseInt(nineteenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onTwentyDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(twentyDiners.getText()));
        System.out.println(Integer.parseInt(twentyDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onTwentyOneDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(twentyOneDiners.getText()));
        System.out.println(Integer.parseInt(twentyOneDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onTwentyTwoDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(twentyTwoDiners.getText()));
        System.out.println(Integer.parseInt(twentyTwoDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onTwentyThreeDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(twentyThreeDiners.getText()));
        System.out.println(Integer.parseInt(twentyThreeDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onTwentyFourDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(twentyFourDiners.getText()));
        System.out.println(Integer.parseInt(twentyFourDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

}
