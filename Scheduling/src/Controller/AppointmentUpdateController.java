package Controller;

import Model.AppointmentList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AppointmentUpdateController  implements Initializable {


    Stage stage;
    Parent scene;

    @FXML
    private TextField ApptIDTxt;

    @FXML
    private TextField TitleTxt;

    @FXML
    private TextField DescTxt;

    @FXML
    private TextField LocationTxt;

    @FXML
    private TextField ContactTxt;

    @FXML
    private TextField TypeTxt;


    @FXML
    private DatePicker StartDate;

    @FXML
    private DatePicker EndDate;

    @FXML
    private ComboBox<LocalTime> StartTime;

    @FXML
    private ComboBox<LocalTime> EndTime;

    @FXML
    private ComboBox<?> custCmb;

    @FXML
    private ComboBox<?> contactCmb;

    @FXML
    private ComboBox<?> userCmb;



    public void OnClickSave(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void OnClickCancel(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        LocalTime start = LocalTime.of(8,0);
        LocalTime end = LocalTime.of(17,0);

        while(start.isBefore(end.plusSeconds(1))){
            StartTime.getItems().add(start);
            EndTime.getItems().add(start);
            start = start.plusMinutes(15);
        }


    }
}
