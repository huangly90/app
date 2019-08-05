package com.java.app.controller;

import com.java.app.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexCtrl{
    @RequestMapping(value = {"/login/{userName}","/"})
    public String index(@PathVariable(required = false) String userName, HttpServletRequest request){
        if("jiangmy".equals(userName))
            return "jiang";
        request.getSession().setAttribute("user",userName);
        return "index";
    }
    @RequestMapping("/test")
    @ResponseBody
    public Object test(@RequestBody Message message){
        return message;
    }

}
