package vn.iotstar.service;

import java.util.List;
import vn.iotstar.entity.Category;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    void insert(Category category);
    void delete(int id);
}