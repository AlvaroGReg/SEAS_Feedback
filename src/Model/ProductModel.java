package Model;

/**
 *
 * @author alvar
 */
public class ProductModel {
    private int id;
    private String name;
    private double price;

    public ProductModel(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public ProductModel(String name, double price) {
        this.name = name;
        this.price = price;
    }    

    public int getId() {
        return id;
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
}