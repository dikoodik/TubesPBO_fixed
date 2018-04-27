/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginParkirApp.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import LoginParkirApp.entity.User;
import LoginParkirApp.interf.UserInterf;
import LoginParkirApp.utility.Database;


/**
 *
 * @author kelompoksekian
 */
public class UserImple implements UserInterf{

    @Override
    public void insert(User u) throws SQLException {
        String sql = "insert into user values (?,?,?,?,?)";
        PreparedStatement ps=Database.getConnection().prepareStatement(sql);
        ps.setString(1, u.getIdUser());
        ps.setString(2, u.getNama());
        ps.setString(3, u.getUsername());
        ps.setString(4, u.getPassword());
        ps.setString(5, u.getAkses());
        ps.executeUpdate();
    }

    @Override
    public void update(User u) throws SQLException {
        String sql = "update user set nama=?, username=?, password=?, privilage = ? where id_user=?";
        PreparedStatement ps=Database.getConnection().prepareStatement(sql);
        ps.setString(1, u.getNama());
        ps.setString(2, u.getUsername());
        ps.setString(3, u.getPassword());
        ps.setString(4, u.getAkses());
        ps.setString(5, u.getIdUser());
        ps.executeUpdate();
    }

    @Override
    public void delete(String idUser) throws SQLException {
        String sql = "delete from user where id_user=?";
        PreparedStatement ps=Database.getConnection().prepareStatement(sql);
        ps.setString(1, idUser);
        ps.executeUpdate();
    }


    @Override
    public User loadByUsername(String namaUser) throws SQLException {
        String sql = "select * from user where username=?";
        PreparedStatement ps=Database.getConnection().prepareStatement(sql);
        ps.setString(1, namaUser);
        ResultSet rs=ps.executeQuery();
        User u = new User();
        if(rs.next()){
            u.setIdUser(rs.getString("id_user"));
            u.setNama(rs.getString("nama"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setAkses(rs.getString("privilage"));
        }
        return u;
    }

    @Override
    public List<User> getAll() throws SQLException {
        Statement st=Database.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select * from user");
        List<User>list=new ArrayList<User>();
        while(rs.next()){
            User u = new User();
            u.setIdUser(rs.getString("id_user"));
            u.setNama(rs.getString("nama"));        
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setAkses(rs.getString("privilage"));
            list.add(u);
        }
        return list;
    }
   
    
}
