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

    @Override
    public List<CourseInfo> getCourseListById(String id) {
        id=id.replaceAll("\\s+","%");
        String searchId = "%"+id+"%";
        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("id",searchId);
        return courseInfoMapper.selectList(queryWrapper);
    }

    @Override
    public List<CourseInfo> findAll() {
        return courseInfoMapper.findAll();
    }

//    @Override
//    public List<CourseInfo> getCourseListByType(String type) {
//        QueryWrapper<CourseInfo> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("course_name",name);
//        List<CourseInfo> courseInfos = courseInfoMapper.selectList(queryWrapper);
//        return null;
//    }
}
