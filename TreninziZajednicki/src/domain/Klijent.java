/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class Klijent extends AbstractDomainObject implements Serializable {
    
    private Long klijentID;
    private String imeKlijenta;
    private String prezimeKlijenta;
    private String email;
    private String telefon;

    @Override
    public String toString() {
        return imeKlijenta + " " + prezimeKlijenta;
    }

    public Klijent(Long klijentID, String imeKlijenta, String prezimeKlijenta, String email, String telefon) {
        this.klijentID = klijentID;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.email = email;
        this.telefon = telefon;
    }

    public Klijent() {
    }
    
    @Override
    public String nazivTabele() {
        return " klijent ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Klijent k = new Klijent(rs.getLong("klijentID"), 
                    rs.getString("imeKlijenta"), rs.getString("prezimeKlijenta"), 
                    rs.getString("email"), rs.getString("telefon"));

            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (imeKlijenta, prezimeKlijenta, email, telefon) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " klijentID = " + klijentID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imeKlijenta + "', '" + prezimeKlijenta + "', "
                + "'" + email + "', '" + telefon + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "imeKlijenta = '" + imeKlijenta + "', prezimeKlijenta = '" + prezimeKlijenta + "',"
                + " email = '" + email + "', telefon = '" + telefon + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Long klijentID) {
        this.klijentID = klijentID;
    }

    public String getImeKlijenta() {
        return imeKlijenta;
    }

    public void setImeKlijenta(String imeKlijenta) {
        this.imeKlijenta = imeKlijenta;
    }

    public String getPrezimeKlijenta() {
        return prezimeKlijenta;
    }

    public void setPrezimeKlijenta(String prezimeKlijenta) {
        this.prezimeKlijenta = prezimeKlijenta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
}
