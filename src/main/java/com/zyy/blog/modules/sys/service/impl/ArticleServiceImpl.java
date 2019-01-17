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
import java.util.Map;

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
    public List<ArticleListVo> selectAllArticle(Map map){
        return articleMapper.selectAllArticle(map);
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

    /**
     * 根据Id查询文章
     * @param articleId
     * @return
     */
    @Override
    public Article selectArticleById(Integer articleId){
        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public ArticleListVo selectAllArticleById(Integer articleId){
        return articleMapper.selectAllArticleById(articleId);
    }


    /**
     * 查询总量
     * @return
     */
    @Override
    public Integer selectCount(){
        return articleMapper.selectCount();
    }

    @Override
    public List<Article> selectAlls(){
        return articleMapper.selectAlls();
    }

    /**
     * 查询上一条
     * @param articleId
     * @return
     */
    @Override
    public ArticleListVo selectTop(Integer articleId){
        return articleMapper.selectTop(articleId);
    }

    /**
     * 查询下一条
     * @param articleId
     * @return
     */
    @Override
    public ArticleListVo selectNext(Integer articleId){
        return articleMapper.selectNext(articleId);
    }

    /**
     * 修改
     * @param articleWithBLOBs
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(ArticleWithBLOBs articleWithBLOBs){
        return articleMapper.updateByPrimaryKeySelective(articleWithBLOBs);
    }

    /**
     * 模糊查询
     * @param article
     * @return
     */
    @Override
    public List<ArticleListVo> selectLike(Article article){
        return articleMapper.selectLike(article);
    }
}
