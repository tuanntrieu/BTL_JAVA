package MODEL;

public class Mobile extends Product {

    private String brand;
    private int memory;
    public Mobile(){}

    public Mobile(String brand, int memory, String id, String name, String color, double price, int number) {
        super(id, name, color, price, number);
        this.brand = brand;
        this.memory = memory;
    }


  

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    
    
}
