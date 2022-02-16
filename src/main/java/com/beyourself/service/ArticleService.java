package com.beyourself.service;

import com.beyourself.model.Article;

import java.util.List;

public interface ArticleService {
    boolean addNewArticle(Article article);

    int updateArticleState(Long[] aids, Integer state);

    List<Article> findArticleById(Long articleId);

    List<Article> findArticleByTitle(String articleName);

}
