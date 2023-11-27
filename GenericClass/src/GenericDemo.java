//Klasy/obiekty generyczne czyli takie, które moga przechowywać listę obiektów o każdym typie
//bez konieczności typowania lub kastowania ich rodzaju. Jest to swego rodzaju szkielet listy
//dla obiektów o różnych typach
@SuppressWarnings("uncheked")
//Towrzymy klasę generic poprzez dodanie <T> która jest templatką dla tworzenia obiektów o każdym typie
class Data<T>
{
    //wpsarcie dla każdego typu obiektu
    private T obj;
    //geter i setter dla templatowej defaultowej klasy
    public void setData(T v)
    {
        obj=v;
    }
    public T getData()
    {
        return obj;
    }

    //Klasa pozwalająca na przechoywanie obiektów różych typów
    static class MyArray<T>
    {
        T A[]=(T[]) new Object[10];
        //umieszczć obiekt w liście będziemy za pomocą metody append,
        //zaczniemy od sprawdzenia długości obiektu
        int length= 0;
        public void append(T v)
        {
            A[length++]=v;
        }
        //metoda również wyświetlania obiektów w liście
        public void display()
        {
            for (int i = 0; i <length; i++)
            {
                System.out.println(A[i]);
            }
        }
    }

    public static void main(String[] args) {
        //tworzyć obiekty możemy poprzed podanie typu danych
        //Data<Integer> d=new Data<>();
       // d.setData(10);
        //System.out.println(d.getData());
        //teraz mozemy stworzyc liste nie deklarujac rodzaju przechowywanych obiektów
        //następnie wprowadzać obiekty o różnych typach
        MyArray ma=new MyArray<>();
        ma.append(new Integer(10));
        ma.append("Hi");
        ma.append(30);
        ma.display();
    }
}