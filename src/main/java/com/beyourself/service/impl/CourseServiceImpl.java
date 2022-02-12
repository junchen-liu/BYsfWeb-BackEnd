package com.beyourself.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beyourself.mapper.ArticleMapper;
import com.beyourself.mapper.CourseMapper;
import com.beyourself.model.Article;
import com.beyourself.model.CourseInfo;
import com.beyourself.service.CourseService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.sql.Wrapper;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public List<CourseInfo> getCourseListByName(String name) {
        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_name",name);
        List<CourseInfo> courseInfos = courseMapper.selectList(queryWrapper);
        return courseInfos;
    }
}
