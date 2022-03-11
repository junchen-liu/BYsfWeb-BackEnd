package com.beyourself.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.beyourself.model.Article;
import com.beyourself.model.CourseInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseInfoMapper extends BaseMapper<CourseInfo> {
    @Select("select * from course_info")
    List<CourseInfo> findAll();
}
