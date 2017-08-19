/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * �ظ���Ϣ��
 * @author wxh
 * @version $Id: Reply.java, v 0.1 2017��7��18�� ����9:30:31 wxh Exp $
 */
public class Reply implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1626579370769852887L;
    
    private int replyID;        //�ظ�ID
    private String replyContent;//�ظ�����
    private int employeeID;     //�ظ���ID
    private Date replyTime;     //�ظ�ʱ��
    private int messageID;      //��ϢID
    
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
