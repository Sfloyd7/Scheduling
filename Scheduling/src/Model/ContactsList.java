package Model;

import Utils.DBConnection;
import Utils.DBQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactsList {

    private static ObservableList<Contacts> AllContacts = FXCollections.observableArrayList();

    public static void addContacts(Contacts contacts)
    {
        AllContacts.add(contacts);
    }

    public static ObservableList<Contacts> getAllContacts()
    {
        return AllContacts;
    }

    public static void initializeContactList()  throws SQLException, IOException {

        //Connection conn = DBConnection.openConnection(); //Connect to database
        DBQuery.setStatement(DBConnection.getConnection());//create statement object
        Statement statement = DBQuery.getStatement();

        String selectContacts = "SELECT * from contacts";
        statement.execute(selectContacts);
        ResultSet rs = statement.getResultSet();


        while (rs.next()) {
            int contactId = rs.getInt("Contact_ID");
            String contactName = rs.getString("Contact_Name");
            String Email = rs.getString("Email");

            Contacts contact = new Contacts(contactId,contactName,Email);
            addContacts(contact);


        }
    }
}
