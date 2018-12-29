package com.zyy.blog.modules.sys.service.impl;

import com.zyy.blog.modules.sys.dao.ArticleMapper;
import com.zyy.blog.modules.sys.entity.Article;
import com.zyy.blog.modules.sys.entity.ArticleWithBLOBs;
import com.zyy.blog.modules.sys.service.ArticleService;
import com.zyy.blog.modules.sys.vo.ArticleListVo;
import com.zyy.blog.modules.sys.vo.ParamsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    /**
     * 新增文章
     * @param articleWithBLOBs
     * @return
     */
    @Override
    public int insertSelective(ArticleWithBLOBs articleWithBLOBs){
        articleWithBLOBs.setArticlePostTime(new Date());
        articleWithBLOBs.setArticleIsComment(1);
        articleWithBLOBs.setArticleOrder(1);
        articleWithBLOBs.setArticleStatus(0);
        return articleMapper.insertSelective(articleWithBLOBs);
    }

    /**
     * 文章列表
     * @return
     */
    @Override
    public List<ArticleListVo> selectAllArticle(){
        return articleMapper.selectAllArticle();
    }


    /**
     * 单条删除
     * @param articleId
     * @return
     */
    @Override
    public  int deleteByPrimaryKey(int articleId){
        return articleMapper.deleteByPrimaryKey(articleId);
    }

    /**
     * 编辑
     * @param article
     * @return
     */
    @Override
    public int updateByPrimaryKey(Article article){
        return articleMapper.updateByPrimaryKey(article);
    }

    /**
     * 批量删除
     * @param paramsVo
     * @return
     */
    @Override
    public int deleteArticleMall(ParamsVo paramsVo){
        return articleMapper.deleteArticleMall(paramsVo.getItem());
    }
}
