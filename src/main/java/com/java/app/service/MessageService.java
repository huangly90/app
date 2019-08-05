package com.java.app.service;

import com.java.app.entity.Message;
import com.java.app.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    @Autowired
    private MessageMapper msgMapper;

    @Transactional
    public void add(Message message) {
        msgMapper.insert(message);
    }
    @Transactional
    public void remove(Integer id) {
        msgMapper.deleteById(id);
    }
    public List<Message> query(Map conditionMap) {
        return msgMapper.selectByMap(conditionMap);
    }
}
