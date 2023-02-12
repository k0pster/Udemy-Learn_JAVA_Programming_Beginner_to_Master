public class Product {
    //deklaruje prywatne zmienne dotyczące produktów
    private String itemNo;
    private String name;
    private double price;
    private int quantity;
    //deklaruje get-ery i setery
    public String getItemNo(){
        return itemNo;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setPrice(double _price){
        price = _price;
    }

    //Tworze konstruktor
    public Product(String _itemNo){
        itemNo = _itemNo;
        name = "article";
        price = 0.0;
        quantity = 0;
    }
    public Product(String _itemNo, String _name,double _price, int _quantity){
        itemNo = _itemNo;
        name = _name;
        price = _price;
        quantity = _quantity;
    }

    //Printuje obiekt
    public void ItemsList(){
        System.out.print("Barcode: "+this.itemNo+",");
        System.out.print("Product: "+this.name+",");
        System.out.print("Price: "+this.price+",");
        System.out.print("Quantity: "+this.quantity);
        System.out.println("");
    }
}
