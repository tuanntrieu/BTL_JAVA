package MODEL;

public class Product {

    private String id;
    private String name;
    private double price;
    private String color;
    private int number;

    public Product() {
    }

    public Product(String id, String name, String color, double price, int number) {
        this.id = id;
        this.name = name;
        this.color=color;
        this.price = price;
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
