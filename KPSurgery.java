package com.mycompany.kaynatpvet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class KPSurgery extends Application {
    
    private Animal AnimalList;
    
    private final int WIDTH = 1480;
    private final int HEIGHT = 1090;
    
    
    private Label headingLabel = new Label("Welcome to Vet Surgey");
    private Label animalLabel = new Label("Animal Information:");
    ComboBox<String> typebox = new ComboBox<>();
    private Label nameLabel = new Label("Name:");
    private TextField animalnameField = new TextField();
    private Label ageLabel = new Label("Age:");
    private TextField ageField = new TextField();
    private Label colourLabel = new Label("Colour:");
    private TextField colourField = new TextField();
    private Label genderLabel = new Label("Gender:");
    private TextField genderField = new TextField();
    private Label healthLabel = new Label("Health:");
    ComboBox<String> healthbox = new ComboBox<>();
    private Label issuesLabel = new Label("Describe the issue:");
    private TextField issuesField = new TextField();
    private Separator sectSeparator = new Separator();
    private Separator sectSeparator2 = new Separator();
    private Separator sectSeparator3 = new Separator();
    private Separator sectSeparator4 = new Separator();
    private Label ownerLabel = new Label("Owner Information:");
    private Label OwnernnameLabel = new Label("Given Name:");
    private TextField nameField = new TextField();
    private Label ownersurnameLabel = new Label("Surname:");
    private TextField surnameField = new TextField();
    private Label numberLabel = new Label("Contact no:");
    private TextField numberField = new TextField();
    private Label addressLabel = new Label("Address:");
    private TextField addressField = new TextField();
    private Label displayLabel = new Label("List of Animals:");
    private TextArea displayAnimals = new TextArea();
    private Button addButton = new Button("Register In");
    

    @Override
    public void start(Stage stage) {
        // this combobox is  for animal type
        typebox.setPromptText("Animal Type");
        typebox.getItems().addAll("Cat","Dog", "Rabbits", "Snake", "Fish", "Bird" , "Turtles", "Chicken", "Goats","Hamsters", "Horses","Rats", "Pigeons5");
        VBox type = new VBox(10);
        type.setPadding(new Insets (20,20,20,20));
        type.setAlignment(Pos.TOP_CENTER);
        
        // this combobox is  for health
        healthbox.setPromptText("Select Option");
        healthbox.getItems().addAll("Healthy","Excellent", "Very Good", "Good", "Average", "Fair" , "OK");
        VBox health = new VBox(10);
        health.setPadding(new Insets (20,20,20,20));
        health.setAlignment(Pos.TOP_CENTER);
        
        // Hboxes for animal and owner informanction
        HBox animalInfo = new HBox(10);
        HBox ownerInfo  = new HBox(10);
        
        // set components for both of Hbox
        animalInfo.getChildren().addAll(typebox,nameLabel,animalnameField,ageLabel,ageField,colourLabel,colourField,genderLabel,genderField,healthLabel,healthbox ,issuesLabel,issuesField );
        ownerInfo.getChildren().addAll(OwnernnameLabel,nameField, ownersurnameLabel,surnameField,numberLabel, numberField, addressLabel,addressField );
        
        VBox root = new VBox(10);
        // add all components to VBox
        root.getChildren().addAll(headingLabel, sectSeparator, animalLabel, animalInfo, sectSeparator2,
                ownerLabel, ownerInfo, sectSeparator3, displayLabel, displayAnimals, sectSeparator4, addButton);
        
        
           Scene  scene = new Scene(root, Color.web("#42cbf5"));
        Font font = new Font("Times New Roman", 40);
        headingLabel.setFont(font);
        font = new Font("Arial Black", 20);
        animalLabel.setFont(font);
        ownerLabel.setFont(font);
        displayLabel.setFont(font);
        
        animalInfo.setAlignment(Pos.CENTER);
        ownerInfo.setAlignment(Pos.CENTER);
        addButton.setAlignment(Pos.CENTER);

        root.setAlignment(Pos.CENTER);
        root.setBackground(Background.EMPTY);

        displayAnimals.setMaxSize(400, 700);
     

        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);

        addButton.setOnAction(e -> addHandler());
        
        stage.setScene(scene);
        stage.setTitle("Animal Clinic");
        stage.show();
    }
    
    private void addHandler() {
        String type = typebox.getValue();
        String animalname = animalnameField.getText();
        String age = ageField.getText();
        String colour = colourField.getText();
        String gender = genderField.getText();
        String health = healthbox.getValue();
        String issues = issuesField.getText();
        String name = nameField.getText();
        String surname = surnameField.getText();
        String number = numberField.getText();
        String address = addressField.getText();
       if (type.length() == 0 || animalname.length() == 0 || issues.length() == 0 || health.length() == 0) {
            displayAnimals.setText("You must enter correct information of your animal.");
        } else if (name.length() == 0 || surname.length() == 0) {
            displayAnimals.setText("You must enter the correct information of you");
        }  else 
            
        { 
          Person Owner = new Person (name, surname, number, address);
          Animal animalToAdd = new Animal(type, animalname, age, colour, gender,issues, health);
          AnimalList.addAnimal(animalToAdd);
          
        animalnameField.setText("");
        ageField.setText("");
        colourField.setText("");
        genderField.setText("");
        issuesField.setText("");
        nameField.setText("");
        surnameField.setText("");
        numberField.setText("");
        addressField.setText("");
        displayAnimals.setText("");
        displayAnimals.appendText(animalname + " successfully added");
        displayAnimals.appendText("\n\n The Animal is in waiting list for check-up.");
        displayAnimals.appendText(AnimalList.displayanimal());
        }
    }
    
 public static void main(String[] args) {
        launch(args);
    }
  private void SaveData() {
        try {
            FileOutputStream fileOut = new FileOutputStream("./saveData.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            Object AnimalList = null;
            out.writeObject(AnimalList);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./saveData.ser file");
        } catch (IOException myException) {
            myException.printStackTrace();
        }
        
    

}
    private boolean ShowData() {
        Object obj;
        try {
            FileInputStream fileIn = new FileInputStream("./saveData.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = in.readObject();
            AnimalList = (Animal)obj;
            in.close();
            fileIn.close();
            AnimalList.displayanimal();
            return true;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        } catch (ClassNotFoundException c) {
            System.out.println("Animal class not found");
            c.printStackTrace();
            return false;
        }
    }
    private void clearList() {
        animalnameField.setText("");
        ageField.setText("");
        colourField.setText("");
        genderField.setText("");
        issuesField.setText("");
        nameField.setText("");
        surnameField.setText("");
        numberField.setText("");
        addressField.setText("");
        displayAnimals.setText("");


}
}
   


    



 




