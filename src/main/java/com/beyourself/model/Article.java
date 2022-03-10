package com.beyourself.model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Article {
    @TableId(type = IdType.AUTO)
    private Long articleId;
    private String type;
    private String author;
    private String title;
    private String summary;
    private String keyword;
    private Long userId;
    private String content;
    private String reference;
    private Timestamp editTime;
    private Long viewNumber;
}
