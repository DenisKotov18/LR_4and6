package lr_4and6.models.application;

import java.io.Serializable;
import java.util.ArrayList;

public interface Memento extends Serializable {
     void save(Order order);

     void load(Memento memento);
}
