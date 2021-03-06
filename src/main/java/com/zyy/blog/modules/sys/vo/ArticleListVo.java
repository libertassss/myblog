package com.zyy.blog.modules.sys.vo;

import com.zyy.blog.modules.sys.entity.Category;
import com.zyy.blog.modules.sys.entity.Tag;
import com.zyy.blog.modules.sys.entity.User;

import java.util.Date;
import java.util.List;

public class ArticleListVo {
    private Integer articleId;
    private String userName;
    private String articleTitle;
    private Date articlePostTime;
    private String categoryName;
    private String tagName;
    private String articleContent;
    private User user;
    private List<Tag> tag;
    private Category category;
    private Integer articleViewCount;
    private Integer articleCommentCount;
    private Integer articleLikeCount;
    private Integer articleIsComment;
    private Integer articleStatus;
    private Integer articleOrder;
    private String articleContentMd;

    public String getArticleContentMd() {
        return articleContentMd;
    }

    public void setArticleContentMd(String articleContentMd) {
        this.articleContentMd = articleContentMd;
    }

    public Integer getArticleCommentCount() {
        return articleCommentCount;
    }

    public Integer getArticleIsComment() {
        return articleIsComment;
    }

    public Integer getArticleLikeCount() {
        return articleLikeCount;
    }

    public Integer getArticleOrder() {
        return articleOrder;
    }

    public Integer getArticleViewCount() {
        return articleViewCount;
    }

    public Integer getArticleStatus() {
        return articleStatus;
    }

    public void setArticleCommentCount(Integer articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public void setArticleIsComment(Integer articleIsComment) {
        this.articleIsComment = articleIsComment;
    }

    public void setArticleLikeCount(Integer articleLikeCount) {
        this.articleLikeCount = articleLikeCount;
    }

    public void setArticleOrder(Integer articleOrder) {
        this.articleOrder = articleOrder;
    }

    public void setArticleStatus(Integer articleStatus) {
        this.articleStatus = articleStatus;
    }

    public void setArticleViewCount(Integer articleViewCount) {
        this.articleViewCount = articleViewCount;
    }


    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public User getUser() {
        return user;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Date getArticlePostTime() {
        return articlePostTime;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public void setArticlePostTime(Date articlePostTime) {
        this.articlePostTime = articlePostTime;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
