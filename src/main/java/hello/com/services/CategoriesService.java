package hello.com.services;

import java.util.List;
import hello.com.entity.Categories;

public interface CategoriesService {
    void insert(Categories category);
    void update(Categories category);
    void delete(int id);
    Categories findById(int id);
    List<Categories> findAll();
}
