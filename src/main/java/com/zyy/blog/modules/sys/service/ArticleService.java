package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.Article;
import com.zyy.blog.modules.sys.entity.ArticleWithBLOBs;
import com.zyy.blog.modules.sys.vo.ArticleListVo;
import com.zyy.blog.modules.sys.vo.ParamsVo;

import java.util.List;

public interface ArticleService {
    /**
     * 新增文章
     * @param articleWithBLOBs
     * @return
     */
    int insertSelective(ArticleWithBLOBs articleWithBLOBs);

    /**
     * 查询文章列表
     * @return
     */
    List<ArticleListVo> selectAllArticle();

    /**
     * 单挑删除
     * @param articleId
     * @return
     */
    int deleteByPrimaryKey(int articleId);

    /**
     * 编辑
     * @param article
     * @return
     */
    int updateByPrimaryKey(Article article);

    /**
     * 批量删除
     * @param paramsVo
     * @return
     */
    int deleteArticleMall(ParamsVo paramsVo);
}
