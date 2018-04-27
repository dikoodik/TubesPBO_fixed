/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginParkirApp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kelompoksekian
 */
public class Database {
    private static Connection connection;

    public static Connection getConnection() {
        if(connection==null){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
            } catch (SQLException exception) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
        return connection;
    }
}
