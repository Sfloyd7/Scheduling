package Model;

import Utils.DBConnection;
import Utils.DBQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;

public class AppointmentList {

    private static ObservableList<Appointment> AllAppointments = FXCollections.observableArrayList();

    private static ObservableList<Appointment> CustAppt = FXCollections.observableArrayList();

    public static void addCustAppt(Appointment appointment) {CustAppt.add(appointment);}

    public static void clearCustAppt() {CustAppt.clear();}

    public static void initializeCustAppt (int CustomerId) throws SQLException {
        DBQuery.setStatement(DBConnection.getConnection());
        Statement statement = DBQuery.getStatement();

        String selectCustomerID = ("SELECT * from appointments WHERE Customer_ID = " + CustomerId);
        statement.execute(selectCustomerID);
        ResultSet rs = statement.getResultSet();

        while (rs.next()){
            Integer appointmentId = rs.getInt("Appointment_ID");
            String title = rs.getString("Title");
            String description = rs.getString("Description");
            String location = rs.getString("Location");
            String type = rs.getString("Type");
            Timestamp start = rs.getTimestamp("Start");
            Timestamp end = rs.getTimestamp("End");
            Timestamp createDate = rs.getTimestamp("Create_Date");
            String createBy = rs.getString("Created_By");
            Timestamp update = rs.getTimestamp("Last_Update");
            String updateBy = rs.getString("Last_Updated_By");
            Integer customerId = rs.getInt("Customer_ID");
            Integer userId = rs.getInt("User_ID");
            Integer contactID = rs.getInt("Contact_ID");
            Appointment appointment = new Appointment(appointmentId,title,description,location,type,start.toLocalDateTime(),end.toLocalDateTime(),createDate.toLocalDateTime(),createBy,update.toLocalDateTime(),updateBy,customerId,userId,contactID);
            AppointmentList.addCustAppt(appointment);
        }
    }

    public static ObservableList<Appointment> getCustAppt() {return CustAppt;}

    public static void addAppointment(Appointment appointment)
    {
        AllAppointments.add(appointment);
    }

    public static ObservableList<Appointment> getAllAppointments()
    {
        return AllAppointments;
    }



    public static void initializeAppointmentList()  throws SQLException, IOException
    {
        //Connection conn = DBConnection.openConnection(); //Connect to database
        DBQuery.setStatement(DBConnection.getConnection());//create statement object
        Statement statement = DBQuery.getStatement();

        String selectAppointment = "SELECT * from appointments";
        statement.execute(selectAppointment);
        ResultSet rs = statement.getResultSet();


        while (rs.next())
        {
            Integer appointmentId = rs.getInt("Appointment_ID");
            String title = rs.getString("Title");
            String description = rs.getString("Description");
            String location = rs.getString("Location");
            String type = rs.getString("Type");
            Timestamp start = rs.getTimestamp("Start");
            Timestamp end = rs.getTimestamp("End");
            Timestamp createDate = rs.getTimestamp("Create_Date");
            String createBy = rs.getString("Created_By");
            Timestamp update = rs.getTimestamp("Last_Update");
            String updateBy = rs.getString("Last_Updated_By");
            Integer customerId = rs.getInt("Customer_ID");
            Integer userId = rs.getInt("User_ID");
            Integer contactID = rs.getInt("Contact_ID");
            Appointment appointment = new Appointment(appointmentId,title,description,location,type,start.toLocalDateTime(),end.toLocalDateTime(),createDate.toLocalDateTime(),createBy,update.toLocalDateTime(),updateBy,customerId,userId,contactID);
            AppointmentList.addAppointment(appointment);
        }
    }

    public static void clearAppointments(){
        AllAppointments.clear();
    }
}
