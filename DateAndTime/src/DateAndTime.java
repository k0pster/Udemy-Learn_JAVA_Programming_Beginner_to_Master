import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Date;
import java.time.*;

public class DateAndTime {
    public static void main(String[] args)
    {
        //Gregoric calendar, timezones
        GregorianCalendar gc = new GregorianCalendar();
        TimeZone tz= gc.getTimeZone();
        System.out.println(tz.getID());
        //Date z java.util.Date to stary typ danych liczyon od 1.1.1970 w milisekundach.
        //Jest on modyfikowalny
        Date d = new Date();
        System.out.println(d);
        //mogę edytować sobie np godzine
        d.setHours(21);
        System.out.println(d); // bedzie 21

        //teraz stworzmy obiekt LocalDate, która nie bedzie edytowalna i liczona w sekundahc od 1.1.1970
        LocalDate dt=LocalDate.now();
        System.out.println(dt);
        LocalDate dtmodified = dt.plusDays(10);
        System.out.println(dtmodified); //nie zmienia się dtmodified pokazuje czas taki jak dt

        //metoda LocalDateTime łaczy Time i Date
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
    }
}