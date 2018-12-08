package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.Category;

import java.util.List;

public interface CategoryService {
    int insertCategory(Category category);

    Category selectByExample(Category category);

    List<Category> selectAllCategory();
}
