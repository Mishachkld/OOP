package Lab7.Interface;

import java.util.List;

public interface IRepository<T> {

    void add(T item);
    void update(T item);
    void delete(T item);
    List<T> get(Integer where, Integer orderBy);

}
