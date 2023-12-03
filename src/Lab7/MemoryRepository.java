package Lab7;

import Lab7.Interface.IRepository;

import java.util.ArrayList;
import java.util.List;

public class MemoryRepository<T> implements IRepository<T> {

    public static void main(String[] args) {
        MemoryUserRepository repository = MemoryUserRepository.getRepository();
        for (int i = 0; i < 20; i++) {
            repository.add(new User(i, i + "Amiiiigos", Gender.MALE, "88003535355" + i)); // + (int)(Math.random() * 10)
        }
        System.out.println(repository.getById(5));
        repository.delete(repository.getById(5));
        repository.update(repository.getById(14564656), repository.getByName("3Amiiiigos"));
        System.out.println(repository.getByName("9Amiiiigos"));
        System.out.println(repository.getByGender(Gender.FEMALE));
    }

    private final List<T> elements;

    public List<T> getElements() {
        return elements;
    }

    public MemoryRepository() {
        elements = new ArrayList<>();
    }

    @Override
    public void add(T item) {
        elements.add(item);
    }

    @Override
    public void update(T item, T newItem) {
        if (elements.contains(item)) {
            elements.set(elements.indexOf(item), newItem);
        } else throw new RuntimeException("NOTHING TODO");
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
