/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Utama.java
 *
 * Created on 03 Jun 13, 7:07:12
 */
package LoginParkirApp.view;

/**
 *
 * @author Riandi Kartiko
 */

import java.sql.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.*;
import java.text.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import LoginParkirApp.entity.Parkir;
import LoginParkirApp.interf.ParkirInterf;
import LoginParkirApp.impl.ParkirImple;
import LoginParkirApp.utility.Koneksi;
//import loginapp.entity.Parkir;


public class ParkirView extends javax.swing.JInternalFrame {
    private static final long serialVersionUID = 1L;
    private List<Parkir> recParkir = new ArrayList<Parkir>();
    private List<Parkir> selectedParkir = new ArrayList<Parkir>();
    private ParkirInterf parkirInterf;
    DefaultTableModel isi;

    Connection cnn;
    Statement stm;
    ResultSet rss;

     public ParkirView() {
        initComponents();
        parkirInterf = new ParkirImple();
        bukaDatabase();
        initStatus();
        
        
//        initStatus();
    }   
    public void bukaDatabase(){
        try{
          cnn = new Koneksi().getConnection();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Coba Lagi, Koneksi Gagal"); 
        }
    }   
final public void loadAllParkir(){
         try{
             recParkir = parkirInterf.tampil_parkir();
         }catch (SQLException ex){
             Logger.getLogger(ParkirView.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
  
 final void tableFill() {
        Object data[][] = new Object[recParkir.size()][7];
        int x = 0;
        for (Parkir p : recParkir) {
            data[x][0] = p.getNoTiket();
            data[x][1] = p.getNopol();
            data[x][2] = p.getJenis();
            data[x][3] = p.getTglMasuk();
            data[x][4] = p.getJamMasuk();
            data[x][5] = p.getTglKeluar();
            data[x][6] = p.getJamKeluar();
            x++;
        }
        String judul[] = {"No Tiket", "No Pol", "Jenis", "Masuk"
        ,"Jam Masuk","Tgl Keluar","Jam Keluar"};
        tabel_parkir.setModel(new DefaultTableModel(data, judul));
      
    }
   
     public void loadSelectedParkir(){
          try {
           selectedParkir = parkirInterf.cari_data(cariField().getText());
        } catch (SQLException ex) {
            Logger.getLogger(ParkirView.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     void tableSelectedFill() {
        Object data[][] = new Object[selectedParkir.size()][7];
        int x = 0;
        for (Parkir p : selectedParkir) {
            data[x][0] = p.getNoTiket();
            data[x][1] = p.getNopol();
            data[x][2] = p.getJenis();
            data[x][3] = p.getTglMasuk();
            data[x][4] = p.getJamMasuk();
            data[x][5] = p.getTglKeluar();
            data[x][6] = p.getJamKeluar();
            x++;
        }
        String judul[] = {"No Tiket", "No Pol", "Jenis", "Masuk"
        ,"Jam Masuk","Tgl Keluar","Jam Keluar"};
        tabel_parkir.setModel(new DefaultTableModel(data, judul));
      
    }
void getData(){
        try{
            stm=cnn.createStatement();
            String perintah="SELECT  tgl_keluar, jam_keluar, TIME_FORMAT(`jam_keluar`,'%H')-TIME_FORMAT(`jam_masuk`,'%H') AS durasi FROM parkir where nopol='"+cari.getText()+"';";
            rss=stm.executeQuery(perintah);
            while(rss.next()){
                kkeluar_tgl.setText(rss.getString("tgl_keluar"));
                kkeluar_jam.setText(rss.getString("jam_keluar"));
                durasi.setText(rss.getString("durasi"));
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

public void reset(){
        cari.setText("");
        kjenis.setText("");
        kbj.setText("");
        kkeluar_jam.setText("");
        kkeluar_tgl.setText("");
        kmasuk_jam.setText("");
        kmasuk_tgl.setText("");
        biaya.setText("");
        durasi.setText("");
        
    }
   
   
     public void getBiaya(){
        int vdurasi;
        double vbj, vbiaya;
        
        vdurasi=Integer.parseInt(durasi.getText());
        vbj=Double.parseDouble(kbj.getText());
        
        if(vdurasi<=1){
            vbiaya=vbj;
        }else{
            vbiaya=(vbj)+((vdurasi-1)*500);
        }
        biaya.setText(""+vbiaya);
    }
     
     
       void initStatus() {
            loadAllParkir();
            tableFill();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nopol = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jenis = new javax.swing.JComboBox();
        Simpan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cari = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kjenis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        kmasuk_tgl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        kmasuk_jam = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        kkeluar_jam = new javax.swing.JTextField();
        kkeluar_tgl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        kbj = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        durasi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        biaya = new javax.swing.JTextField();
        keluar = new javax.swing.JButton();
        jCari = new javax.swing.JButton();
        jReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_parkir = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("No Polisi");

        nopol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nopolKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Jenis");

        jenis.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Motor", "Mobil" }));

        Simpan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Simpan.setText("Data Masuk");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nopol, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(242, 242, 242))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nopol, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(Simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Parkir Masuk", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cari Nopol");

        kjenis.setEditable(false);
        kjenis.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                kjenisInputMethodTextChanged(evt);
            }
        });
        kjenis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kjenisKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Jenis");

        kmasuk_tgl.setEditable(false);
        kmasuk_tgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kmasuk_tglKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tanggal Masuk");

        kmasuk_jam.setEditable(false);
        kmasuk_jam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kmasuk_jamKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Jam :");

        kkeluar_jam.setEditable(false);
        kkeluar_jam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kkeluar_jamKeyReleased(evt);
            }
        });

        kkeluar_tgl.setEditable(false);
        kkeluar_tgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kkeluar_tglKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Tanggal Keluar");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Jam :");

        kbj.setEditable(false);
        kbj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kbjKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("B/J  :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Durasi : ");

        durasi.setEditable(false);
        durasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                durasiKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Biaya:");

        biaya.setEditable(false);
        biaya.setBackground(new java.awt.Color(255, 255, 153));
        biaya.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                biayaKeyReleased(evt);
            }
        });

        keluar.setBackground(new java.awt.Color(102, 255, 51));
        keluar.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        jCari.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCari.setText("Cari");
        jCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCariActionPerformed(evt);
            }
        });

        jReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jReset.setText("Reset");
        jReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(kjenis)
                                    .addComponent(kmasuk_tgl, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(kbj)
                                    .addComponent(kmasuk_jam, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(durasi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kkeluar_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(biaya)
                            .addComponent(kkeluar_jam))))
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCari, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(1151, 1151, 1151))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCari)
                    .addComponent(jReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(kjenis, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kbj, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(kmasuk_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kmasuk_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(kkeluar_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kkeluar_jam, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(durasi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(biaya, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(keluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Parkir keluar", jPanel2);

        tabel_parkir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_parkir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_parkirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_parkir);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Sistem Parkir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(448, 448, 448)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(jTabbedPane1)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
    if( !"".equals(nopol.getText())){
    try{
        stm=cnn.createStatement();
        String perintah="insert into parkir(nopol,jenis,tgl_masuk,jam_masuk) values (upper('"+nopol.getText()+"'),'"+jenis.getSelectedItem()+"',CURDATE(),CURTIME());";
        stm.executeUpdate(perintah);
        JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
        nopol.setText("");
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Data Gagal Disimpan");
        System.out.println("erornya : "+e);
    }
       initStatus();
    }else{
        JOptionPane.showMessageDialog(null, "Anda Belum Input Nopol");
    }
}//GEN-LAST:event_SimpanActionPerformed

private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased

}//GEN-LAST:event_cariKeyReleased

private void kjenisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kjenisKeyReleased
    
}//GEN-LAST:event_kjenisKeyReleased

private void kmasuk_tglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kmasuk_tglKeyReleased
// TODO add your handling code here:
}//GEN-LAST:event_kmasuk_tglKeyReleased

private void kmasuk_jamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kmasuk_jamKeyReleased
// TODO add your handling code here:
}//GEN-LAST:event_kmasuk_jamKeyReleased

private void kkeluar_jamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kkeluar_jamKeyReleased
// TODO add your handling code here:
}//GEN-LAST:event_kkeluar_jamKeyReleased

private void kkeluar_tglKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kkeluar_tglKeyReleased
// TODO add your handling code here:
}//GEN-LAST:event_kkeluar_tglKeyReleased

private void kbjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kbjKeyReleased
// TODO add your handling code here:
}//GEN-LAST:event_kbjKeyReleased

private void durasiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_durasiKeyReleased
// TODO add your handling code here:
}//GEN-LAST:event_durasiKeyReleased

private void biayaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_biayaKeyReleased
// TODO add your handling code here:
}//GEN-LAST:event_biayaKeyReleased

private void tabel_parkirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_parkirMouseClicked
   reset();
    cari.setText(tabel_parkir.getValueAt(tabel_parkir.getSelectedRow(),1).toString());
    kjenis.setText(tabel_parkir.getValueAt(tabel_parkir.getSelectedRow(),2).toString());
    kmasuk_tgl.setText(tabel_parkir.getValueAt(tabel_parkir.getSelectedRow(),3).toString());
    kmasuk_jam.setText(tabel_parkir.getValueAt(tabel_parkir.getSelectedRow(),4).toString());
    
    try{
        stm=cnn.createStatement();
        String perintah="select tarif from kendaraan where jenis='"+kjenis.getText()+"'";
        rss=stm.executeQuery(perintah);
        while(rss.next()){
           kbj.setText(rss.getString("tarif"));
        }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null ,"Gagal  ");
            System.out.println("Erornya :  "+e);
            System.exit(0);
        }
}//GEN-LAST:event_tabel_parkirMouseClicked

private void kjenisInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_kjenisInputMethodTextChanged
    
}//GEN-LAST:event_kjenisInputMethodTextChanged


private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
       
    if( !"".equals(cari.getText())){
    try{
        stm=cnn.createStatement();
        String perintah="update parkir set tgl_keluar=curdate(), jam_keluar=curtime() where nopol='"+cari.getText()+"'";
        stm.executeUpdate(perintah);
        JOptionPane.showMessageDialog(null,"Berhasil Update Keluar");
        nopol.setText("");
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Data Gagal Diupdate");
        System.out.println("erornya : "+e);
    }
     getData();   
     getBiaya();
     initStatus(); 
    }else{
        JOptionPane.showMessageDialog(null, "Anda Belum Input Nomor Plat");
    }
    
}//GEN-LAST:event_keluarActionPerformed

    private void cariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyTyped

    }//GEN-LAST:event_cariKeyTyped

    private void jCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCariActionPerformed
    loadSelectedParkir();
    tableSelectedFill();
    if(cariField().getText().equals("")){
           tableFill();
    }

    }//GEN-LAST:event_jCariActionPerformed

    private void jResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jResetActionPerformed
        reset();
        tableFill();
    }//GEN-LAST:event_jResetActionPerformed

    private void nopolKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nopolKeyTyped
        if(nopol.getText().length()>=9) {  
        evt.consume();
    }//GEN-LAST:event_nopolKeyTyped
    }
  
public JTextField cariField(){
    return cari;
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Simpan;
    private javax.swing.JTextField biaya;
    private javax.swing.JTextField cari;
    private javax.swing.JTextField durasi;
    private javax.swing.JButton jCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jReset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox jenis;
    private javax.swing.JTextField kbj;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField kjenis;
    private javax.swing.JTextField kkeluar_jam;
    private javax.swing.JTextField kkeluar_tgl;
    private javax.swing.JTextField kmasuk_jam;
    private javax.swing.JTextField kmasuk_tgl;
    private javax.swing.JTextField nopol;
    private javax.swing.JTable tabel_parkir;
    // End of variables declaration//GEN-END:variables
}
