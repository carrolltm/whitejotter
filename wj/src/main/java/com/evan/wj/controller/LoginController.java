package com.evan.wj.controller;

import com.evan.wj.pojo.User;
import com.evan.wj.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

//Controller 是对响应进行处理的部分
/*
分别与接收到的 User 类的 username 和 password 进行比较
前端如果接收到成功的响应码（200），则跳转到 /index 页面。
 */
// 分发请求
@Controller
public class LoginController {
    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){
        // 对 html 标签进行转义，防止 XSS 攻击
        String username=requestUser.getUsername();
        username= HtmlUtils.htmlEscape(username);
        if(!Objects.equals("admin",username)||!Objects.equals("123456",requestUser.getPassword())){
            String message="账号密码错误";
            System.out.println("test");
            return new Result(400);
        }
        else {
            return new Result(200);
        }

    }

}
