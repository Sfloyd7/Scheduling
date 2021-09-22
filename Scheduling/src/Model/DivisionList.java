package Model;

import Utils.DBConnection;
import Utils.DBQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;
import java.time.format.DateTimeFormatter;

public class DivisionList {
    private static ObservableList<Division> AllDivisions = FXCollections.observableArrayList();

    private static ObservableList<Division> SelectDivisions = FXCollections.observableArrayList();

    public static void addSelectDivisions(Division division) {
        SelectDivisions.add(division);
    }

    public static void initializeSelectDivision (int CountryID) throws SQLException {
        DBQuery.setStatement(DBConnection.getConnection());
        Statement statement = DBQuery.getStatement();

        String selectCountryID = ("SELECT * from first_level_divisions WHERE Country_ID = " + CountryID);
        statement.execute(selectCountryID);
        ResultSet rs = statement.getResultSet();

        while (rs.next()){
            Integer divisionId = rs.getInt("Division_ID");
            String division = rs.getString("Division");
            Timestamp createDate = rs.getTimestamp("Create_Date");
            String createBy = rs.getString("Created_By");
            Timestamp lastUpdate = rs.getTimestamp("Last_Update");
            String lastUpdateBy = rs.getString("Last_Updated_By");
            Integer countryId = rs.getInt("Country_ID");
            Division divisions = new Division(divisionId,division,createDate,createBy,lastUpdate,lastUpdateBy,countryId);
            addSelectDivisions(divisions);
        }
    }

    public static void clearSelectDivisions() {
        SelectDivisions.clear();
    }

    public static ObservableList<Division> getSelectDivisions() {
        return SelectDivisions;
    }

    public static void addDivisions(Division division) {
        AllDivisions.add(division);
    }

    public static ObservableList<Division> getAllDivisions() {
        return AllDivisions;
    }

    public static void clearDivisions() {
        AllDivisions.clear();
    }

    public static void initializeDivisions() throws SQLException, IOException {
        //Connection conn = DBConnection.openConnection(); //Connect to database
        DBQuery.setStatement(DBConnection.getConnection());//create statement object
        Statement statement = DBQuery.getStatement();

        String selectAppointment = "SELECT * from first_level_divisions";
        statement.execute(selectAppointment);
        ResultSet rs = statement.getResultSet();

        while (rs.next()) {

            Integer divisionId = rs.getInt("Division_ID");
            String division = rs.getString("Division");
            Timestamp createDate = rs.getTimestamp("Create_Date");
            String createBy = rs.getString("Created_By");
            Timestamp lastUpdate = rs.getTimestamp("Last_Update");
            String lastUpdateBy = rs.getString("Last_Updated_By");
            Integer countryId = rs.getInt("Country_ID");
            Division divisions = new Division(divisionId,division,createDate,createBy,lastUpdate,lastUpdateBy,countryId);
            addDivisions(divisions);
        }

    }
}
