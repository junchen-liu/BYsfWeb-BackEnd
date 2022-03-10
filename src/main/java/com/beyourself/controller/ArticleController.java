package com.beyourself.controller;

import com.beyourself.model.Article;
import com.beyourself.model.QiniuUploadInfoVO;
import com.beyourself.model.ResponseModel;
import com.beyourself.provider.QiniuFileProvider;
import com.beyourself.service.ArticleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


    @Autowired
    private QiniuFileProvider qiniuFileProvider;
    @Value("${qiniu.server}")
    private String uploadUrl;
    @Value("${qiniu.url}")
    private String imageUrl;

    @GetMapping("/file/qiniu/token")
    public QiniuUploadInfoVO getToken() {

        String token = qiniuFileProvider.getUploadToken();
        QiniuUploadInfoVO info = QiniuUploadInfoVO.builder()
                .token(token)
                .uploadUrl(uploadUrl)
                .imageUrl(imageUrl)
                .build();
        return info;
    }

    @RequestMapping(value = "/getDetailById", method = RequestMethod.POST)
    public List<Article> findArticleById(Long articleId) {
        return articleService.findArticleById(articleId);
    }

    @RequestMapping(value = "/getDetailByTitle", method = RequestMethod.POST)
    public List<Article> findArticleByName(String title) {
        return articleService.findArticleByTitle(title);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<Article> add(Article article) {
        return articleService.add(article);
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public List<Article> deleteById(Long articleId) {
        return articleService.deleteById(articleId);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public List<Article> findAllArticle() {
        return articleService.findAll();
    }

}
