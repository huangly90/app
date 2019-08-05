package com.java.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Message {
    @TableId(value = "id" ,type= IdType.AUTO)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date edittime;
    private String content;
    private String user;
    private Integer dr;
    private String reply;
}