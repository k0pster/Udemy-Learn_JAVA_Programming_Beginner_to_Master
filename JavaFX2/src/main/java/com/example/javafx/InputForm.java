package com.example.javafx;

//Aby używać javafm potrzeba jest importu poniższych
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.*;

import java.io.*;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.*;

//Aplikacja to przykład formularza wprowadzającego dane od usera,
//zapisujaca/odczytujaca dane z pliku txt.

//klasa klienta
class Customer
{
    //parametry obiektu
    private int custid;
    private String name;
    private String country;

    //konstruktor klasy
    public Customer(int c,String n,String co)
    {
        custid=c;
        name=n;
        country=co;
    }
    //gettery klasy
    public int getID()
    {
        return custid;
    }
    public String getName()
    {
        return name;
    }
    public String getCountry()
    {
        return country;
    }
    //settery klasy
    public void setCountry(String add)
    {
        country=add;
    }
}


//Aplikacja
public class InputForm extends Application {

    int count=0;
    //klasa start jest niezbędna
    @Override
    public void start(Stage stage) throws Exception {
        //Tworzę obiekt Hashmapy, który będzie przechowywał
        //wpisy klientów ich imie, kraj i numer
        HashMap<Integer,Customer> hm = new HashMap<>();
        //Ustalamy parametr czcionki z scene.text.*
        Font f = new Font("Times New Roman",20);

        //Najpierw tworzymy labele na pola do wprowadzania danych
        Label l1=new Label("Customer ID"); l1.setFont(f);
        Label l2=new Label("Name");l2.setFont(f);
        Label l3=new Label("Country");l3.setFont(f);

        //tworzymy comboBox oraz pola tekstowe dla tekstu
        ComboBox<Integer> cust=new ComboBox<>();
        cust.setStyle("-fx-font-size:20");
        TextField name=new TextField();
        TextField country=new TextField();
        //określenie parametrów pól tekstowych
        name.setPrefColumnCount(15);
        country.setPrefColumnCount(20);

        //Przyciski funkcyjne
        Button save= new Button("Save");
        Button create=new Button("Create");

        //tworzymy do nich akcje za pomocą wyrażenia lambda

        //przycisk create
        create.setOnAction(e->{
            //inkrementuje licznik klienta, pobiera itemy i dodaje
            //nowy
            ++count;
            cust.getItems().add(count);
            //po naciśnięciu create chce również ustawienia
            //wartości customerID na kolejny numer automatycznie
            //ustawiam za pomocą setValue()
            cust.setValue(count);
            //po wciśnięciu chciałbym wyczyścić pola tekstowe
            name.setText("");
            country.setText("");
        });

        //przycisk save
        save.setOnAction(e->{
            //potrzebuje zapisać dane do pliku i do Hashmapy.
            //Pobieram dane z customera i umieszczam go w Hashmapie metodą put()
            Customer c=new Customer(cust.getValue(),name.getText(),country.getText());
            hm.put(count,c);
            //zapisuje również w pliku
            try(PrintStream ps=new PrintStream(new FileOutputStream("Customer.txt")))
            {
                //pętlą for each przechodzę przez wszystkie wartości hashMapy hm
                //i pobieram każdą wartość Customer ID metodą getID()
                //następnie pobieram i wyświetlam również imie getName()
                //oraz kraj getCountry()
                for(Customer ct:hm.values())
                {
                    ps.println(ct.getID());
                    ps.println(ct.getName());
                    ps.println(ct.getCountry());
                }
            }
            catch(Exception ex){}
        });

        //boxy horyzontalne na umieszczenie pól
        HBox hb1 = new HBox();
        //wyśrodkowuje pole
        hb1.setAlignment(Pos.CENTER);
        HBox hb2 = new HBox();
        hb2.setAlignment(Pos.CENTER);
        HBox hb3 = new HBox();
        hb3.setAlignment(Pos.CENTER);
        HBox hb4 = new HBox();
        hb4.setAlignment(Pos.CENTER);
        hb1.getChildren().addAll(l1,cust);
        hb2.getChildren().addAll(l2,name);
        hb3.getChildren().addAll(l3,country);
        hb4.getChildren().addAll(create,save);

        //Box vertykalny gdzie umieszczam wystkie boxy horyzontalne
        VBox vb=new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(hb1,hb2, hb3,hb4);

        //tworzę scanner, który będzie odczytywał dane z pliku
        //umieszczał je w Hashmapie
        try(java.util.Scanner scan=new java.util.Scanner(new FileInputStream("Customer.txt")))
        {
            //Tworzę zmienne na wartości
            int c;
            String n;
            String cy;
            //dopóty dopóki jest następna linia pobieraj do zmiennych
            //wartości z pliku
            while(scan.hasNext())
            {
                c=scan.nextInt();
                n=scan.next();
                cy=scan.next();
                //i umieszczam w HashMapie
                hm.put(c, new Customer(c,n,cy));
                //sprawdzam czy customerId jest większy od licznika
                //żeby ilość taka pojawiła się rozwijanej liście
                //CustomerID
                if(c>count)count=c;
                cust.getItems().add(c); //dodaje bieżący licznik
            }
        }
        catch(Exception ex){}

        //po wybraniu z listy numeru klienta już istniejącego chciałbym
        //w textfieldach mieć wyświetlone jakie były wprowadzane dane
        cust.valueProperty().addListener(e->{
            //pobieram wartość id cały obiekt klienta
            int c=cust.getValue();
            Customer ct=hm.get(c);
            //następnie umieszczam setText odpowiedniego
            //klienta do textdieldu z imieniem
            name.setText(ct.getName());
            //to samo z polem kraju
            country.setText(ct.getCountry());
        });
        //ustalenie rozmiarów okienka
        Scene sc=new Scene(vb,500,500);
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        //odaplamy aplikacje
        launch(args);
    }
}