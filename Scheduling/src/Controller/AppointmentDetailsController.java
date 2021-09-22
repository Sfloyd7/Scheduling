package Controller;

import Model.Customer;
import Model.Login;
import Utils.DBConnection;
import Utils.DBQuery;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.EventObject;
import java.util.ResourceBundle;

public class AppointmentDetailsController implements Initializable {


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
    private TextField CustIDTxt;

    @FXML
    private DatePicker StartDate;

    @FXML
    private DatePicker EndDate;

    @FXML
    private ComboBox<LocalTime> StartTime;

    @FXML
    private ComboBox<LocalTime> EndTime;

    @FXML
    private ComboBox<Customer> custCmb;

    @FXML
    private ComboBox<?> contactCmb;

    @FXML
    private ComboBox<?> userCmb;


    public void OnClickSave(ActionEvent actionEvent) throws IOException, SQLException {
        String title = TitleTxt.getText();
        String description = DescTxt.getText();
        String location = LocationTxt.getText();
        String contact = ContactTxt.getText();
        String type = TypeTxt.getText();
        //int custId = Integer.parseInt(CustIDTxt.getText());
        LocalDateTime startDateTime = LocalDateTime.of(StartDate.getValue(),StartTime.getSelectionModel().getSelectedItem());
        LocalDateTime endDateTime = LocalDateTime.of(EndDate.getValue(),EndTime.getSelectionModel().getSelectedItem());

        //Connection conn = DBConnection.openConnection(); //Connect to database
        String insertStatement = "INSERT INTO appointments (Title, Description, Location, Type, Start, End, Create_Date, Created_By, Last_Update,Last_Updated_By, ) VALUES(?,?,?,?,?,?,?,?,?,?)";
        DBQuery.setPreparedStatement(DBConnection.getConnection(), insertStatement);
        PreparedStatement ps = DBQuery.getPreparedStatement();

        //key value mapping
        ps.setString(1,title);
        ps.setString(2,description);
        ps.setString(3,location);
        ps.setString(4,type);
        ps.setTimestamp(5,Timestamp.valueOf(startDateTime));
        ps.setTimestamp(6,Timestamp.valueOf(endDateTime));
        ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
        ps.setString(8, Login.getUsername());
        ps.setTimestamp(9,Timestamp.valueOf(LocalDateTime.now()));
        ps.setString(10,Login.getUsername());
        //ps.setInt(9,division);

        ps.execute();//execute prepared statement

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

        StartTime.getSelectionModel().select(LocalTime.of(8,0));


    }
}
