package com.beyourself.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beyourself.mapper.CourseInfoMapper;
import com.beyourself.model.CourseInfo;
import com.beyourself.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseInfoMapper courseInfoMapper;

    public CourseServiceImpl(CourseInfoMapper courseInfoMapper) {
        this.courseInfoMapper = courseInfoMapper;
    }

    @Override
    public List<CourseInfo> getCourseListByName(String name) {
        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("course_name",name);
        List<CourseInfo> courseInfos = courseInfoMapper.selectList(queryWrapper);
        return courseInfos;
    }
}
