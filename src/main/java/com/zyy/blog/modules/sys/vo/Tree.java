package com.zyy.blog.modules.sys.vo;


import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private Integer Parentid;
    private Integer Id;
    private String categoryName;
    private String categoryDescription;
    private List<Tree<T>> children = new ArrayList<Tree<T>>();
    public void setParentid(Integer parentid){
        this.Parentid=parentid;
    }
    public Integer getParentid(){
        return Parentid;
    }

    public void setId(Integer Id)
    {
        this.Id=Id;
    }

    public String getCategoryName(){
        return categoryName;
    }

    public void setCategoryName(String categoryName){
        this.categoryName=categoryName;
    }

    public String getCategoryDescription(){
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription){
        this.categoryDescription=categoryDescription;
    }

    public void setChildren(List<Tree<T>> children){
        this.children=children;
    }

    public List<Tree<T>> getChildren(){
        return children;
    }

    public Integer getId() {
        return Id;
    }
}
