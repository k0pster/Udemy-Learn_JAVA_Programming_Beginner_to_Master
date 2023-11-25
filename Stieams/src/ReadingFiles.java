import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadingFiles {
    //W pracy na streamach możemy zamaiast łapać wszystkie możliwe wyjątki po kolei skorzystać z throws Exception
    //W tym przydapku skorzystam z tego rozwiązania
    public static void main(String[] args) throws Exception
    {
        try (FileInputStream fis = new FileInputStream("C:/Users/mikopec/Desktop/JAVA/Własne/Stieams/Test.txt"))
        {
            //aby utworzyć nową tablicę bytów w argumentcie new byte potrzebuje podać wilekość bytów
            //jak dużą tablice potrzebuje. Do tego celu wykorzystamy metodę .available() która
            //pokazuje wielkość pliku.
            byte b[]=new byte[fis.available()];
            //read(byte[])
            fis.read(b);
            //konwertujemy do stringa
            String str=new String(b);
            //printujemy w porgramie
            System.out.println(str);

            fis.close();
        }
        //Następtną metoda jest zczytuwanie znak po znaku z pliku pętlą do while
        try (FileInputStream fis2 = new FileInputStream("C:/Users/mikopec/Desktop/JAVA/Własne/Stieams/Test2.txt"))
        {
          int x;
          //pętle wykonujemy do póki nie znak nie zwróci wartości -1 a taki zwraca konie pliku, czyli brak nastepnego bajtu
            //efekt taki sam
            while((x=fis2.read())!=-1)
            {
                System.out.print((char)x);
            }
            fis2.close();
        }
    }
}