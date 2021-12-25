package com.beyourself.service;

import com.beyourself.model.Article;

public interface ArticleService {
    boolean addNewArticle(Article article);

    int updateArticleState(Long[] aids, Integer state);
}
