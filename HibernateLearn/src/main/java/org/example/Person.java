package org.example;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Cacheable // L2 cache
public class Person {

    @Id
    private int pId;
    private String pName;
    private int pAge;

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pAge=" + pAge +
                '}';
    }
}
