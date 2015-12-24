package com.star.people.mapper;

import com.star.people.model.Article;
import com.star.people.model.ArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int countByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int deleteByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int insert(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int insertSelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    List<Article> selectByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    Article selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(Article record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pt_article
     *
     * @mbggenerated Tue Dec 22 21:11:23 CST 2015
     */
    int updateByPrimaryKey(Article record);
}