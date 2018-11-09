package com.example.manuelliriano.calculadoradeprestamos;

public class VariablePrestamo {

    private String capital;
    private String cuota;
    private String interes;
    private String balance;
    private int n;

    public VariablePrestamo(){

    }

    public VariablePrestamo(String capital, String cuota, String interes, String balance, int n) {
        this.capital = capital;
        this.cuota = cuota;
        this.interes = interes;
        this.balance = balance;
        this.n = n;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCuota() {
        return cuota;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
