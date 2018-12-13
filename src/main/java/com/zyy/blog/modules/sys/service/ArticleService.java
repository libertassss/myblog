package com.zyy.blog.modules.sys.service;

import com.zyy.blog.modules.sys.entity.ArticleWithBLOBs;

public interface ArticleService {
    int insertSelective(ArticleWithBLOBs articleWithBLOBs);
}
