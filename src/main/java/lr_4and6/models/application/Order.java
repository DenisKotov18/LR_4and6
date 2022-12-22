package lr_4and6.models.application;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable, Memento {
    ArrayList<Product> products;
    Integer price;

    public Order(){
        products = new ArrayList<>();
        price = 0;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public void save(Order order) {
        this.price = order.price;
        this.products = order.products;
    }

    @Override
    public void load(Memento memento) {
        this.products = ((Order) memento).products;
        this.price = ((Order) memento).price;
    }

    public void addApple(){
        products.add(new Product("Яблоко", 1));
        this.price +=1;
    }
    public void addCake(){
        products.add(new Product("Тортик", 5));
        this.price +=5;
    }

    public void addTea(){
        products.add(new Product("Чай", 3));
        this.price +=3;
    }

    public void addCoffee(){
        products.add(new Product("Кофе", 3));
        this.price +=3;
    }
}
