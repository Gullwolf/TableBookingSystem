package sample;

import javafx.animation.Transition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class TimeSelectionPage implements Initializable {

    @FXML
    private ComboBox<String> comboBox;

    ObservableList<String> list = FXCollections.observableArrayList("12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45", "14:00");

    public void initialize(URL location, ResourceBundle resources){
        comboBox.setItems(list);

    }

}
