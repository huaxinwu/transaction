/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Ա����Ϣ��
 * @author wxh
 * @version $Id: Employee.java, v 0.1 2017��7��18�� ����9:25:39 wxh Exp $
 */
public class Employee implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 8011959226169321907L;
    
    
    private int employeeID;         //Ա�����
    private String employeeName;    //Ա������
    private boolean employeeSex;    //Ա���Ա�
    private Date employeeBirth;     //��������
    private String employeePhone;   //�칫�ҵ绰
    private String employeePlace;   //��ͥסַ
    private Date joinTime;          //¼��ʱ��
    private String password;        //ϵͳ����
    private boolean isLead;         //�Ƿ�Ϊ������쵼
    
    public Employee() {
        // TODO Auto-generated constructor stub
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public boolean isEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(boolean employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Date getEmployeeBirth() {
        return employeeBirth;
    }

    public void setEmployeeBirth(Date employeeBirth) {
        this.employeeBirth = employeeBirth;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeePlace() {
        return employeePlace;
    }

    public void setEmployeePlace(String employeePlace) {
        this.employeePlace = employeePlace;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLead() {
        return isLead;
    }

    public void setLead(boolean isLead) {
        this.isLead = isLead;
    }
    
}
