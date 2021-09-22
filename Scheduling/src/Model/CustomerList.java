package Model;

import Utils.DBConnection;
import Utils.DBQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;

public class CustomerList {

    private static ObservableList<Customer> AllCustomers = FXCollections.observableArrayList();



    public static void addCustomer(Customer customer)
    {
        AllCustomers.add(customer);
    }

    public static ObservableList<Customer> getAllCustomers()
    {
        return AllCustomers;
    }

    public static void initializeCustomerList()  throws SQLException, IOException
    {
        //Connection conn = DBConnection.openConnection(); //Connect to database
        DBQuery.setStatement(DBConnection.getConnection());//create statement object
        Statement statement = DBQuery.getStatement();

        String selectCustomer = "SELECT * from customers";
        statement.execute(selectCustomer);
        ResultSet rs = statement.getResultSet();


        while (rs.next())
        {
            Integer customerId = rs.getInt("Customer_ID");
            String customerName = rs.getString("Customer_Name");
            String customerAddress = rs.getString("Address");
            String postalCode = rs.getString("Postal_Code");
            String phone = rs.getString("Phone");
            Timestamp createDate = rs.getTimestamp("Create_Date");
            String createBy = rs.getString("Created_By");
            Timestamp update = rs.getTimestamp("Last_Update");
            String updateBy = rs.getString("Last_Updated_By");
            Integer divisionId = rs.getInt("Division_ID");
            Customer customer = new Customer(customerId,customerName,customerAddress,postalCode,phone,createDate.toLocalDateTime(),createBy,update.toLocalDateTime(),updateBy,divisionId);
            CustomerList.addCustomer(customer);
        }
    }

    public static void clearCustomers(){
        AllCustomers.clear();
    }

}
