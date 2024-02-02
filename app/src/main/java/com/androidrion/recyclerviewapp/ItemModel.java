package com.androidrion.recyclerviewapp;

public class ItemModel {

    private String namabrg;
    private String kodbrg;
    private String desbrg;
    private String hrgbrg;
    private int gambarbrg;

    public ItemModel(String namabrg, String kodbrg, String desbrg, String hrgbrg, int gambarbrg) {
        this.namabrg = namabrg;
        this.kodbrg = kodbrg;
        this.desbrg = desbrg;
        this.hrgbrg = hrgbrg;
        this.gambarbrg = gambarbrg;
    }

    public String getNamabrg() {
        return namabrg;
    }

    public void setNamabrg(String namabrg) {
        this.namabrg = namabrg;
    }

    public String getKodbrg() {
        return kodbrg;
    }

    public void setKodbrg(String kodbrg) {
        this.kodbrg = kodbrg;
    }

    public String getDesbrg() {
        return desbrg;
    }

    public void setDesbrg(String desbrg) {
        this.desbrg = desbrg;
    }

    public String getHrgbrg() {
        return hrgbrg;
    }

    public void setHrgbrg(String hrgbrg) {
        this.hrgbrg = hrgbrg;
    }

    public int getGambarbrg() {
        return gambarbrg;
    }

    public void setGambarbrg(int gambarbrg) {
        this.gambarbrg = gambarbrg;
    }
}
