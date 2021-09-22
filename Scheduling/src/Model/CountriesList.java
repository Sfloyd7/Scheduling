package Model;

import Utils.DBConnection;
import Utils.DBQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;

public class CountriesList {

    private static ObservableList<Countries> AllCountries = FXCollections.observableArrayList();



    public static void addCountry(Countries countries)
    {
        AllCountries.add(countries);
    }

    public static ObservableList<Countries> getAllCountries()
    {
        return AllCountries;
    }

    public static void clearCountries(){
        AllCountries.clear();
    }

    public static void initializeCountriesList()  throws SQLException, IOException
    {
        //Connection conn = DBConnection.openConnection(); //Connect to database
        DBQuery.setStatement(DBConnection.getConnection());//create statement object
        Statement statement = DBQuery.getStatement();

        String selectAppointment = "SELECT * from countries";
        statement.execute(selectAppointment);
        ResultSet rs = statement.getResultSet();


        while (rs.next()) {

            Integer countryId = rs.getInt("Country_ID");
            String country = rs.getString("Country");
            Timestamp createDate = rs.getTimestamp("Create_Date");
            String createdBy = rs.getString("Created_By");
            Timestamp lastUpdate = rs.getTimestamp("Last_Update");
            String updatedBy = rs.getString("Last_Updated_By");
            Countries countries = new Countries(countryId,country,createDate,createdBy,lastUpdate,updatedBy);
            addCountry(countries);
            }
        }




}
