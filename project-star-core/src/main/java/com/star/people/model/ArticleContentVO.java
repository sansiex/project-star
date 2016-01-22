package com.star.people.model;

import com.google.gson.annotations.Expose;
import com.star.people.enums.ArticleStatus;

import java.io.Serializable;

/**
 * Created by zuhai.jiang on 2015/12/24.
 */
public class ArticleContentVO implements Serializable {
    private int id;
    @Expose(serialize = false)
    private String content;
    private String linkurl;
    private int status;
    private String contentTitle;
    private String author;

    public void setArticle(Article article){
        article.setAuthor(author);
        article.setContent(content);
        article.setContenttitle(contentTitle);
        article.setLinkurl(linkurl);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public ArticleStatus getStatus() {
        return ArticleStatus.valueOf(status);
    }

    public void setStatus(ArticleStatus status) {
        this.status = status.getValue();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }
}
