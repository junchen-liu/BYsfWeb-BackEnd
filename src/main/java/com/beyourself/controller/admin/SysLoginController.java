package com.beyourself.controller.admin;

import com.beyourself.mapper.UserMapper;
import com.beyourself.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/login")
public class SysLoginController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public List<User> getUserList(){
        return userMapper.selectList(null);
    }

    @RequestMapping("/map")
    public Map<String,User> getUserMap(){
        List<User> userList = userMapper.selectList(null);
        Map<String,User> map = new HashMap<>();
        for (User user : userList) {
            map.put(user.getName(),user);
        }
        return map;
    }


}
