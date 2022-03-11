package com.beyourself.service;

import com.beyourself.model.CourseInfo;

import java.util.List;

public interface CourseService {
    List<CourseInfo> getCourseListByName(String name);

    List<CourseInfo> getCourseListById(String id);

    List<CourseInfo> findAll();

//    List<CourseInfo> getCourseListByType(String type);
}
