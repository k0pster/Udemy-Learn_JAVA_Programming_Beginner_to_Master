
    //Klasa jednarozwego/ograniczonego użytku, w której można utworzyć tylko jeden obiekt,
    //aby to uczynić w JAVA musimy:
    //tworzymy klasę "CoffeMachine", która ma prywatne zmienne, oraz prywatny konstruktor w którym ustalane są ilości płynów.
    //utworzenie więc obiektu poprzez CofeeMachine m0=new CofeeMachine() jest niemozliwe, poineważ dostęp do tej metody
    //jest prywatny. Aby było możliwe stworzenie obiektu musimy skorzystać z metody statycznej CofeeMachine GetInstance()
    //w której zwracamy referencje do obiektu my, którego deklarujemy jako zmienną statyczną prywatną w klasie i
    //ustawiamy ją na wartość null. Wtedy klasa może tworzyć tylko jeden i ten sam obiekt.

    class CofeeMachine {
        private float cofeeQuantity;
        private float waterQuantity;

        static private CofeeMachine my = null;

        private CofeeMachine() {
            cofeeQuantity = 1;
            waterQuantity = 1;
        }

        public void fillWater(float quantity) {
            waterQuantity = quantity;
        }

        public void fillCofee(float quantity) {
            cofeeQuantity = quantity;
        }

        public float getCofee() {
            return 0.2f;
        }

        static CofeeMachine GetInstance() {
            if (my == null) {
                my = new CofeeMachine();
            }
            return my;
        }

    }

    public class Singelton{
        public static void main(String[] args) {
            //CofeeMachine m0=new CofeeMachine(); //nie można tak utworzyć obiektu prywatnej metody.
            CofeeMachine m1=CofeeMachine.GetInstance();
            CofeeMachine m2=CofeeMachine.GetInstance();
            System.out.println(m1);
            System.out.println(m2);
            if (m1 == m2)
            {
                System.out.println("Same");
            }
        }
    }

