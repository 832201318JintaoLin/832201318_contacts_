package com.example.files.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.files.entity.User;
import com.example.files.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //查询电话簿列表
    @GetMapping("/list")
    public List<User> list(String name) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotEmpty(name), User::getUsername, name);
        return userService.list(wrapper);
    }

    //新增
    @PostMapping("/add")
    public String add(@RequestBody User user) {
        if (userService.save(user)) {
            return "ok";
        }
        return null;
    }

    //修改
    @PutMapping("/update")
    public String update(@RequestBody User user) {
        if (userService.updateById(user)) {
            return "ok";
        }
        return null;
    }

    //删除
    @DeleteMapping("/delete")
    public String delete(Integer id) {
        if (userService.removeById(id)) {
            return "ok";
        }
        return null;
    }

}

