package Lab7.Interface;

import Lab7.Gender;
import Lab7.User;

import java.util.List;

public interface UserRepository extends IRepository<User>{
    User getById(Integer id);
    User getByName(String name);
    User getByEmail(String email);
    List<User> getByCity(String city);
    List<User> getByGender(Gender gender);


}
