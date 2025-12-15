package com.example.SpringBootWeb;

public class Alien {

    private int aid;
    private String aname;

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
