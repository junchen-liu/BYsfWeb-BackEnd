package com.beyourself.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class CourseRating {
    @TableId(type = IdType.AUTO)
    private Long id;
    private int rating;
    private String courseId;
    private int user_Id;
    private int like_number;
}
