package com.fromth.model;
import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String name, singer, album, theloai;
    private int yeuthich;

    public Item() {
    }

    public Item(int id, String name, String singer, String album, String theloai, int yeuthich) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.album = album;
        this.theloai = theloai;
        this.yeuthich = yeuthich;
    }

    public Item(String name, String singer, String album, String theloai, int yeuthich) {
        this.name = name;
        this.singer = singer;
        this.album = album;
        this.theloai = theloai;
        this.yeuthich = yeuthich;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public int getYeuthich() {
        return yeuthich;
    }

    public void setyeuthich(int like) {
        this.yeuthich = yeuthich;
    }
}

