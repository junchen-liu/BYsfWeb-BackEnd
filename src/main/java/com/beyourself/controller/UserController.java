package com.beyourself.controller;

import com.beyourself.model.User;
import com.beyourself.service.MailService;
import com.beyourself.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;
    final MailService mailService;

    public UserController(UserService userService, MailService mailService) {
        this.userService = userService;
        this.mailService = mailService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> userLogin(@RequestBody User user) {
        return userService.loginAccount(user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> userRegister(@RequestBody User user) {
        return userService.createAccount(user);
    }

    @RequestMapping(value = "/activation", method = RequestMethod.GET)
    public Map<String, Object> activeAccount(String confirmCode) {
        return userService.activeAccount(confirmCode);
    }
}
