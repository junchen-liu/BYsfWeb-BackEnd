package com.beyourself.controller;

import com.beyourself.model.Article;
import com.beyourself.model.ResponseModel;
import com.beyourself.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/article")
public class ArticleController {

    final
    ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

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

    @RequestMapping(value = "/getDetailById", method = RequestMethod.POST)
    public List<Article> findArticleById(Long articleId) {
        return articleService.findArticleById(articleId);
    }

    @RequestMapping(value = "/getDetailByTitle", method = RequestMethod.POST)
    public List<Article> findArticleByName(String title) {
        return articleService.findArticleByTitle(title);
    }

//    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
//    public List<Article> findAllArticle() {
//        return articleService.findAllArticle();
//    }

}
