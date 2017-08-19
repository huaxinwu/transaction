/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 消息类
 * @author wxh
 * @version $Id: Message.java, v 0.1 2017年7月18日 下午9:28:43 wxh Exp $
 */
public class Message implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -8004966695428525343L;
    
    private int messageID;          //消息ID
    private String messageTitle;    //消息标题
    private String messageContent;  //消息内容
    private int employeeID;         //发布人ID
    private Date publishTime;       //发布时间
    
    public Message() {
    }
    
    public int getMessageID() {
        return messageID;
    }
    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }
    public String getMessageTitle() {
        return messageTitle;
    }
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }
    public String getMessageContent() {
        return messageContent;
    }
    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    public Date getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    
}
