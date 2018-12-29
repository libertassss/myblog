package com.zyy.blog.modules.sys.vo;

import java.util.List;

public class ParamsVo {
    private List<Integer> item;
    private Integer categoriId;
    private Integer articleId;

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setItem(List<Integer> item) {
        this.item = item;
    }

    public List<Integer> getItem(){
        return item;
    }

    public void setCategoriId(Integer categoriId) {
        this.categoriId = categoriId;
    }

    public Integer getCategoriId() {
        return categoriId;
    }
}
