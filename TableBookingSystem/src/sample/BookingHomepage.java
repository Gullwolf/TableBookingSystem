package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

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
     * One person dining button.
     *
     * @param actionEvent
     * @throws IOException
     */
    public void onDinerButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder dinerHolder = DinerHolder.getInstance();
        dinerHolder.setNumberOfDiners(Integer.parseInt(oneDiner.getText()));
        System.out.println(Integer.parseInt(oneDiner.getText()));

        DateHolder dateHolder = DateHolder.getInstance();
        dateHolder.setDate(dateSelector.getValue().toString());
        System.out.println(dateSelector.getValue().toString());

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected one diner.");

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

    public void onThreeDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(threeDiners.getText()));
        System.out.println(Integer.parseInt(threeDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onFourDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(fourDiners.getText()));
        System.out.println(Integer.parseInt(fourDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onFiveDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(fiveDiners.getText()));
        System.out.println(Integer.parseInt(fiveDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onSixDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(sixDiners.getText()));
        System.out.println(Integer.parseInt(sixDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onSevenDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(sevenDiners.getText()));
        System.out.println(Integer.parseInt(sevenDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onEightDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(eightDiners.getText()));
        System.out.println(Integer.parseInt(eightDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

    }

    public void onNineDinersButtonClick(ActionEvent actionEvent) throws IOException {
        DinerHolder holder = DinerHolder.getInstance();
        holder.setNumberOfDiners(Integer.parseInt(nineDiners.getText()));
        System.out.println(Integer.parseInt(nineDiners.getText()));

        AnchorPane pane = FXMLLoader.load(getClass().getResource("enterDetails.fxml"));
        rootPane.getChildren().setAll(pane);

        System.out.println("Selected two diners.");

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
