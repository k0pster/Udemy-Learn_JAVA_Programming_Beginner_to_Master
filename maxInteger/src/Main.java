public class Main {
    public static void main(String[] args) {
        //Stworzenie metody która zwraca maksymalną liczbę typu int, uwzględniając możliwość nie deklarowania
        //ilości podawanych argumentów : lista dynamiczna

        System.out.println(maxInteger(15,23,42,56,123,1,5,-2,0));
    }

    //metoda z podaniem maksymalnej liczby z podanych, używając możliwości stworzenia
    //dynamicznej listy, dzieki utworzeniu z ilości podanych argutmentów listy danego typu
    //deklarując arkgument jako "int...nazwa" nie muszę deklarować od razu wielkości tablicy
    public static int maxInteger(int...numbers){
        int maxInt = numbers[0];
        for (int i=0;i< numbers.length;i++)
        {
            if(numbers[i]>maxInt){
                maxInt = numbers[i];
            }
        }
        //Wyświetlenie wszystkich elementów nową formą pętli foreach
        /*for (int number:numbers){
            System.out.print(number+",");
        }*/
        return maxInt;
    }
}