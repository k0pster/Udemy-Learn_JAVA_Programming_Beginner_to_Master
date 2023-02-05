import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Program sprawdzający czy podany rok jest rokiem przestepnym.

        //Deklaracja zmiennej przechowującej rok i scannera poboru zmiennej z klawiatury.
        int year;
        Scanner sc = new Scanner(System.in);
        //Prośba o podanie roku.
        System.out.println("Enter the year to check:");
        year = sc.nextInt();
        //Logika sprawdzenia czy rok jest przestępny:
        if (year%4==0) {
            if(year%100==0) {
                if(year%400==0) {
                    displayLeapYear(year);
                }
                else {
                    displayNotLeapYear(year);
                }
            }
           else {
                displayNotLeapYear(year);
            }
        }
        else
        {
            displayNotLeapYear(year);
        }
    }
    //Metody printujące odpowiedź czy rok jest przestępny
    public static void displayLeapYear(int year) {
        System.out.println("Year "+year+" is leap year!");
    };
    public static void displayNotLeapYear(int year) {
        System.out.println("Year "+year+" is not leap year!");
    };
}