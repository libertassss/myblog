package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.Category;
import com.zyy.blog.modules.sys.vo.ParamsVo;

import java.util.List;

public interface CategoryService {
    /**
     * 新增类别
     * @param category
     * @return
     */
    int insertCategory(Category category);

    /**
     * 查询类别
     * @param category
     * @return
     */
    List<Category> selectByExample(Category category);

    /**
     * 查询所有
     * @return
     */
    List<Category> selectAllCategory();

    /**
     * 删除类别
     * @param categoryId
     * @return
     */
    int deleteCategory(Integer categoryId);

    /**
     * 批量删除
     * @param paramsVo
     * @return
     */
    int deleteCategoryMall(ParamsVo paramsVo);

    /**
     * 查询所有
     * @return
     */
    List<Category> selectAll();

    List<Integer> selectChildren(Integer pid);
}
