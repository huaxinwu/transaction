/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * ������Ϣ��
 * @author wxh
 * @version $Id: Criticism.java, v 0.1 2017��7��18�� ����9:31:48 wxh Exp $
 */
public class Criticism implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = -6136347932813067778L;
    
    private int criticismID;        //����ID
    private String criticismContent;//��������
    private int employeeID;         //������ID
    private Date criticismTime;     //����ʱ��
    private int messageID;          //��ϢID
    
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
