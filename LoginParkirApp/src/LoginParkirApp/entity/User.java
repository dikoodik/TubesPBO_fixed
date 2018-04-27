/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginParkirApp.entity;

/**
 *
 * @author kelompoksekian
 */
public class User {
    private String idUser;
    private String nama;
    private String username;
    private String password;
    private String akses;

    public String getAkses() {
        return akses;
    }

    public void setAkses(String akses) {
        this.akses = akses;
    }  

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
