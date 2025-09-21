package hello.com.daos;

import java.util.List;
import hello.com.models.User;

public interface UserDao {
    void insert(User user);
    void update(User user);
    void delete(int id);
    User findById(int id);
    User findByEmail(String email);
    User findByUserName(String userName);
    List<User> findAll();

    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
}
