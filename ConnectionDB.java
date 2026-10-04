import java.sql.*;
public class ConnectionDB {
    Connection connection;
    Statement statement;
    public ConnectionDB(){
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem","root","kanak123");
            statement=connection.createStatement();
            System.out.println("database connected successfully!");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
