/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginParkirApp.entity;

/**
 *
 * @author kelompoksekian
 */
public class Parkir {
    private String no_tiket;
    private String nopol;
    private String jenis;
    private String tgl_masuk;
    private String jam_masuk;
    private String tgl_keluar;
    private String jam_keluar;
    
    public void setNoTiket(String no_tiket){
        this.no_tiket = no_tiket;
    }
    
    public void setNopol(String nopol){
       this.nopol = nopol;
    }
    
    public void setJenis(String jenis){
        this.jenis = jenis;
    }
    
    public void setTglMasuk(String tgl_masuk){
        this.tgl_masuk = tgl_masuk;
    }
    
    public void setJamMasuk(String jam_masuk){
        this.jam_masuk = jam_masuk;

    }
    
    public void setTglKeluar(String tgl_keluar){
        this.tgl_keluar = tgl_keluar;
    }
    
    public void setJamKeluar(String jam_keluar){
        this.jam_keluar = jam_keluar;
    }
    
    public String getNoTiket(){
        return no_tiket;
    }
    
    public String getNopol(){
        return nopol;
    }
    
    public String getJenis(){
        return jenis;
    }
    
    public String getTglMasuk(){
        return tgl_masuk;
    }
    
    public String getTglKeluar(){
        return tgl_keluar;
    }
    
    public String getJamMasuk(){
        return jam_masuk;
    }
    
    public String getJamKeluar(){
        return jam_keluar;
    }
}
