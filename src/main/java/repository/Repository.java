
package repository;

import java.util.List;
import model.PersistentClass;

public interface Repository<T extends PersistentClass> {
    
    //CRUD
    int create(T t);
    T read(int id);
    List<T> read();
    boolean delete(int id);

}
