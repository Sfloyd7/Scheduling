package Controller;

import Model.Appointment;
import Model.AppointmentList;
import Model.Customer;
import Utils.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;

public class AppointmentsController  implements Initializable {

    public TableView<Appointment> ApptTblvw;
    public TableColumn<Customer, Integer> AppointmentIDCol;
    public TableColumn<Customer, String> TitleCol;
    public TableColumn<Customer, String> DescCol;
    public TableColumn<Customer, String> LocationCol;
    public TableColumn<Customer, Integer> ContactCol;
    public TableColumn<Customer, String> TypeCol;
    public TableColumn<Customer, String> StartCol;
    public TableColumn<Customer, String> EndCol;
    public TableColumn<Customer, Integer> CustIDCol;



    Stage stage;
    Parent scene;

    @FXML
    private RadioButton AllAppointmentsRdBtn;

    @FXML
    private ToggleGroup TableSelectionGp;

    @FXML
    private RadioButton ThisWeekRdBtn;

    @FXML
    private RadioButton MonthRdBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        AppointmentList.clearAppointments();

        try {
            AppointmentList.initializeAppointmentList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ApptTblvw.setItems(AppointmentList.getAllAppointments());
        AppointmentIDCol.setCellValueFactory(new PropertyValueFactory<>("AppointmentId"));
        TitleCol.setCellValueFactory(new PropertyValueFactory<>("Title"));
        DescCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        LocationCol.setCellValueFactory(new PropertyValueFactory<>("Location"));
        ContactCol.setCellValueFactory(new PropertyValueFactory<>("ContactId"));
        TypeCol.setCellValueFactory(new PropertyValueFactory<>("Type"));
        StartCol.setCellValueFactory(new PropertyValueFactory<>("StartDisplay"));
        EndCol.setCellValueFactory(new PropertyValueFactory<>("EndDisplay"));
        CustIDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));

    }

    public void OnClickAllAppts(ActionEvent event) {
    }

    public void OnClickWeek(ActionEvent event) {
    }

    public void OnClickMonth(ActionEvent event) {
    }

    public void OnClickLogOff(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void OnClickAdd(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AppointmentDetails.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void OnClickUpdate(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AppointmentUpdate.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void OnclickDelete(ActionEvent event) {
    }

    public void OnClickCustomers(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/CustomerRecords.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void OnClickReports(ActionEvent event) {
    }


}
