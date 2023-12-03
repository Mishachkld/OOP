package Lab7;

import Lab7.Interface.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class MemoryUserRepository extends MemoryRepository<User> implements UserRepository {

    private static final MemoryUserRepository repository = new MemoryUserRepository();



    private MemoryUserRepository(){}

    public static MemoryUserRepository getRepository(){
        return repository;
    }

    @Override
    public User getById(Integer id) {
        for (User user : getElements()) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new RuntimeException("Not Found User with ID " + id);
    }

    @Override
    public User getByName(String name) {
        for (User user : getElements()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new RuntimeException("Not Found User with NAME " + name);
    }

    @Override
    public User getByEmail(String email) {
        for (User user : getElements()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        throw new RuntimeException("Not Found User with EMAIL " + email);
    }

    @Override
    public List<User> getByCity(String city) {
        List<User> result = new ArrayList<>();
        for (User user : getElements()) {
            if (user.getCity().equals(city)) {
                result.add(user);
            }
        }
        if (!result.isEmpty())
            return result;
        throw new RuntimeException("Not Found Users with CITY " + city);
    }

    @Override
    public List<User> getByGender(Gender gender) {
        List<User> result = new ArrayList<>();
        for (User user : getElements()) {
            if (user.getGender().equals(gender)) {
                result.add(user);
            }
        }
        if (!result.isEmpty())
            return result;
        throw new RuntimeException("Not Found Users with GENDER " + gender);
    }
}
