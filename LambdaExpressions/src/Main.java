//lambda upraszcza nadpisanie metody występującej w jakimś funkcjonalynm interfejsie(interfejjs posiadający tylko jedną metodę)
@FunctionalInterface
interface MyLambda
{
    public void display();
}

@FunctionalInterface
interface MyLambda2
{
    public int addInts(int x,int y);
}
public class Main {
    public static void main(String[] args) {
        MyLambda m = new MyLambda() {
            public void display(){
                System.out.println("Nadpisana metoda");
            }
        };
        m.display();

        //Można przyspieszyć proces nadpisania tej metody poprzez zastosowanie samego wyrażenia Labmbda
        //bez konieczności deklarowania metody(nadpisania jej) oraz bez konieczności inizjalizowania nowego obiektu
        MyLambda n = () -> {System.out.println("Nadpisana metoda n");};
        n.display();

        //W wyrażeniach lambda możemy też przesyłać wartości do metod
        MyLambda2 added = (a,b)->a+b; //nie potrzeba nawet słówka 'return'
        System.out.println(added.addInts(20,30));
    }
}