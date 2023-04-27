package com.fromth.model;

public class NumberTheLoai {
    private String theloai;
    private int number;

    public NumberTheLoai(String theloai, int number) {
        this.theloai = theloai;
        this.number = number;
    }

    public NumberTheLoai() {
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
