package com.haoqian.demo.controller;

import com.haoqian.demo.repo.mappers.UserMapper;
import com.haoqian.demo.repo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelloController {

    @Resource
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!  hahahh";
    }

    @ResponseBody
    @RequestMapping("/hi")
    public String hi(@RequestParam("id") Integer id){
        return "id! " + userMapper.selectByPrimaryKey(id).toString();
    }

    @ResponseBody
    @RequestMapping("/register")
    public String register(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        userMapper.insertUser(user);
        return "success";
    }
}
