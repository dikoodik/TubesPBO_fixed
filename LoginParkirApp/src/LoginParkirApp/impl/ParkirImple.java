/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginParkirApp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import LoginParkirApp.entity.Parkir;
import LoginParkirApp.utility.Koneksi;
import LoginParkirApp.interf.ParkirInterf;
import LoginParkirApp.view.ParkirView;
import javax.swing.JOptionPane;


/**
 *
 * @author kelompoksekian
 */

public class ParkirImple implements ParkirInterf {
    DefaultTableModel isi;
    PreparedStatement ps;
    Connection cnn;
    Statement st;
    ResultSet rs;


 
 
    @Override
  final public List<Parkir> tampil_parkir() throws SQLException{
     st = Koneksi.getConnection().createStatement();
     rs=st.executeQuery("SELECT * from parkir order by no_tiket asc");

     List<Parkir>list = new ArrayList<Parkir>();
            while(rs.next()){
                Parkir p = new Parkir();
                    p.setNoTiket(rs.getString("no_tiket"));
                    p.setNopol(rs.getString("nopol"));
                    p.setJenis(rs.getString("jenis"));
                    p.setTglMasuk(rs.getString("tgl_masuk"));
                    p.setJamMasuk(rs.getString("jam_masuk"));
                    p.setTglKeluar(rs.getString("tgl_keluar"));
                    p.setJamKeluar(rs.getString("jam_keluar"));
                    list.add(p);

            }    
                return list;
    }  
  
    @Override
    public List<Parkir> cari_data(String iPol) throws SQLException {
        String sql ="select * from parkir where nopol=?";
        ps = Koneksi.getConnection().prepareStatement(sql);
        ps.setString(1,iPol);
        rs = ps.executeQuery();                
        List<Parkir>list = new ArrayList<Parkir>();
        while(rs.next()){
            Parkir p = new Parkir();
                p.setNoTiket(rs.getString("no_tiket"));
                p.setNopol(rs.getString("nopol"));
                p.setJenis(rs.getString("jenis"));
                p.setTglMasuk(rs.getString("tgl_masuk"));
                p.setJamMasuk(rs.getString("jam_masuk"));
                p.setTglKeluar(rs.getString("tgl_keluar"));
                p.setJamKeluar(rs.getString("jam_keluar"));
                list.add(p);
     }
        return list;   
    }
}