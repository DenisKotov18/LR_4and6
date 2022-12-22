package lr_4and6.models.application;

import java.io.Serializable;

public class Product implements Serializable {
    String name;
    double price;

    Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
