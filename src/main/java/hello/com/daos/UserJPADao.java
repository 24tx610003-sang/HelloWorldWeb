package hello.com.daos;

import java.util.List;
import hello.com.entity.UserJPA;

public interface UserJPADao {
    UserJPA findByUsername(String username);
    List<UserJPA> findAll();
    void insert(UserJPA user);
    void update(UserJPA user);
    void delete(int id);
}
