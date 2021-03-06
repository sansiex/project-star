package com.star.people.model;

import com.google.common.base.Strings;
import com.google.gson.annotations.Expose;
import com.star.people.enums.ArticleStatus;
import com.star.people.util.CollectionUtil;
import com.star.people.util.DateUtil;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by zuhai.jiang on 2015/12/23.
 */
public class ArticleInfoVO extends BaseEntity {

    private int id;
    private String title;
    @Expose(serialize = false)
    private String abstracttext;
    private String imageurl;
    private int type;
    private String creator;
    private int status;
    private Integer prior;
    private String publishtime;

    public void setArticle(Article article){
        article.setId(id);
        article.setTitle(title);
        article.setAbstracttext(abstracttext);
        if (!Strings.isNullOrEmpty(imageurl)) {
            article.setImageurl(imageurl);
        }
        article.setType(type);
        article.setStatus(ArticleStatus.valueOf(status));
        article.setPrior(prior);
        article.setPublishtime(DateUtil.toDate(publishtime, DateUtil.DATETIME_FORMAT));
    }

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
        return DateUtil.toDate(publishtime, DateUtil.DATETIME_FORMAT);
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = DateUtil.formatDatetime(publishtime);
    }
}
