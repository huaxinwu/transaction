/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 批复消息类
 * @author wxh
 * @version $Id: Criticism.java, v 0.1 2017年7月18日 下午9:31:48 wxh Exp $
 */
public class Criticism implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -6136347932813067778L;
    
    private int criticismID;        //批复ID
    private String criticismContent;//批复内容
    private int employeeID;         //批复人ID
    private Date criticismTime;     //批复时间
    private int messageID;          //消息ID
    
    public Criticism() {
    }

    public int getCriticismID() {
        return criticismID;
    }

    public void setCriticismID(int criticismID) {
        this.criticismID = criticismID;
    }

    public String getCriticismContent() {
        return criticismContent;
    }

    public void setCriticismContent(String criticismContent) {
        this.criticismContent = criticismContent;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Date getCriticismTime() {
        return criticismTime;
    }

    public void setCriticismTime(Date criticismTime) {
        this.criticismTime = criticismTime;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }
    
    
}
