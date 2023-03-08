public class ThrowTrowsDemo {
    //słówko throws wskazuje, że metoda jest przygotowana na przekazywanie
    //wyjątków np. w przypadku kiedy chcemy dzielić liczbę przez 0.
    //Jeśli np. metoda area wyrzuca wyjątek kiedy jeden z jej argumentów,
    //jest mniejszy od 0, nastepnie metoda ta jest wywoływana w innej metodzie
    //meth1 zadeklarowanej z argumantami i dopiero metoda meth1 jest wywoływana
    //w mainie to każda z metod musi mieć dopisek "throws Exception"
    //kompilacja takiego wywołania wyrzuć wyjątek z błedem w każdej metodzie:
    //Exception in thread "main" java.lang.Exception
    //	at ThrowTrowsDemo.area(ThrowTrowsDemo.java:18)
    //	at ThrowTrowsDemo.meth1(ThrowTrowsDemo.java:23)
    //	at ThrowTrowsDemo.main(ThrowTrowsDemo.java:28)
    // musimy więc "złapać" ten wyjątek w docelowj metodzie main przez blok try/catch
    // dzięki temu przechwytujemy wyjątek tylko w docelowo wywołanej metodzie main
    static int area(int l, int b) throws Exception
    {
        if(l<0 || b<0)
            throw new Exception();
        return l*b;
    }
    static void meth1() throws Exception
    {
        System.out.println("Area is "+area(-10,5));
    }
    public static void main(String[] args) throws Exception
    {
        try{
            meth1(); //przechwytujemy wyjątek umieszczając wywołania w bloku try/catch
        }
        catch(Exception e)
        {
           System.out.println(e);
        }
    }
}
