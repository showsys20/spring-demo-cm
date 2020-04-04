package com.demo.cm.model;

import lombok.Data;

import java.util.Date;

/**
 * @author ：changxxx
 * @date ：Created at 2020/4/2 23:33
 * @description：
 * @modified By：
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String address;
    private Date createTime;
    private Date updateTime;
    private Integer status;
}
