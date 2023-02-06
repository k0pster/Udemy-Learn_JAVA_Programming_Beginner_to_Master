import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Program ma być prostym kalkulatorem dwóch liczb z wykorzystaniem
        //Menu "switch".

        //Tworze zmienne przechowywujące pobrane liczby.
        double numberOne;
        double numberTwo;
        String operation;
        //Wywołuje metodę wyświetlająca menu oraz proszę o dwie liczby.
        Scanner sc = new Scanner(System.in);
        displayMenu();
        System.out.println("Provide first number:");
        numberOne = sc.nextDouble();
        System.out.println("Provide second number:");
        numberTwo = sc.nextDouble();
        System.out.println("Choose method by typing the operation");
        operation = sc.next().toUpperCase();
        //metodą switch tworze odniesienie do przycisków z wyśiwetlanego menu;
        switch(operation) {
            case "ADD":
                System.out.println("Sum is "+(numberOne+numberTwo));
                break;
            case "SUB":
                System.out.println("Diffrence is "+(numberOne-numberTwo));
                break;
            case "DIV":
                System.out.println("Product is "+(numberOne/numberTwo));
                break;
            case "MUL":
                System.out.println("Ratio is "+(numberOne*numberTwo));
                break;
            default:
                System.out.println("You typed wrong operation");
                break;
        }
    }
    //metoda odpowiadająca za wyswietlanie menu
    private static void displayMenu(){
        System.out.println("Calculator \nMENU:");
        System.out.println("ADD");
        System.out.println("SUB");
        System.out.println("DIV");
        System.out.println("MUL");
    }
}