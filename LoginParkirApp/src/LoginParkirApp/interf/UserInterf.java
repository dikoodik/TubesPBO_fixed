/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginParkirApp.interf;

import LoginParkirApp.entity.User;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author kelompoksekian
 */
public interface UserInterf {
    
    public void insert(User u) throws SQLException;
    
    public void update(User u) throws SQLException;
    
    public void delete(String idUser) throws SQLException;
    
    public User loadByUsername(String namaUser) throws SQLException;
    
    public List<User> getAll() throws SQLException;
    
   
}
