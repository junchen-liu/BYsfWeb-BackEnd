package com.beyourself.model;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Article {
    private Long articleId;
    private String title;
    private Long userId;
    private String content;
    private Timestamp editTime;
}
