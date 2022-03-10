package com.beyourself.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.beyourself.mapper.UserMapper;
import com.beyourself.model.User;
import com.beyourself.service.MailService;
import com.beyourself.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final MailService mailService;

    public UserServiceImpl(UserMapper userMapper, MailService mailService) {
        this.userMapper = userMapper;
        this.mailService = mailService;
    }


    @Override
    public Map<String, Object> createAccount(User user) {
        //雪花算法生成确认码
        String confirmCode = IdUtil.getSnowflake(1,1).nextIdStr();
        //生成盐用于加密
        String salt = RandomUtil.randomString(6);
        String MD5Pwd = SecureUtil.md5(user.getPassword() + salt);
        LocalDateTime ldt = LocalDateTime.now().plusDays(1);
        user.setSalt(salt);
        user.setPassword(MD5Pwd);
        user.setConfirmCode(confirmCode);
        user.setActivationTime(ldt);
        user.setIsValid((byte) 0);
        int result = userMapper.insert(user);
        Map<String, Object> resultMap = new HashMap<>();
        if (result > 0){
            //send email
            //asyc send
            //TODO
            String activeUrl = "http://localhost:8080/user/activation/?confirmCode=" + user.getConfirmCode() ;
            mailService.sendMailForActivationAccount(activeUrl,user.getEmail());

            resultMap.put("code",200);
        } else{
            resultMap.put("code",400);
            resultMap.put("message","注册失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> loginAccount(User user) {
        Map<String, Object> resultMap = new HashMap<>();
        // find user by email
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",user.getEmail());
        List<User> userList = userMapper.selectList(queryWrapper);
        // no user found
        if (userList == null || userList.isEmpty()){
            resultMap.put("code",400);
            resultMap.put("message","该账户不存在或未激活");
        } else if (userList.size() == 1){//one user found
            User u = userList.get(0);
            String md5Pwd = SecureUtil.md5(user.getPassword() + u.getSalt());
            if(u.getPassword().equals(md5Pwd)){
                resultMap.put("code",200);
                resultMap.put("message","登录成功");
            }else {
                resultMap.put("code",400);
                resultMap.put("message","用户名或密码错误");
            }

        } else{//mult user found
            resultMap.put("code",400);
            resultMap.put("message","账号异常，请联系客服");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> activeAccount(String confirmCode) {
        Map<String, Object> resultMap = new HashMap<>();
        // find user by confirmCode
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("confirm_code",confirmCode);
        List<User> userList = userMapper.selectList(queryWrapper);
        //judge expire
        boolean ifExpired = LocalDateTime.now().isAfter(userList.get(0).getActivationTime());
        if (ifExpired){
            resultMap.put("code",400);
            resultMap.put("message","链接已失效，请重新注册");
        }else {
            User user = userList.get(0);
            user.setIsValid((byte) 1);
            int result = userMapper.update(user,queryWrapper);
            if (result > 0){
                resultMap.put("code",200);
                resultMap.put("message","激活成功");
            }else {
                resultMap.put("code",400);
                resultMap.put("message","激活失败");
            }
        }

        return resultMap;
    }
}
