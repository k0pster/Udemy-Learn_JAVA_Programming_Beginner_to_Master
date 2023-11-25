import java.io.*;

public class BufferedFile {
    //W pracy na streamach możemy zamaiast łapać wszystkie możliwe wyjątki po kolei skorzystać z throws Exception
    //Buffer pozwala na zaznczanie bajtów i powrót do nich, czego nie pozwala filereader
    //Aby to wykonac potrzebujemy przechwicic plik FileInputStream utworzyć z niego BufferedInputStream
    //następnie możemy czytać bajt po bajcie pliku i nawet cofać się jak przeglądamy filmiki
    //z internetu. To samo działa identycznie do FileReader i BufferedReader
    public static void main(String[] args) throws Exception
    {
        //Czytamy plik
        FileInputStream fis = new FileInputStream("C:/Users/mikopec/Desktop/JAVA/Własne/Stieams/Test.txt");
        //czytamy plik do bufferu
        BufferedInputStream bis = new BufferedInputStream(fis);
            //sprawdzamy printując litera po literze i nawet możemy się cofać poprzez kombinację
            //metod mark() i reset() czyli powrotu do oznaczyonyego bytu.
        System.out.print((char)bis.read()); //drukujemy J
        System.out.print((char)bis.read()); //drukujemy a
        System.out.print((char)bis.read()); //drukujemy v
        System.out.print((char)bis.read()); //drukujemy a
        System.out.print((char)bis.read()); //drukujemy odstep
        bis.mark(10); //zaznaczamy bajt z odstepem i zapamiętujemy na readlimit podany czyli 10 znaków do przodu.
        //po tym czasie jeśli nie wystąpi reset() znak przestanie byc pamiętany
        System.out.print((char)bis.read()); //drukujemy S
        System.out.print((char)bis.read()); //drukujemy t
        System.out.print((char)bis.read()); //drukujemy r
        System.out.print((char)bis.read()); //drukujemy e
        System.out.print((char)bis.read()); //drukujemy a
        System.out.print((char)bis.read()); //drukujemy m
        bis.reset();//wracamy do znaku odstepu i
        System.out.print((char)bis.read()); //drukujemy S
        System.out.print((char)bis.read()); //drukujemy t
        System.out.print((char)bis.read()); //drukujemy r
        System.out.print((char)bis.read()); //drukujemy e
        System.out.print((char)bis.read()); //drukujemy a
        System.out.print((char)bis.read()); //drukujemy m ponownie

            fis.close();
        }
    }