/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import java.util.List;

import com.wxh.bean.Employee;

/**
 * Ա�����ݲ���
 * @author wxh
 * @version $Id: EmployeeDAO.java, v 0.1 2017��7��18�� ����10:16:28 wxh Exp $
 */
public interface EmployeeDAO {
    /**
     * ����Ա����Ϣ
     * @param employee
     */
    public void addEmployee(Employee employee);
    /**
     * ����Ա����Ϣ
     * @param employee
     */
    public void updateEmployee(Employee employee);
    
    /**
     * ͨ��employeeIDɾ��Ա����Ϣ
     * @param employeeID
     */
    public void deleteEmployeeById(int employeeID);
    /**
     * ��ѯ����Ա����Ϣ
     * @return List
     */
    public List<Employee> findAll();
    /**
     * ͨ��employeeID��ѯ����Ա����Ϣ
     * @param employeeID
     * @return Employee
     */
    public Employee findEmployeeById(int employeeID);
}
