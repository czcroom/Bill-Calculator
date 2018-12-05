/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billcalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author clayvonc
 */
public class BillCalculator extends Application {
            
    private Label menuP;
    private Label discount;
    private Label tip;
    private Label totalBill;
    private TextField menuPriceField;
    private TextField discountField;
    private TextField tipField;
    private TextField totalBillField;
    private Button submitButton =   new Button("Submit");;
    private Button resetButton = new Button("Reset");;
    
    @Override
    public void start(Stage primaryStage) {
      
    GridPane root = new GridPane();
     
        
    menuP = new Label("Menu Price: ");
    discount = new Label("Discount %:");
    tip = new Label("Tip %:");
    totalBill = new Label("Total Bill: ");
        
    menuPriceField = new TextField();
    menuPriceField.setPrefColumnCount(15);
    menuPriceField.setEditable(true);
    menuPriceField.setText("0");
        
    discountField = new TextField();
    discountField.setPrefColumnCount(15);
    discountField.setEditable(true);
    discountField.setText("0");
        
    tipField = new TextField();
    tipField.setPrefColumnCount(15);
    tipField.setEditable(true);
    tipField.setText("0");
        
    totalBillField = new TextField();
    totalBillField.setPrefColumnCount(15);
    totalBillField.setEditable(false);
        
    root.setPadding( new Insets( 10, 10, 10, 10));
    root.setHgap(10);
    root.setVgap(10);
    root.add(menuP, 0, 0);
    root.add(menuPriceField, 1, 0);
    root.add(discount, 0, 1);
    root.add(discountField, 1, 1);
    root.add(tip, 0,2 );
    root.add(tipField, 1,2);
    root.add(totalBill, 0, 3);
    root.add(totalBillField, 1, 3);
    root.add(resetButton, 0, 4);
    root.add(submitButton,1 ,4);
        
    submitButton.setOnAction(new EventHandler<ActionEvent>() {
         
    @Override
    public void handle(ActionEvent event) {
        String userInput = " ";
        double menuPrice = 0.0;
        double discountPercentage = 0.0;
        double tipPercentage= 0.0;
        double totalBill = 0.0;
                
        try{
                    
        userInput = menuPriceField.getText(); //Get user's wage input
        menuPrice  = Double.parseDouble(userInput);
                    
        userInput = discountField.getText();
        discountPercentage = Double.parseDouble(userInput);
                    
        userInput = tipField.getText();
        tipPercentage = Double.parseDouble(userInput);
                    
        totalBill = menuPrice *((100- discountPercentage)/100) * ((100+tipPercentage)/100);
                    
        if(menuPrice >= 0 && discountPercentage >- 0 && tipPercentage >- 100){ //Displays the calculated salary
            totalBillField.setText(Double.toString(totalBill));
        }
        else{
            
        Alert alert = new Alert(AlertType.ERROR, "Enter a Postive value");
        alert.showAndWait();
        
        }
        
        }catch (java.lang.NumberFormatException e){
            Alert alert = new Alert(AlertType.ERROR, "Enter a number!!");
            alert.showAndWait();
            }
               return;
               
            }
        });
        
        resetButton.setOnAction(new EventHandler<ActionEvent>(){
        
            @Override
           public void handle(ActionEvent event){
               menuPriceField.clear();
               discountField.clear();
               tipField.clear();
               totalBillField.clear();
               
           }
     
        });  
        
        
        Scene scene = new Scene(root, 300, 250);
        
       primaryStage.setTitle("Bill Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        return;
         
    }
    
}
