/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kaynatpvet;

import java.io.Serializable;

/**
 *
 * @author Chintu
 */
public class Person implements Serializable {
    String ownerName;
    String ownerSurname;
    String ownerNumber;
    String address;

    public Person(String ownerName, String ownerSurname, String ownerNumber, String address) {
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.ownerNumber = ownerNumber;
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public String getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(String ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
   
}
