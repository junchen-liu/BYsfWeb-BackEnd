package com.beyourself.service;

import com.beyourself.model.User;

import java.util.Map;

public interface UserService {
    Map<String,Object> createAccount(User user);
    Map<String,Object> loginAccount(User user);

    Map<String, Object> activeAccount(String confirmCode);
}
