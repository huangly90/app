package com.java.app.controller;

import com.java.app.entity.Message;
import com.java.app.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    @Controller
    @Slf4j
    public class MessageCtrl {
        @Autowired
        private MessageService messageService;

        @ResponseBody
        @RequestMapping("/msg/add")
        public Object add(@RequestBody(required = false) Message message, HttpServletRequest request) {
            log.info("add User{} Message{}", request.getSession().getAttribute("user"), message);
            message.setCreatetime(new Date(System.currentTimeMillis()));
            message.setEdittime(new Date(System.currentTimeMillis()));
            messageService.add(message);
            return true;
        }

        @ResponseBody
        @RequestMapping("/msg/get/{id}")
        public Object get(@PathVariable Integer id, HttpServletRequest request) {
            Map<String,Object> parmMap=new HashMap();
            parmMap.put("id",id);
            return messageService.query(parmMap);
        }
        @GetMapping("/msg/list")
        public Object list(Model model){
            List<Message> msgList= messageService.query(new HashMap());
            model.addAttribute("data",msgList);
            return "msglist";
        }
    }

