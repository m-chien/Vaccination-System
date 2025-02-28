package phantichtkhdt.tiemchung;

import java.util.List;

public interface IGenericRepository<T> {
    void add(T entity);
    void remove(T entity);
    List<T> getAll();
    T getUser();
}
