package com.beyourself.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beyourself.model.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    @Select("select * from article")
    List<Article> findAll();
}
