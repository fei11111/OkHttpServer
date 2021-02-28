package com.fei.okhttp;

import com.alibaba.fastjson.JSON;
import com.fei.okhttp.base.BaseJsonServlet;
import com.fei.okhttp.entity.ResponseEntity;
import com.fei.okhttp.entity.UserInfo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends BaseJsonServlet {
    @Override
    protected ResponseEntity onHandler(HttpServletRequest req, HttpServletResponse resp) {

        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.code = "0022";
        responseEntity.msg = "用户名或密码错误";
        //模拟登录
        String name = req.getParameter("name");
        if ("fei".equals(name)) {
            responseEntity.code = "200";
            responseEntity.msg = "登录成功";
            UserInfo userInfo = new UserInfo(name, "男");
            responseEntity.data = JSON.toJSONString(userInfo);
            Cookie cookie = new Cookie("name",name);
            //设置过期时间
            cookie.setMaxAge(10);//10秒
            resp.addCookie(cookie);
            return responseEntity;
        }

        return responseEntity;
    }
}
