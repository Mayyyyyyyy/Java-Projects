package DishUtils;
public class Dish {
    int id;
    String name;
    double price;

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    
    public Dish(int id, String name, double price) {
      this.id = id;
      this.name = name;
      this.price = price;
    }
}
