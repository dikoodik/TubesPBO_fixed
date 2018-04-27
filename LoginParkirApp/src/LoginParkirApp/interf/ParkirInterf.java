/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginParkirApp.interf;
import java.sql.SQLException;
import java.util.List;
import LoginParkirApp.entity.Parkir;
/**
 *
 * @author kelompoksekian
 */
public interface ParkirInterf {



public List<Parkir> tampil_parkir() throws SQLException;
public List<Parkir> cari_data(String iPol) throws SQLException;


}
