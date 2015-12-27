package com.star.people.model;

import com.google.gson.annotations.Expose;
import com.star.people.enums.ArticleStatus;

/**
 * Created by zuhai.jiang on 2015/12/24.
 */
public class ArticleContentVO {
    private int id;
    @Expose(serialize = false)
    private String content;
    private String linkurl;
    private int status;

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
}
