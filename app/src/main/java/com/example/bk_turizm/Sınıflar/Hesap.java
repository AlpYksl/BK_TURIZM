package com.example.bk_turizm.Sınıflar;

public class Hesap {
    private int accountID;
    private String email;
    private String password;

    public Hesap(){

    }

    public Hesap(String email){
        this.email = email;
    }
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
