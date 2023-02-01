import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args)
    {
        //deklaracja zmiennych funkcji kwadrtowej postaci ax2+bx+c=0 oraz miejsc zerowych
        double a,b,c,x1,x2;

        //Pobranie zmiennych funkcji kwadratowej od użytkownika z klawiatury
        Scanner sc = new Scanner(System.in);

        //Wyświetlenie prośby o podanie danych od usera
        System.out.println("Enter a,b,c values of Quadratic function");
        System.out.println("Enter a:");
        a = sc.nextDouble();
        System.out.println("Enter b:");
        b = sc.nextDouble();
        System.out.println("Enter c:");
        c = sc.nextDouble();

        //wykonanie obliczeń
        x1 = (-b+Math.sqrt(b*b-4*a*c))/(2*a);
        x2 = (-b-Math.sqrt(b*b-4*a*c))/(2*a);
        System.out.println("Miejsca zerowe fukcji to x1:"+x1+" oraz x2:"+x2);
    }
}