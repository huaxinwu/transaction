/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxh.bean.Employee;
import com.wxh.dao.EmployeeDAO;
import com.wxh.util.DBConnection;

/**
 * 员工数据操作实现类
 * @author wxh
 * @version $Id: EmployeeDAOImpl.java, v 0.1 2017年7月18日 下午10:20:56 wxh Exp $
 */
public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(Employee employee) {
        Connection conn = DBConnection.getConnection();
        String sql = "insert into tb_employee(employeeName,employeeSex,employeeBirth,employeePhone,employeePlace,joinTime,password,isLead)"
                + " values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            // 设置参数
            pstmt.setString(1, employee.getEmployeeName());
            pstmt.setBoolean(2, employee.isEmployeeSex());
            pstmt.setDate(3, (Date) employee.getEmployeeBirth());
            pstmt.setString(4, employee.getEmployeePhone());
            pstmt.setString(5,employee.getEmployeePlace());
            pstmt.setDate(6, (Date) employee.getJoinTime());
            pstmt.setString(7, employee.getPassword());
            pstmt.setBoolean(8, employee.isLead());
            // 执行更新
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            // 关闭资源
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        Connection conn = DBConnection.getConnection();
        String sql = "update tb_employee set employeeName=?,employeeSex=?,employeeBirth=?,employeePhone=?,employeePlace=?,joinTime=?,password=?,isLead=? where employeeID='"+employee.getEmployeeID()+"'";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            // 设置参数
            pstmt.setString(1, employee.getEmployeeName());
            pstmt.setBoolean(2, employee.isEmployeeSex());
            pstmt.setDate(3, (Date) employee.getEmployeeBirth());
            pstmt.setString(4, employee.getEmployeePhone());
            pstmt.setString(5,employee.getEmployeePlace());
            pstmt.setDate(6, (Date) employee.getJoinTime());
            pstmt.setString(7, employee.getPassword());
            pstmt.setBoolean(8, employee.isLead());
            // 执行更新
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            // 关闭资源
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
 
    }

    @Override
    public void deleteEmployeeById(int employeeID) {
        Connection conn = DBConnection.getConnection();
        String sql = "delete from tb_employee where employeeID='"+employeeID+"'";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
    }

    @Override
    public List<Employee> findAll() {
        Connection conn = DBConnection.getConnection();
        String sql = "select employeeID,employeeName,employeeSex,employeeBirth,employeePhone,employeePlace,joinTime,password,isLead from tb_employee";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Employee> employees = new ArrayList<Employee>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setEmployeeID(rs.getInt(1));
                employee.setEmployeeName(rs.getString(2));
                employee.setEmployeeSex(rs.getBoolean(3));
                employee.setEmployeeBirth(rs.getDate(4));
                employee.setEmployeePhone(rs.getString(5));
                employee.setEmployeePlace(rs.getString(6));
                employee.setJoinTime(rs.getDate(7));
                employee.setPassword(rs.getString(8));
                employee.setLead(rs.getBoolean(9));
                // 遍历添加到集合
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return employees;
    }

    @Override
    public Employee findEmployeeById(int employeeID) {
        Connection conn = DBConnection.getConnection();
        String sql = "select employeeID,employeeName,employeeSex,employeeBirth,employeePhone,employeePlace,joinTime,password,isLead from tb_employee where employeeID='"+employeeID+"'";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Employee employee = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()){
                employee = new Employee();
                employee.setEmployeeID(rs.getInt(1));
                employee.setEmployeeName(rs.getString(2));
                employee.setEmployeeSex(rs.getBoolean(3));
                employee.setEmployeeBirth(rs.getDate(4));
                employee.setEmployeePhone(rs.getString(5));
                employee.setEmployeePlace(rs.getString(6));
                employee.setJoinTime(rs.getDate(7));
                employee.setPassword(rs.getString(8));
                employee.setLead(rs.getBoolean(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        
        return employee;
    }

}
