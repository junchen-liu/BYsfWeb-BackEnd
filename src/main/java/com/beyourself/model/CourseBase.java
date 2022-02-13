package com.beyourself.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class CourseBase {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String courseName;
    private String instructorName;
    private String courseId;
    private Date startDate;
    private Date endDate;
    private String shortIntroduction;
    private String location;
    private String lectureTime;
}
