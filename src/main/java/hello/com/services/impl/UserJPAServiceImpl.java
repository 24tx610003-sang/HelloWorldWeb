package hello.com.services.impl;

import java.util.List;

import hello.com.daos.UserJPADao;
import hello.com.daos.impl.UserJPADaoImpl;
import hello.com.entity.UserJPA;
import hello.com.services.UserJPAService;

public class UserJPAServiceImpl implements UserJPAService {

    UserJPADao userDao = new UserJPADaoImpl();

    @Override
    public UserJPA login(String username, String password) {
        UserJPA user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public List<UserJPA> findAll() {
        return userDao.findAll();
    }

    @Override
    public void insert(UserJPA user) {
        userDao.insert(user);
    }

    @Override
    public void update(UserJPA user) {
        userDao.update(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
