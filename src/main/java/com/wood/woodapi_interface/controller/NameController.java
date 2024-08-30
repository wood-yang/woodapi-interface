package com.wood.woodapi_interface.controller;

import com.wood.woodapiclientsdk.client.WoodapiClient;
import com.wood.woodapiclientsdk.model.User;
import com.wood.woodapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 名称 API
 */
@RestController()
@RequestMapping("/name")
public class NameController {
    @Resource
    private WoodapiClient woodapiClient;

    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("game"));
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name, HttpServletRequest request) {
        System.out.println(request);
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        return "POST 用户名是" + user.getUsername();
    }

}
