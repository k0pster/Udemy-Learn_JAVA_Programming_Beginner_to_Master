class ThrowExceptionByClass {
    //możemy też użyć własnej klasy Wyjątków, żeby w przypadku przechwycenia,
    //określonego wyjątku w metodzie wykonać określone działania
    //np. stowrzyć własny print do usera

    //tworzę klasę NegativeDimensionException, która zastąpi wyjątek
    static class NegativeDimensionException extends Exception
    {
        public String toString(){
            return "Dimensions cannot be negative!";
        }
    }
    //przekazuje ją jako Exception
    static int area(int l, int b) throws NegativeDimensionException {
        if (l < 0 || b < 0)
            throw new NegativeDimensionException();
        return l * b;
    }
    //również w następnej metodzie
    static void meth1() throws NegativeDimensionException {
        System.out.println("Area is " + area(-10, 5));
    }

    // w głównym wywołaniu nie przekazujemy wyjątku Throws-em,
    //ponieważ tutaj łapiemy wyjątek metodą catch i używając własnej klasy
    //która nadpisuje klasę Exception i printuje nas string zamiast defaultowego
    public static void main(String[] args) {
        try {
            meth1();
        } catch (NegativeDimensionException e) {
            System.out.println(e);
        }
    }
}


