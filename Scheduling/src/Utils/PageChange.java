package Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PageChange {
    Stage stage;
    Parent scene;




    public void toAppointments(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(PageChange.class.getResource("/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    public void toAppointmentDetails(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AppointmentDetails.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    public void toAppointmentUpdate(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/AppointmentUpdate.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    public void toCustomerRecords(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/CustomerRecords.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    public void toCustomerDetails(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/CustomerDetails.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    public void toCustomerUpdate(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/CustomerUpdate.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    public void toLogin(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }
}
