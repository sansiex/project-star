package com.star.people.model;

import com.star.people.enums.ArticleStatus;
import com.star.people.util.CollectionUtil;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by zuhai.jiang on 2015/12/23.
 */
public class ArticleInfoVO {

    private int id;
    private String title;
    private String abstracttext;
    private String imageurl;
    private int type;
    private String creator;
    private int status;
    private Integer prior;
    private Date publishtime;

    private static String[] fields;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracttext() {
        return abstracttext;
    }

    public void setAbstracttext(String abstracttext) {
        this.abstracttext = abstracttext;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public ArticleStatus getStatus() {
        return ArticleStatus.valueOf(status);
    }

    public void setStatus(ArticleStatus status) {
        this.status = status.getValue();
    }

    public Integer getPrior() {
        return prior;
    }

    public void setPrior(Integer prior) {
        this.prior = prior;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }
}
