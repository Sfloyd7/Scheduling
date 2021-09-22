package Controller;

import Model.Customer;
import Model.CustomerList;
import Model.Login;
import Utils.DBConnection;
import Utils.DBQuery;
import Utils.PageChange;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public Label UsernameLbl;
    public Label PasswordLbl;
    public Button exitBtn;
    public Button logonBtn;
    Stage stage;
    Parent scene;




    @FXML public TextField UserNameTxt;
    @FXML public TextField PasswordTxt;
    @FXML public Label LocationLbl;
    @FXML public Label ErrorLbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LocationLbl.setText(String.valueOf(ZoneId.systemDefault()));

        try {
            ResourceBundle rb = ResourceBundle.getBundle("Utils/Nat", Locale.getDefault());
            if (Locale.getDefault().getLanguage().equals("fr")|| Locale.getDefault().getLanguage().equals("en")) {
                UsernameLbl.setText(rb.getString("username"));
                PasswordLbl.setText(rb.getString("password"));
                logonBtn.setText(rb.getString("login"));
                exitBtn.setText(rb.getString("exit"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void OnClickLogon(ActionEvent actionEvent) throws SQLException, IOException {


        String UserName = UserNameTxt.getText();
        String Password = PasswordTxt.getText();


        String selectStatement = "SELECT * from client_schedule.users";
        //Connection conn = DBConnection.getConnection(); //Connect to database
        /*DBQuery.setPreparedStatement(DBConnection.getConnection(),selectStatement);//create statement object

        Statement statement = DBQuery.getPreparedStatement();*/
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(selectStatement);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                String username = rs.getString("User_Name");
                String password = rs.getString("Password");
                if((UserName.equals(username)) && (Password.equals(password))){
                    Login.setUsername(username);
                    System.out.println(username);

                    stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                    scene = FXMLLoader.load(getClass().getResource("/View/Appointments.fxml"));
                    stage.setScene(new Scene(scene));
                    stage.show();

                }
                else
                    try {
                        ResourceBundle rb = ResourceBundle.getBundle("Utils/Nat", Locale.getDefault());
                        if (Locale.getDefault().getLanguage().equals("fr")|| Locale.getDefault().getLanguage().equals("en"))
                            ErrorLbl.setText(rb.getString("username") + " " + rb.getString("or") + " " + rb.getString("password")+ " " + rb.getString("is") + " " + rb.getString("incorrect") );

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }


        //statement.execute(selectStatement);
        //ResultSet rs = statement.getResultSet();




    }

    public void OnClickExit(ActionEvent event) {
        System.exit(0);
        DBConnection.closeConnection();


    }



}
