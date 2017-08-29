package com.uucc.my_spring_boot.controller;

import com.uucc.my_spring_boot.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private UserService userService;
    @RequestMapping(path="/hello")
    public String index() {
//        return "Hello,Today is a nice day.";
        return  userService.getNames();
    }
}
