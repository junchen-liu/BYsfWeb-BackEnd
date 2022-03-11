package com.beyourself.controller;

import com.beyourself.model.Article;
import com.beyourself.model.CourseInfo;
import com.beyourself.model.ResponseModel;
import com.beyourself.service.ArticleService;
import com.beyourself.service.CourseService;
import com.beyourself.service.impl.CourseServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/course")
public class CourseController {
    final
    CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @RequestMapping(value = "/getCourses", method = RequestMethod.GET)
    public @ResponseBody List<CourseInfo> getCourses(String name) {
        List<CourseInfo> courseInfos = courseService.getCourseListByName(name);
        return courseInfos;
    }

    @RequestMapping(value = "/getCoursesById", method = RequestMethod.GET)
    public @ResponseBody List<CourseInfo> getCoursesById(String id) {
        List<CourseInfo> courseInfos = courseService.getCourseListById(id);
        return courseInfos;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    public List<CourseInfo> findAllCourseInfo() {
        return courseService.findAll();
    }
}
