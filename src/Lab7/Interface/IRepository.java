package Lab7.Interface;

import java.util.List;

public interface IRepository<T> {

    void add(T item);
    void update(T oldItem, T newItem);
    void delete(T item);
    List<T> get(Integer where, Integer orderBy);

}
