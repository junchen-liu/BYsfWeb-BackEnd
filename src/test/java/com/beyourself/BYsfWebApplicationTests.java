package com.beyourself;

import com.beyourself.mapper.UserInfoMapper;
import com.beyourself.model.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BYsfWebApplicationTests {


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void contextLoads() {
        System.out.println(("----- selectAll method test ------"));
        List<UserInfo> userList = userInfoMapper.selectList(null);
        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}
