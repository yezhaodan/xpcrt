package com.yezd.xpcrt.controller;

import com.yezd.xpcrt.service.UserService;
import com.yezd.xpcrt.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/Login")
    public ServerResponse login(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password
    ){
        return userService.checkPassword(name,password);
    }
}
