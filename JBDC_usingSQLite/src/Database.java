//do testowania i odpytywania otwierać plik sqlite3.exe w konsoli.
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

import org.sqlite.JDBC;


public class Database {
    public static void main(String[] args) throws Exception{
        //włączamy sterownik
        Class.forName("org.sqlite.JDBC");
        // db parameters and create Connection
        Connection con= DriverManager.getConnection("jdbc:sqlite:C:/Users/mikopec/Desktop/JAVA/SQLite/univ.db");
        //create Statement
        Statement stm= con.createStatement();
        //create Result Set
        ResultSet rs=stm.executeQuery("select * from students");
        //pętlą while wyprintowujemy wszystkie wpisy w DB
        while(rs.next())
        {
            System.out.print(rs.getInt("roll")+" ");
            System.out.print(rs.getString("name")+" ");
            System.out.print(rs.getString("city")+" ");
            System.out.println(rs.getInt(4)+" ");
        }
        //możemy również tworzyć PreparedStatement i wykorzystywać input usera
        //w czasie działania programu. tutaj przykład wywołania z bazy danych
        //studentów o podanym numerze porządkowym. Za znak/parametr pobierany
        //umieszczamy znak zapytania.
        PreparedStatement pstm=con.prepareStatement("select * from students where deptno=?");
        //pobieramy int od użytkownika
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Dept.Number: ");
        //tworzymy zmienną z pobranej wartości
        int dno=sc.nextInt();
        //i wstawiamy do przygotowanego statementu
        pstm.setInt(1,dno);
        //wykonujemy query
        ResultSet prs=pstm.executeQuery();
        while(prs.next())
        {
            System.out.print(prs.getInt("roll")+" ");
            System.out.print(prs.getString("name")+" ");
            System.out.print(prs.getString("city")+" ");
            System.out.println(prs.getInt(4)+" ");
        }
        //W JBDC możemy używać wszystkich operacji DML
        //ważne że nie będzie można dodać(uruchomic programu jeszcze raz z uwagi na wyjątkowość
        //kluczy w bazie danych. Aby przećwiczyć jeszcze raz należałoby usunąć dodawane wiersze
        //po pierwszym uruchomieniu prgramu.Możemy wykonywać wszystkie operacje na DB.
        //np. dodawać wpisy za pomocą executeUpdate(url)
        stm.executeUpdate("insert into dept values(40,'CHR')");
        stm.executeUpdate("insert into dept values(50,'JPY')");
        //po tym w bazie danych univ.db do tabeli dept zostanie dodany wpis 40|CHR i 50|JPY
        //np.usuwać
        stm.executeUpdate("delete from dept where deptno=50");//tutaj zostanie tylko 40|CHR
        //np.aktualizować jednostkę pod nr 40 z CHR na CHEM
        stm.executeUpdate("update dept set dname='CHEM' where deptno=40");
        //np. wprowadzać do bazy wpisy bazujące na tym co wprowadzi użytkownik
        //z wykorzystaniem PreperedStatement() wstawiwajac 4 pobrane inputy jako wpis
        PreparedStatement pstm2=con.prepareStatement("insert into students values(?,?,?,?)");
        //pobieramy zmienne i przygotowujemy query
        Scanner sc2=new Scanner(System.in);
        System.out.println("Enter Student data:)");
        System.out.println("Enter rollnr:");
        int r=sc2.nextInt();
        System.out.println("Enter name:");
        String name=sc2.next();
        System.out.println("Enter city:");
        String city=sc2.next();
        System.out.println("Enter deptnr:");
        int dno2=sc2.nextInt();
        //wstatwiamy zmienne do odpowiedniego typu i kolumny

        pstm2.setInt(1,r);
        pstm2.setString(2,name);
        pstm2.setString(3,city);
        pstm2.setInt(4,dno2);
        //odpalamy query i w efekcie dodany zostanie kolejny wpis do tabeli students bazy danych univ
        pstm2.executeUpdate();

        //możemy również tworzyć całe tabele
        stm.executeUpdate("create Table Temp(a integer,b float)");
        //i usuwać całe tabele
        stm.executeUpdate("drop Table Temp");

        //po wszystkim zamykamy Statement i Connection
        stm.close();
        pstm.close();
        pstm2.close();
        con.close();
    }
}