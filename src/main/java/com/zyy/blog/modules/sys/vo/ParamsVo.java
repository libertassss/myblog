package com.zyy.blog.modules.sys.vo;

import java.util.List;

public class ParamsVo {
    private List<Integer> item;
    private Integer categoriId;

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
