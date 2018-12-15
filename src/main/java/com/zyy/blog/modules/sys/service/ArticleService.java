package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.ArticleWithBLOBs;

import java.util.List;

public interface ArticleService {
    int insertSelective(ArticleWithBLOBs articleWithBLOBs);

    List<ArticleWithBLOBs> selectAllArticle();
}
