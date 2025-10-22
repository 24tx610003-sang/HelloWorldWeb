package hello.com.services.impl;

import java.util.List;
import hello.com.daos.impl.CategoriesDaoImpl;
import hello.com.entity.Categories;
import hello.com.services.CategoriesService;

public class CategoriesServiceImpl implements CategoriesService {

    private CategoriesDaoImpl categoriesDao = new CategoriesDaoImpl();

    @Override
    public void insert(Categories category) {
        categoriesDao.insert(category);
    }

    @Override
    public void update(Categories category) {
        categoriesDao.update(category);
    }

    @Override
    public void delete(int id) {
        categoriesDao.delete(id);
    }

    @Override
    public Categories findById(int id) {
        return categoriesDao.findById(id);
    }

    @Override
    public List<Categories> findAll() {
        return categoriesDao.findAll();
    }
}
