package com.star.people.service;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.star.people.exception.ServiceException;
import com.star.people.mapper.ArticleMapper;
import com.star.people.mapper.SqlMapper;
import com.star.people.model.Article;
import com.star.people.model.ArticleContentVO;
import com.star.people.model.ArticleInfoVO;
import com.star.people.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

/**
 * Created by zuhai.jiang on 2015/12/20.
 */
@Service
public class ArticleService {
    private Logger logger = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    SqlMapper sqlMapper;

    public Article getArticle(int id) throws ServiceException {
        logger.info("id:{}",id);
        Article rec = articleMapper.selectByPrimaryKey(id);
        if (rec == null) {
            throw new ServiceException("查询文章失败-id:"+id);
        }
        return rec;
    }

    public ArticleInfoVO getArticleInfo(int id){
        logger.info("id:{}", id);
        String[] fields = ObjectUtil.getFields(ArticleInfoVO.class);
        StringBuilder sb = new StringBuilder("select ");
        Joiner.on(",").appendTo(sb, fields);
        sb.append(" from pt_article where id=");
        sb.append(id);
        List<Map> list = sqlMapper.selectBySql(sb.toString());
        if (list.size()<1) {
            return null;
        }
        ArticleInfoVO vo = new ArticleInfoVO();
        ObjectUtil.fromMap(list.get(0), vo);
        return vo;
    }

    public ArticleContentVO getArticleContent(int id){
        logger.info("id:{}", id);
        String[] fields = ObjectUtil.getFields(ArticleContentVO.class);
        StringBuilder sb = new StringBuilder("select ");
        Joiner.on(",").appendTo(sb, fields);
        sb.append(" from pt_article where id=");
        sb.append(id);
        List<Map> list = sqlMapper.selectBySql(sb.toString());
        if (list.size()<1) {
            return null;
        }
        ArticleContentVO vo = new ArticleContentVO();
        ObjectUtil.fromMap(list.get(0), vo);
        return vo;
    }

    public Article createArticle(Article rec) throws ServiceException {
        logger.info("rec:{}",rec.toString());
        rec.setAddtime(new Date());
        int r = articleMapper.insert(rec);
        if (r < 1) {
            throw new ServiceException("创建文章失败:"+rec.toString());
        }
        return rec;
    }

    public boolean saveArticleInfo(ArticleInfoVO vo, String creator) throws ServiceException {
        logger.info("articleInfo:{}", vo.toString());
        Article article = articleMapper.selectByPrimaryKey(vo.getId());
        if (article == null) {
            article = new Article();
            vo.setArticle(article);
            createArticle(article);
        } else {
            vo.setArticle(article);
            updateArticle(article);
        }
        return true;
    }

    public Article updateArticle(Article rec) throws ServiceException {
        logger.info("rec:{}",rec.toString());
        int r = articleMapper.updateByPrimaryKey(rec);
        if (r < 1) {
            throw new ServiceException("更新文章失败:"+rec.toString());
        }
        return rec;
    }

    public boolean deleteArticle(int id) throws ServiceException {
        logger.info("id:{}", id);
        int r = articleMapper.deleteByPrimaryKey(id);
        if (r < 1) {
            throw new ServiceException("删除文章失败:"+id);
        }
        return true;
    }

    public Article disableArticle(int id) throws ServiceException {
        logger.info("id:{}", id);
        Article rec = getArticle(id);
        rec.setStatus(0);
        return updateArticle(rec);
    }

    public String getAbstractImgName(String user, String ext){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
        return "abstract_"+user.replace('.','_')+df.format(new Date())+"."+ext;
    }
}
