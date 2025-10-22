package hello.com.daos;

import java.util.List;
import hello.com.entity.Categories;

public interface CategoriesDao {

	// Lấy tất cả danh mục
	List<Categories> findAll();

	// Tìm danh mục theo ID
	Categories findById(int id);

	// Thêm mới danh mục
	void insert(Categories category);

	// Cập nhật danh mục
	void update(Categories category);

	// Xóa danh mục
	void delete(int id);
}
