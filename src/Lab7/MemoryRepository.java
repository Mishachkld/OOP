package Lab7;

import Lab7.Interface.IRepository;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepository<T> implements IRepository<T> {
    private final List<T> elements;

    public List<T> getElements() {
        return elements;
    }

    public MemoryRepository(){
        elements = new ArrayList<>();
    }

    @Override
    public void add(T item) {
        elements.add(item);
    }

    @Override
    public void update(T item) {
        /// как я должен обновлять элемент, не зная какой он был изначально?
        /// куда мне его обновлять
    }

    @Override
    public void delete(T item) {
        if (elements.contains(item)) {
            elements.remove(item);
        }
    }

    @Override
    public List<T> get(Integer where, Integer orderBy) { // насколько я понял, возвращает срез массива от where до orderBy
        return new ArrayList<>(elements.subList(where, orderBy));
    }
}
