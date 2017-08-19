/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 回复消息类
 * @author wxh
 * @version $Id: Reply.java, v 0.1 2017年7月18日 下午9:30:31 wxh Exp $
 */
public class Reply implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1626579370769852887L;
    
    private int replyID;        //回复ID
    private String replyContent;//回复内容
    private int employeeID;     //回复人ID
    private Date replyTime;     //回复时间
    private int messageID;      //消息ID
    
    public Reply() {
    }

    public int getReplyID() {
        return replyID;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }
    
}
