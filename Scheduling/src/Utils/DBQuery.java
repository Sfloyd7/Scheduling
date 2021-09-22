package Utils;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQuery {
    
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    
    //Create statement object
    public static void setStatement(Connection conn)throws SQLException
    {
        statement = conn.createStatement();
    }

    //Return Statement Object
    public static Statement getStatement()
    {
        return statement;
    }

    public static void setPreparedStatement(Connection conn, String sqlStatement) throws SQLException
    {
        statement= conn.prepareStatement(sqlStatement);
    }

    public static PreparedStatement getPreparedStatement(){return preparedStatement;}



}
