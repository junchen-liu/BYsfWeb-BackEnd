package com.beyourself.controller.admin;

import com.beyourself.mapper.UserInfoMapper;
import com.beyourself.model.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/login")
public class SysLoginController {
    private final UserInfoMapper userInfoMapper;

    public SysLoginController(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @RequestMapping("/list")
    public List<UserInfo> getUserList(){
        return userInfoMapper.selectList(null);
    }

    @RequestMapping("/map")
    public Map<String, UserInfo> getUserMap(){
        List<UserInfo> userList = userInfoMapper.selectList(null);
        Map<String, UserInfo> map = new HashMap<>();
        for (UserInfo user : userList) {
            map.put(user.getNickName(),user);
        }
        return map;
    }


}
