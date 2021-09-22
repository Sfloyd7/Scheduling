package Controller;

import Model.*;
import Utils.DBConnection;
import Utils.DBQuery;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static Model.CountriesList.addCountry;
import static Model.CountriesList.getAllCountries;
import static Model.DivisionList.getAllDivisions;
import static Model.DivisionList.getSelectDivisions;

public class CustomerDetailsController  implements Initializable {
    Stage stage;
    Parent scene;


    @FXML
    private TextField CustomerID;

    @FXML
    private TextField NameTxt;

    @FXML
    private TextField AddressTxt;

    @FXML
    private TextField ZipCodeTxt;

    @FXML
    private TextField PhoneTxt;

    @FXML
    private ComboBox<Countries> CountryCmb;

    @FXML
    private ComboBox<Division> StateCmb;



    public void OnClickSave(ActionEvent actionEvent) throws IOException, SQLException {
        //int custId = 0;
        String name = NameTxt.getText();
        String address = AddressTxt.getText();
        String zip = ZipCodeTxt.getText();
        String phone = PhoneTxt.getText();
        int division = StateCmb.getSelectionModel().getSelectedItem().getDivisionId();
        Timestamp now = Timestamp.valueOf(LocalDateTime.now());
        String me = Login.getUsername();

        System.out.println("name: " + name);
        System.out.println("address: " + address);
        System.out.println("zip: " + zip);
        System.out.println("phone: " + phone);
        System.out.println("division ID: " + division);
        System.out.println("timestamp: " + now);
        System.out.println("username: " + me);

        //Connection conn = DBConnection.openConnection(); //Connect to database
        String insertStatement = "INSERT INTO customers (Customer_Name, Address, Postal_Code, Phone, Create_Date, Created_By, Last_Update, Last_Updated_By, Division_ID) VALUES(?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(insertStatement);
        //DBQuery.setPreparedStatement(DBConnection.getConnection(), insertStatement);
        //PreparedStatement ps = DBQuery.getPreparedStatement();

        //key value mapping
        ps.setString(1,name);
        ps.setString(2,address);
        ps.setString(3,zip);
        ps.setString(4,phone);
        ps.setTimestamp(5, now);
        ps.setString(6,me);
        ps.setTimestamp(7,now);
        ps.setString(8,me);
        ps.setInt(9,division);

        ps.execute();//execute prepared statement


        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/CustomerRecords.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void OnClickCancel(ActionEvent actionEvent) throws IOException {

        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/CustomerRecords.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CountriesList.clearCountries();
        try {
            CountriesList.initializeCountriesList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DivisionList.clearDivisions();
        try {
            DivisionList.initializeDivisions();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CountryCmb.setItems(CountriesList.getAllCountries());
        StateCmb.setItems(DivisionList.getAllDivisions());


    }

    public void OnClickCountry(ActionEvent actionEvent) throws SQLException {

        DivisionList.clearSelectDivisions();

        Countries country = CountryCmb.getSelectionModel().getSelectedItem();
        int id = country.getCountryId();
        DivisionList.initializeSelectDivision(id);
        StateCmb.setItems(getSelectDivisions());


    }
}
