import java.net.*;

//Aby wysyłać pakiety poprzez UDP zamiast TCIP używamy Datagramów

//Klasa aplikacji Server
public class DatagramClient
{
    public static void main(String[] args) throws Exception
    {
        //Tworzę Server Datagram Socket na porcie 2001
        DatagramSocket ds= new DatagramSocket(2001);
        //Tworzę jakąś wiadomość
        String msg="Hello World";
        //Tworzę odbiornik DatagramPacket() jako argumenty należy przekazać:
        //-długość bytów - użyje tutaj metody getBytes(),
        //-długość danych - wykorzystam metodę getLength(),
        //-adres IP - korzystam z InetAddress.getByName(),
        //-port nr - wpisuje numer portu servera
        DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.length(), InetAddress.getByName("localhost"),2000);
        //sklient wysyła pakiet
        ds.send(dp);
        //aby otrzymał pakiet z powrotem
        byte b[]=new byte[1024];
        dp=new DatagramPacket(b,1024);
        //i klient odbiera pakiet
        ds.receive(dp);
        msg=new String(dp.getData()).trim();
        System.out.println("From server "+msg);
        ds.close();
    }
}

class UdpTypeServer{

    public static void main(String[] args) throws Exception
    {
        //Tworzę Server Datagram Socket
        DatagramSocket ds= new DatagramSocket(2000);
        //Najpierw server musi odebrać pakiet
        byte b[]=new byte[1024];
        DatagramPacket dp=new DatagramPacket(b,1024);
        ds.receive(dp);

        String msg=new String(dp.getData()).trim();
        System.out.println("From Client "+msg);
        StringBuilder sb=new StringBuilder(msg);
        sb.reverse();
        msg=sb.toString();
        //Tworzę odbiornik DatagramPacket() jako argumenty należy przekazać:
        //-długość bytów - użyje tutaj metody getBytes(),
        //-długość danych - wykorzystam metodę getLength(),
        //-adres IP - korzystam z InetAddress.getByName(),
        //-port nr - wpisuje numer portu klienta
        dp=new DatagramPacket(msg.getBytes(),msg.length(), InetAddress.getByName("localhost"),2001);
        ds.send(dp);
        ds.close();
    }
}

//Teraz można przetestować aplikację budując projekt wchodząc do folderu z klasami
//...Networking\out\production\Networking następnie odpalamy w cmd server(UdpTypeServer) [java UdpTypeServer]
//następnie uruchamiamy Clienta(DatagramClient) w InteliJ i testujemy
//W InteliJ powinniśmy otrzmyać msg od servera odwrócowny "From server dlroW olleH
//a na serverze powinniśmy otrzymać msg string od klienta "From Client Hello World"