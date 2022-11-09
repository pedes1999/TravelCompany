
package repository;

import java.util.List;
import model.PersistentClass;

public interface Repository<T extends PersistentClass> {
    
    /**
     *
     * @param t
     * @return Creates an object T
     */
    int create(T t);

    /**
     *
     * @param id
     * @return object based on its id
     */
    T read(int id);

    /**
     *
     * @return the list of all objects
     */
    List<T> read();

    /**
     *
     * @param id
     * @return deletes an object based on id
     */
    boolean delete(int id);

}
