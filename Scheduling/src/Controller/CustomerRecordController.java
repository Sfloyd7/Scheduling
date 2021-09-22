package Controller;

import Model.*;
import Utils.DBConnection;
import Utils.DBQuery;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import Utils.PageChange;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CustomerRecordController  implements Initializable {
    
    public TableView<Customer> CustomerTable;
    public TableColumn<Customer, Integer> IDCol;
    public TableColumn<Customer, String> NameCol;
    public TableColumn<Customer, String> AddressCol;
    public TableColumn<Customer, String> ZipCol;
    public TableColumn<Customer, String> PhoneCol;
    public Label ErrorLbl;


    Stage stage;
    Parent scene;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        CustomerList.clearCustomers();

        try {
            CustomerList.initializeCustomerList();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        CustomerTable.setItems(CustomerList.getAllCustomers());
        IDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        NameCol.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        AddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
        ZipCol.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
        PhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));

        
    }

    public void OnClickAdd(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/CustomerDetails.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

    public void OnClickUpdate(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/CustomerUpdate.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }



    public void OnClickAppointments(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(PageChange.class.getResource("/view/Appointments.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }


    public void OnclickReports(ActionEvent event) {
    }

    public void OnClickLogoff(ActionEvent actionEvent) throws IOException {
        stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        scene = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        stage.setScene(new Scene(scene));
        stage.show();
    }

        public void OnClickDelete(ActionEvent event) throws IOException, SQLException {

            boolean deletable = false;
            Customer customer =  CustomerTable.getSelectionModel().getSelectedItem();
            int id = customer.getCustomerId();

            AppointmentList.clearCustAppt();
            AppointmentList.initializeCustAppt(id);

            if (AppointmentList.getCustAppt().isEmpty()) {
                deletable = true;
            }


            if (deletable = true) {
                String deletestatement = ("DELETE FROM customers WHERE Customer_ID = " + id);
                PreparedStatement delete = DBConnection.getConnection().prepareStatement(deletestatement);
                delete.execute();

                CustomerList.clearCustomers();

                try {
                    CustomerList.initializeCustomerList();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                CustomerTable.setItems(CustomerList.getAllCustomers());
                IDCol.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
                NameCol.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
                AddressCol.setCellValueFactory(new PropertyValueFactory<>("Address"));
                ZipCol.setCellValueFactory(new PropertyValueFactory<>("PostalCode"));
                PhoneCol.setCellValueFactory(new PropertyValueFactory<>("Phone"));

            }
            else ErrorLbl.setText("Delete all related Appointments first.");


            }

        }

