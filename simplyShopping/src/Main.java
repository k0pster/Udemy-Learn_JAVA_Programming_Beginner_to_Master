public class Main {
    public static void main(String[] args)
    //Program symulujący proste zakupy
    {
        System.out.println("Product added to shop:");
        Product item1 = new Product("AZ-00001-123234","Serek Jogobella",4.10,1000);
        Product item2 = new Product("AZ-00012-999999","Banan Polski",5.12,50);
        Product item3 = new Product("AZ-13134-999999","Golarka",133.12,10);

        //wyświetlenie produktów

        item1.ItemsList();
        item2.ItemsList();
        item3.ItemsList();
    }}
