package com.fei.okhttp;

import com.fei.okhttp.base.BaseJsonServlet;
import com.fei.okhttp.entity.ResponseEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userComment")
public class UserCommentServlet extends BaseJsonServlet {
    @Override
    protected ResponseEntity onHandler(HttpServletRequest req, HttpServletResponse resp) {

        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.code = "0033";
        responseEntity.msg = "评论失败，用户未登录";

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("name") && cookie.getValue().equals("fei")) {
                    responseEntity.code = "0000";
                    responseEntity.msg = "评论成功";
                    return responseEntity;
                }
            }
        }

        return responseEntity;
    }
}
