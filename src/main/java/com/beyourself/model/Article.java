package com.beyourself.model;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Article {
    @TableId(type = IdType.AUTO)
    private Long articleId;
    private String title;
    private Long userId;
    private String content;
    private Timestamp editTime;
}
