
import java.net.*;
import java.io.*;
//Klasa aplikacji klienta
public class ReverseEchoServer {
    public static void main(String[] args) throws Exception
    {
        //Info o starcie servera
        System.out.println("Server running...");
        //Tworzę serwer na potrzeby komunikacji
        ServerSocket ss = new ServerSocket(2000);
        //metoda akceptująca połączenie accept()
        Socket stk=ss.accept();
        //dla steorzonego socketu połączenia potrzebujemy
        //utworzyć input jak i output stream
        //pobieramy do socketu inputstream metodą getInputStream()
        //przekazujemy do InputStreamReadera a następnie łączymy z BufferReaderem
        BufferedReader br=new BufferedReader(new InputStreamReader(stk.getInputStream()));
        //deklaruje obiekt printStream wczytuje getOutpudStream() socketu
        PrintStream ps=new PrintStream(stk.getOutputStream());
        //Tworze string z msg klienta i stringbuiilder do odwrócenia Stringa
        String msg;
        StringBuilder sb;

        do
        {
            //czytanie klienta
            msg=br.readLine();
            //odwrócenie warotści String za pomoca stringBuildera
            sb=new StringBuilder(msg);
            sb.reverse();
            //konwersja do stringa
            msg=sb.toString();
            //print wartości
            ps.println(msg);
        }while(!msg.equals("dne"));

    }
}

//Klasa aplikacji po stronie klienta
class Client {
    public static void main(String[] args) throws Exception
    {
        //Tworzę socket na potrzeby komunikacji podajac port i ip(localhost jako maszyna ta(or ip from cmd ipconfig/ethernetIPv4).
        Socket stk = new Socket("localhost",2000); ////10.44.243.114

        //zczytanie klawiatury do buffered readera
        BufferedReader keyb=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br=new BufferedReader(new InputStreamReader(stk.getInputStream()));
        //deklaruje obiekt printStream wczytuje getOutpudStream() socketu
        PrintStream ps=new PrintStream(stk.getOutputStream());
        //Tworze string z msg klienta i stringbuiilder do odwrócenia Stringa
        String msg;
        do
        {
            //wysłanie msg do servera
            msg=keyb.readLine();
            //print wartości którą wysyłamy na server
            ps.println(msg);
            //zczytujemy odwróconą odpowiedź serwera
            msg=br.readLine();
            //print msg
            System.out.println("Response From Server : "+msg);
        }while(!msg.equals("dne"));
        //zamykamy socket zawsze po skończeniu operacji na nim!
        stk.close();
    }
}

//Teraz można przetestować aplikację budując projekt wchodząc do folderu z klasami
//...Networking\out\production\Networking następnie odpalamy w dwóch osobnych
//cmd-ach klienta(Client) oraz server(ReverseEchoServer) [java Client i Java ReverseEchoServer]
//Teraz możemy testować poprzed cmd line klienta wysyłać wiadomość
//i będziemy odbierać odwróconą od serwera do momentu aż nie napiszemy end
//który zamyka połącznie