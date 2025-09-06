package ITServiceManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;

    public Conn (){

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/itservices", "root", "Admin@1234");
             statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}