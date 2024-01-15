package com.example.javafx;

//Aby używać javafm potrzeba jest importu poniższych
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.IOException;

//klasa aplikacji musi być rozszerzona od Application
public class HelloApplication extends Application implements EventHandler<ActionEvent> {
    //Tworzymy coutner do przetestowania EventHandler<ActionEvent>
    int count=0;
    //inicjalizujemy przycisk
    Button btn;
    //klasa start jest niezbędna
    @Override
    public void start(Stage stage) throws Exception {
        //tworzymy przycisk
        btn=new Button("Click me!");
        //Możemy zmieniać kolor czcionki na przycisku
        btn.setTextFill(Color.BLUE);
        //a nawet stylować go jak chcemy (CSS)
        //btn.setStyle("-fx-border-color:red;-fx-background-color:grey");
        //Dodawać opis po najechaniu myszą za pomocą Tooltip()
        Tooltip tp=new Tooltip("Click this button to save");
        //ustawiamy Tooltip na przycisk metodą setTooltip()
        btn.setTooltip(tp);
        //możemy na buttonie ustawiać Alerty za pomocą metody setOnAction()
        //Alert a = new Alert(Alert.AlertType.INFORMATION,"Button is cliked");
        //btn.setOnAction(e->a.show());
        //albo eventy które mają się wykonać po kliknięciu przekazane za
        //pomocą this
        //btn.setOnAction(this);
        //albo lambda expresion
        btn.setOnAction(e->{count++;btn.setText(""+count);});

        FlowPane fp = new FlowPane();
        fp.getChildren().add(btn);
        //umieszczamy go w oknie czyli stage-u o rozmiarach
        Scene sc= new Scene(fp,400,400);
        //umieszczamy scene na stageu metodą getScene()
        stage.setScene(sc);
        //uruchamiamy przedstawienie metodą show()
        stage.show();
    }
    //klasa handle to handler Eventów wymagana po implementacji EventHandler<ActionEvent>
    //w głównej klasie aplikacji. To instrukcja co ma się wykonać
    //po nacisnięciu przycisku
    public void handle(ActionEvent ae)
    {
        //prosty counter dla testów wymaga utworzenia w klasie startowej
        //zmiennej int count;
        count++;
        btn.setText(""+count);
    }
    public static void main(String[] args) {
        //lauch() służy do odpalenia aplikacji
        launch(args);
    }
}