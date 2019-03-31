package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author angel
 */
public class Connect {

    static String db = "country";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + db;
    Connection con = null;

    public Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, login, password);
            if (con != null) {
                System.out.println("Connection Successfully");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void Desconectar() {
        con = null;
    }
}
