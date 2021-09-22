package Model;

import Utils.DBConnection;
import Utils.DBQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.*;

public class UserList {
    private static ObservableList<User> AllUsers = FXCollections.observableArrayList();

    public static void addUser(User user)
    {
        AllUsers.add(user);
    }

    public static ObservableList<User> getAllUsers()
    {
        return AllUsers;
    }

    public static void initializeUserList()  throws SQLException, IOException
    {
        //Connection conn = DBConnection.openConnection(); //Connect to database
        DBQuery.setStatement(DBConnection.getConnection());//create statement object
        Statement statement = DBQuery.getStatement();

        String selectCustomer = "SELECT * from users";
        statement.execute(selectCustomer);
        ResultSet rs = statement.getResultSet();


        while (rs.next())
        {
            Integer userId = rs.getInt("User_ID");
            String userName = rs.getString("User_Name");
            String password = rs.getString("Password");
            Timestamp createDate = rs.getTimestamp("Create_Date");
            String createBy = rs.getString("Created_By");
            Timestamp update = rs.getTimestamp("Last_Update");
            String updateBy = rs.getString("Last_Updated_By");
            User user = new User(userId,userName,password,createDate.toLocalDateTime(),createBy,update.toLocalDateTime(),updateBy);
            UserList.addUser(user);
        }
    }

    public static void clearUsers(){
        AllUsers.clear();
    }

}

