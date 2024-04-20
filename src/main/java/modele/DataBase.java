package modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static Connection connect;
    public DataBase() throws ClassNotFoundException, SQLException {
        Class. forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/Ratatouille";
        connect = DriverManager.getConnection(url, "Pako", "26092001MPk");
        connect. setAutoCommit (true) ;
    }
    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if (connect == null) {
            new DataBase();
        }
        return connect;
    }
    public static Connection deconnection (Connection con) throws SQLException {
        con.close();
        return con;
    }
    public static Connection getConnect() {
        return connect;
    }
    public static void setConnect(Connection connect){
        DataBase.connect = connect;
    }
}