package com.beyourself.service;

import com.beyourself.model.CourseInfo;

import java.util.List;

public interface CourseService {
    List<CourseInfo> getCourseListByName(String name);
}
