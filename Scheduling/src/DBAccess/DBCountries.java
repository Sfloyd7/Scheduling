/*package DBAccess;

import Database.DBConnection;
import Model.Appointment;
import Model.Countries;
import Utils.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBCountries {



        public static <Countries> Observablelist<Countries> getAllCountries(){

            ObservableList<Countries> clist = FXCollections.observableArrayList();
            try {
                String sql = "Select * from countries";
                PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);

                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    int countryId = rs.getInt("Country_ID");
                    String countryName = rs.getString("Country");
                    Countries C = new Countries()
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            return clist
        }

}
        */