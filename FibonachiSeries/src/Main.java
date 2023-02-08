import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long a = 0, b = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many n steps of Fibonnaci you want to see:");
        int n = sc.nextInt();
        //Wyświetlam dwa pierwsze wyrazy ciągu fibonaciego
        System.out.print(a+ ","+b+",");
        //petlą for dokonuje sumy a i b w zmiennej c oraz zamieniam miejscami a i b po tym,
        //jak wyprintuję zmienną c.
        for (int i = 0; i < n - 2; i++)
        {
            long c = a+b;
            System.out.print(c+",");
            a = b;
            b = c;
        }
        sc.close();
    }
}