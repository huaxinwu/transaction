/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import java.util.List;

import com.wxh.bean.Employee;

/**
 * 员工数据操作
 * @author wxh
 * @version $Id: EmployeeDAO.java, v 0.1 2017年7月18日 下午10:16:28 wxh Exp $
 */
public interface EmployeeDAO {
    /**
     * 新增员工信息
     * @param employee
     */
    public void addEmployee(Employee employee);
    /**
     * 更新员工信息
     * @param employee
     */
    public void updateEmployee(Employee employee);
    
    /**
     * 通过employeeID删除员工信息
     * @param employeeID
     */
    public void deleteEmployeeById(int employeeID);
    /**
     * 查询所有员工信息
     * @return List
     */
    public List<Employee> findAll();
    /**
     * 通过employeeID查询单个员工信息
     * @param employeeID
     * @return Employee
     */
    public Employee findEmployeeById(int employeeID);
}
