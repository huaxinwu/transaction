/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * ��Ϣ��
 * @author wxh
 * @version $Id: Message.java, v 0.1 2017��7��18�� ����9:28:43 wxh Exp $
 */
public class Message implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -8004966695428525343L;
    
    private int messageID;          //��ϢID
    private String messageTitle;    //��Ϣ����
    private String messageContent;  //��Ϣ����
    private int employeeID;         //������ID
    private Date publishTime;       //����ʱ��
    
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
