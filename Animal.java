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
public class Animal implements Serializable {
    String type;
    String animalname;
    String age;
    String colour;
    String gender;
    String health;
    String issues;
    Person Owner;

    public Animal(String type, String animalname, String age, String colour, String gender, String health, String issues, Person Owner) {
        this.type = type;
        this.animalname = animalname;
        this.age = age;
        this.colour = colour;
        this.gender = gender;
        this.health = health;
        this.issues = issues;
        this.Owner = Owner;
    }

    Animal(String type, String animalname, String age, String colour, String gender, String sues, String health) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return animalname;
    }

    public void setName(String animalname) {
        this.animalname = animalname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }

    public Person getOwner() {
        return Owner;
    }

    public void setOwner(Person Owner) {
        this.Owner = Owner;
    }

    void addAnimal(Animal animalToAdd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String displayanimal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
