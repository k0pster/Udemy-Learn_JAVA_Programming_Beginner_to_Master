
//Program działający jak stos wartości, z wyjątkami kontrolującymi ograniczenia kiedy
//stos jes pełny i pusty. [stackOveflowExceprtion, stackUnderFlowException]

//Tworzę własne klasy rozrzeszone z Exception
class StackOverFlowException extends Exception
{
    public String toString()
    {
        return "Stack is Full";
    }
}
class StackUnderFlowException extends Exception
{
    public String toString()
    {
            return "Stack is Empty";
    }
}
class Stack
{
    //definiuje zmienne rozmiaru stosu, ustalam pozycję stosu na pusty, oraz deklaruje listę Stosu na zmienne int.
    private int stackSize; //rozmiar stosu
    private int stackTop = -1; //stos jest pusty, pozycja mniejsza niż 0
    private int Stack[];//lista int na zmienne w stosie

    //Tworzę konstruktor stosu o rozmiarze przekazanym argumentem. Konstruktor tworzony jest identyczną nazwą
    //jej klasy oraz przedrostkiem dostępu. Argument size przekazywany jest do zmiennej odpowiadającej
    //rozmiarowi stosu[stackSize], za jego pomocą tworzę dla tego rozmiaru listę o takim rozmiarze.
    public Stack(int size)
    {
        stackSize = size;
        Stack= new int[size];
    }

    //Tworzę metody push oraz pop z uwględnieniem wyjątków przepełnienia stosu
    //metoda push wprowadza kolejne elementy do stosu dopóki stackTop nie osiągnie wartości granicznej [StackSize -1, ponieważ
    //numeracja zaczyna się od 0], wtedy stos powinien zwrócić błąd.
    public void push(int x) throws StackOverFlowException
    {
        if(stackTop==stackSize-1)
        {
            throw new StackOverFlowException();
        }
        stackTop++;
        Stack[stackTop]=x; //Stack[++stackTop]=x
    }
    //Tworzę metodę pop, która usuwa dany element ze stosu.Sprawdza i wyrzuca wyjątek w momencie kiedy pozycja
    //wierchołka stosu stackTop jest poniżej zera.
    public int pop() throws StackUnderFlowException
    {
        int x=-1; //tworzymy zmienną śledząca pozycję pustego stosu
        if (stackTop==-1)
        {
            throw new StackUnderFlowException();
        }
        x=Stack[stackTop];
        Stack[stackTop]=0;
        stackTop--;
        return x;
    }
    //metoda zwracająca pozycję stosu
    public int printStackTop()
    {
        return stackTop;
    }

    //metoda printująca wszytkie elementy w stosie
    public void printStack()
    {
        System.out.print("Stos: ");
        for (int i=0; i<Stack.length;i++)
        {
            System.out.print(Stack[i]+" ");
        }
        System.out.println();
    }
}


//w klasie Main musimy użyć bloku try catch, jeśli używamy metod, które coś przekazują używając throws.
public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        try
        {
            //dodaje pięć przykładowych wartości do listy metodą push
            stack.printStack();
            stack.push(1);
            System.out.println(stack.printStackTop());
            stack.printStack();
           stack.push(2);
            System.out.println(stack.printStackTop());
            stack.printStack();
           stack.push(3);
            System.out.println(stack.printStackTop());
            stack.printStack();
           stack.push(4);
            System.out.println(stack.printStackTop());
            stack.printStack();
           stack.push(5);
            System.out.println(stack.printStackTop());
            stack.printStack();

           //w momencie dodania 6tego przepełniającego Stack powinniśmy otrzymać wyjątek
            //stack.push(6);
            //sprawdzamy ograniczenie dolne stosu usuwając pięć wprowadzonych elementów
            stack.pop();
            stack.printStack();
            stack.pop();
            stack.printStack();
            stack.pop();
            stack.printStack();
            stack.pop();
            stack.printStack();
            stack.pop();
            System.out.println(stack.printStackTop());
            stack.printStack();
            //za 6tym wywołaniem otzrymujey wyjątek
            //stack.pop();

        }
        catch(StackOverFlowException s)
        {
            System.out.println(s);
        }
        catch(StackUnderFlowException s)
        {
            System.out.println(s);
        }
    }
}