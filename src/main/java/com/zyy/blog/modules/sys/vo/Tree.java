package com.zyy.blog.modules.sys.vo;


import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
    private Integer Parentid;
    private Integer Id;
    private List<Tree<T>> children = new ArrayList<Tree<T>>();
    private String categoryName;
    private String categoryDescription;
    private void setCategoryName(String CategoryName){
        this.categoryName=CategoryName;
    }
    public String getCategoryName(){
        return categoryName;
    }

    public void setCategoryDescription(String CategoryDescription){
        this.categoryDescription=CategoryDescription;
    }

    public String getCategoryDescription(){
        return categoryDescription;
    }

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
