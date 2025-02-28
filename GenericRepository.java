package phantichtkhdt.tiemchung;

import java.util.ArrayList;
import java.util.List;

public class GenericRepository<T> implements IGenericRepository<T> {
    List<T> entities = new ArrayList<>();

    @Override
    public void add(T entity) {
        entities.add(entity);
    }

    @Override
    public void remove(T entity) {
        entities.remove(entity);
    }

    @Override
    public List<T> getAll() {
        return entities;
    }

    @Override
    public T getUser() {
        return entities.getLast();
    }
}
