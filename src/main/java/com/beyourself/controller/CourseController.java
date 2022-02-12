package com.beyourself.controller;

import com.beyourself.model.Article;
import com.beyourself.model.CourseInfo;
import com.beyourself.model.ResponseModel;
import com.beyourself.service.ArticleService;
import com.beyourself.service.CourseService;
import com.beyourself.service.impl.CourseServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
