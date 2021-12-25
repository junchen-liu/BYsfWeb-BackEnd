package com.beyourself.controller;

import com.beyourself.model.Article;
import com.beyourself.model.ResponseModel;
import com.beyourself.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseModel addNewArticle(Article article) {
        if (articleService.addNewArticle(article)) {
            return new ResponseModel("success", article.getArticleId()+ "");
        } else {
            return new ResponseModel("error", article.getArticleId() + " 文章发表失败!");
        }
    }

    @RequestMapping(value = "/dustbin", method = RequestMethod.PUT)
    public ResponseModel updateArticleState(Long[] aids, Integer state) {
        if (articleService.updateArticleState(aids, state) == aids.length) {
            return new ResponseModel("success", "删除成功!");
        }
        return new ResponseModel("error", "删除失败!");
    }

}
