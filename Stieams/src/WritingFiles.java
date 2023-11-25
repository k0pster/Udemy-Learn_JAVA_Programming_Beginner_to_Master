import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingFiles {
    public static void main(String[] args) {
        try {
            //Metoda fileOutputStream możemy stworzyć plik. Musimy podać jako argument ściezkę, gdzie plik ma się
            //utworzyć, ale jako podzielnika używamy backslashy. Dodatkowow, klasa FileOutputStream
            //wymaga, aby wyłapać wyjątek nie istnienia pliku, wieć musi byc umieszczona w blokach try/catch.

            FileOutputStream fos = new FileOutputStream("C:/Users/mikopec/Desktop/JAVA/Własne/Stieams/Test.txt");
            //Tworzymy stringa z zawartością tekstu jaki ma sie znaleźć w pliku
            String str="Java Stream Learning";
            //Przykład tworzenia szkieletu pliku .xml
            //String str="<?xml version=\"1.0\" encoding=\"UTF-8\"?><list><codeTable><action></action><customer></customer><name></name><lookupRoutes/><lookupParts/><lookupQualifiers/><resultQualifiers/><matchStrategy/><resultStatus></resultStatus><mappings><mapping><flagLookupValues/><refLookupValues/><noteLookupValues/><dateLookupValues/><meaLookupValues/><qtyLookupValues/><moneyLookupValues/><flagResultValues/><refResultValues/><noteResultValues/><dateResultValues/><meaResultValues/><qtyResultValues/><moneyResultValues/><lookupRoutes/><lookupParts/></mapping></mappings></codeTable></list>";
            //metodą write(byte[] b) można wpisać do pliku tablice(array) bytów.
            //Z uwagi na to, że string nie jest tablicą, musimy ją przekonwertować do takiego stanu, używająć
            //metody klasy String .getBytes() którą w efekcie otrzymamym tablicę znaków naszego stringa.
            //Dodatowo klasa write() wymaga od nas złapania wyjątku IOException.
            fos.write(str.getBytes());
            //Po wykonaniu operacji staramy się zamykać stream
            fos.close();

            //Drugą metoą jest stworzenie zmiennej byte array bytes ze stringa i wykorzystanie metody write() ale po bajcie

            //Tworzymy nowa sciezke do pliku
            FileOutputStream fos2 = new FileOutputStream("C:/Users/mikopec/Desktop/JAVA/Własne/Stieams/Test2.txt");
            //deklarujemy zmienną byte array ze stringa.
            byte b[] = str.getBytes();
            //i pętlą for zszcytujemy wszystkie bajty
            for(byte x:b)
                fos2.write(x);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}