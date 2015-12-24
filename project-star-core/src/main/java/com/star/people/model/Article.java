package com.star.people.model;

import java.util.Date;

public class Article extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.id
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.title
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.abstractText
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private String abstracttext;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.imageUrl
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private String imageurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.type
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.creator
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.linkurl
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private String linkurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.status
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.prior
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private Integer prior;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.publishtime
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private Date publishtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.addtime
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private Date addtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.updatetime
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private Date updatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pt_article.content
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.id
     *
     * @return the value of pt_article.id
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.id
     *
     * @param id the value for pt_article.id
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.title
     *
     * @return the value of pt_article.title
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.title
     *
     * @param title the value for pt_article.title
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.abstractText
     *
     * @return the value of pt_article.abstractText
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public String getAbstracttext() {
        return abstracttext;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.abstractText
     *
     * @param abstracttext the value for pt_article.abstractText
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setAbstracttext(String abstracttext) {
        this.abstracttext = abstracttext == null ? null : abstracttext.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.imageUrl
     *
     * @return the value of pt_article.imageUrl
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public String getImageurl() {
        return imageurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.imageUrl
     *
     * @param imageurl the value for pt_article.imageUrl
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.type
     *
     * @return the value of pt_article.type
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.type
     *
     * @param type the value for pt_article.type
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.creator
     *
     * @return the value of pt_article.creator
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.creator
     *
     * @param creator the value for pt_article.creator
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.linkurl
     *
     * @return the value of pt_article.linkurl
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public String getLinkurl() {
        return linkurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.linkurl
     *
     * @param linkurl the value for pt_article.linkurl
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl == null ? null : linkurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.status
     *
     * @return the value of pt_article.status
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.status
     *
     * @param status the value for pt_article.status
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.prior
     *
     * @return the value of pt_article.prior
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public Integer getPrior() {
        return prior;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.prior
     *
     * @param prior the value for pt_article.prior
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setPrior(Integer prior) {
        this.prior = prior;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.publishtime
     *
     * @return the value of pt_article.publishtime
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public Date getPublishtime() {
        return publishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.publishtime
     *
     * @param publishtime the value for pt_article.publishtime
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.addtime
     *
     * @return the value of pt_article.addtime
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.addtime
     *
     * @param addtime the value for pt_article.addtime
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.updatetime
     *
     * @return the value of pt_article.updatetime
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.updatetime
     *
     * @param updatetime the value for pt_article.updatetime
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pt_article.content
     *
     * @return the value of pt_article.content
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pt_article.content
     *
     * @param content the value for pt_article.content
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}