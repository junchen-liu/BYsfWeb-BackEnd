package com.beyourself.service.impl;

import com.beyourself.mapper.ArticleMapper;
import com.beyourself.model.Article;
import com.beyourself.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public boolean addNewArticle(Article article) {
        //设置时间戳
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
}