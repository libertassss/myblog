package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.ArticleWithBLOBs;
import com.zyy.blog.modules.sys.vo.ArticleListVo;

import java.util.List;

public interface ArticleService {
    int insertSelective(ArticleWithBLOBs articleWithBLOBs);

    List<ArticleListVo> selectAllArticle();
}
