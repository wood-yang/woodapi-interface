package com.wood.woodapi_interface.controller;

import com.wood.woodapiclientsdk.client.WoodapiClient;
import com.wood.woodapiclientsdk.model.User;
import com.wood.woodapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 名称 API
 */
@RestController()
@RequestMapping("/name")
public class NameController {
    @Resource
    private WoodapiClient woodapiClient;

    @GetMapping
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    @PostMapping
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        // todo 实际情况应该是去数据库中查看用户是否具有accessKey
//        if (!"wood".equals(accessKey)) {
//            throw new RuntimeException("无权限");
//        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        // 时间和当前时间不能超过 5 min
        long current = System.currentTimeMillis() / 1000;
        if (current - Long.parseLong(timestamp) > 60 * 5) {
            throw new RuntimeException("请求已超时");
        }
        // todo 实际情况中是从服务器查出 secertKey
//        if (!SignUtils.getSign(body, "abc").equals(sign)) {
//            throw new RuntimeException("无权限");
//        }


        String result = "POST 用户名是" + user.getUsername();
        // 调用成功，次数+1

        return result;
    }
}
