package com.beyourself.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beyourself.mapper.ArticleMapper;
import com.beyourself.model.Article;
import com.beyourself.service.ArticleService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleMapper articleMapper;

    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public boolean addNewArticle(Article article) {
        //Set Timestamp
        Date date = new Date();
        Timestamp currTimestamp = new Timestamp(date.getTime());
        article.setEditTime(currTimestamp);

        //Insert Article
        articleMapper.insert(article);
        System.out.println(article.getArticleId());
        return true;
    }

    @Override
    public int updateArticleState(Long[] aids, Integer state) {
        return 0;
    }

    @Override
    public List<Article> findArticleById(Long articleId) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("article_id",articleId);
        return articleMapper.selectList(queryWrapper);
    }

    @Override
    public List<Article> findArticleByTitle(String title) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title",title);
        return articleMapper.selectList(queryWrapper);
    }

}
