import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Program zliczający ilość słów we wporawdznym tekscie.

        //Deklaracja skanera.
        Scanner sc = new Scanner(System.in);

        //Prośba o wprowadzenie tekstu i zczytanie go z klawiatury.
        System.out.println("Enter the text:");
        String text = sc.nextLine();

        //Zniwelowanie odstępów większych niż o jedno miejsce metodą replaceAll.
        //Kilka białych znaków zamieniam na jeden biały znak. Następnie metodą trim,
        //usuwam odstępy na początku i koncu Stringa. Następnie tworze pustą listę
        //String i umieszczam w niej odstępy
        text = text.replaceAll("\\s+"," ").trim();
        String blankSpaces[] = text.split("\\s");
        System.out.println("Text have "+blankSpaces.length+" word(s).");
    }
}