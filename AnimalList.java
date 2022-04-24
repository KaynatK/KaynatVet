/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kaynatpvet;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Chintu
 */
public class AnimalList  implements Serializable {
    private ArrayList<Animal> animalToAdd;
    public final int MAX;
        
    /** Constructor initialises the empty motorbike list and sets the maximum list size 
     *  @param   maxIn The maximum number of motorbikes in the list
     */
    public AnimalList(int maxIn)
    {
        animalToAdd= new ArrayList<>();
        MAX = maxIn;
    }
	
    
    public boolean addAnimal(Animal theAnimal)
    {
        if(!isFull())
        {  
            animalToAdd.add(theAnimal);
            return true;
        }
        else
        {
            return false;
        }
    }
        


  
    public boolean isEmpty()
    {
        return animalToAdd.isEmpty();
    }
	
  
    public boolean isFull()
    {
        return animalToAdd.size()== MAX;
    }
        
    
    public int getTotal()
    {       
        return animalToAdd.size();
    }
      
         
    public Animal getBike(int positionIn)
    {
        if (positionIn < 0 || positionIn >= getTotal()) // check for valid position
        {
            return null; // no object found at given position
        }
        else
        {
            // remove one frm logical poition to get ArrayList position
            return animalToAdd.get(positionIn);
        }
    }
    
   
    
    public String displayanimal()
    {
      String display = "\n";  
      for (int counter = 0; counter < animalToAdd.size(); counter++) { 
          display += "\t" + animalToAdd.get(counter).Owner + animalToAdd.get(counter).Owner;
          display += "\t" + animalToAdd.get(counter).Owner + animalToAdd.get(counter).Owner;
          display += animalToAdd.get(counter).type + animalToAdd.get(counter).animalname + "\n" + "Owner of" + "\t" + animalToAdd.get(counter).age; 
          display += animalToAdd.get(counter).colour + animalToAdd.get(counter).gender + animalToAdd.get(counter).health;
          display += animalToAdd.get(counter).issues;
          display += "\n\n";
      } 
        return display;
    }
}


    

