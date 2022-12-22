package lr_4and6.models.application;

import lr_4and6.models.database.MySerialize;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable, Observer {
    private static User online = null;
    private String login;
    private String password;
    private ArrayList<Order> orders;
    private Order last_order;
    private Memento snapshot;

    User(){}

    public User(String login, String password){
        this.login = login;
        this.password = password;
        orders = new ArrayList<>();
        snapshot = new Order();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public void handleEvent() {
        save();
    }

    private static void save(){
        MySerialize.writeUsers(App.users);
    }

    public Memento getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(Memento snapshot) {
        this.snapshot = snapshot;
    }

    public static User getOnline() {
        return online;
    }

    public static void setOnline(User online) {
        User.online = online;
    }

    public void setLast_order(Order last_order) {
        this.last_order = last_order;
    }

    public Order getLast_order() {
        return last_order;
    }

    public static void revertOrder(){
        online.last_order.load(online.snapshot);
    }

    public static void saveOrder(){
        online.snapshot.save(online.last_order);
    }

    public void saveOrderToList(){
        orders.add(last_order);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
