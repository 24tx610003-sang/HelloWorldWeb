package hello.com.services;

import java.util.List;
import hello.com.entity.UserJPA;

public interface UserJPAService {
    UserJPA login(String username, String password);
    List<UserJPA> findAll();
    void insert(UserJPA user);
    void update(UserJPA user);
    void delete(int id);
}
