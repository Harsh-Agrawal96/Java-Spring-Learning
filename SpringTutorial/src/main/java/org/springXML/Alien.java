package org.springXML;

public class Alien {

    private Laptop lap;

    public Laptop getLap() {
        return lap;
    }

    public void setLap(Laptop lap) {
        this.lap = lap;
    }

    public void code() {
        System.out.println("coding checking...");
        lap.use();
        System.out.println("coding...");
    }
}
