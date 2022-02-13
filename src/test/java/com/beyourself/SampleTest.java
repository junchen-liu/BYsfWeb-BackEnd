package com.beyourself;

import com.beyourself.mapper.UserInfoMapper;
import com.beyourself.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UserInfo> userList = userInfoMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
}
