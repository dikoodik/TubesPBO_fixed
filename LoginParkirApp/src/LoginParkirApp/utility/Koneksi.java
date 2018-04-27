/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginParkirApp.utility;

/**
 *
 * @author kelompoksekian
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Koneksi{
private static Connection connection;

    public static Connection getConnection() {
        if(connection==null){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkir_db", "root", "");
            } catch (SQLException exception) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
        return connection;
    }

}
