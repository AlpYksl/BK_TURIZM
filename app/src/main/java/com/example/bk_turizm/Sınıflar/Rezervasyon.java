package com.example.bk_turizm.Sınıflar;

public class Rezervasyon {

    private int rezervasyonID;
    private String fname;
    private String lname;
    private String kalkış;
    private String gidiş;
    private String tarih;

    public Rezervasyon(String fname, String lname, String kalkış, String gidiş, String tarih) {
        this.fname = fname;
        this.lname = lname;
        this.kalkış = kalkış;
        this.gidiş = gidiş;
        this.tarih = tarih;
    }

    public int getRezervasyonID() {
        return rezervasyonID;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getKalkış() {
        return kalkış;
    }

    public String getGidiş() {
        return gidiş;
    }

    public String getTarih() {
        return tarih;
    }

    public void setRezervasyonID(int rezervasyonID) {
        this.rezervasyonID = rezervasyonID;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setKalkış(String kalkış) {
        this.kalkış = kalkış;
    }

    public void setGidiş(String gidiş) {
        this.gidiş = gidiş;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }
}
