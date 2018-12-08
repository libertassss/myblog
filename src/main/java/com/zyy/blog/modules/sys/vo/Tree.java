package com.zyy.blog.modules.sys.vo;


public class Tree<T> {
    private Integer categoryPid;
    private Integer categoryId;
    private String categoryName;
    private String categoryDescription;
    private Tree<Tree> children;
    public void getCategoryPid(Integer categoryPid){
        this.categoryPid=categoryPid;
    }
    public Integer setCategoryPid(){
        return categoryPid;
    }

    public void setCategoryId(Integer categoryId)
    {
        this.categoryId=categoryId;
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

    public void setChildren(Tree tree){
        this.children=tree;
    }

    public Tree<Tree> getChildren(){
        return children;
    }

}
