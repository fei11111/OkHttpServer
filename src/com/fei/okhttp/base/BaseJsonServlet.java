package com.fei.okhttp.base;

import com.alibaba.fastjson.JSON;
import com.fei.okhttp.entity.ResponseEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class BaseJsonServlet extends BaseServlet {
    @Override
    protected void onResponse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        ResponseEntity responseEntity = null;

        try {
            responseEntity = onHandler(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (responseEntity == null) {
            responseEntity = new ResponseEntity();
        }

        PrintWriter writer = resp.getWriter();
        writer.write(JSON.toJSONString(responseEntity));
        writer.flush();
        writer.close();

    }

    protected abstract ResponseEntity onHandler(HttpServletRequest req, HttpServletResponse resp);
}
