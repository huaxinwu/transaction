/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/**
 * 数据库
 * @author wxh
 * @version $Id: DBConnection.java, v 0.1 2017年7月18日 下午9:35:39 wxh Exp $
 */
public class DBConnection {
    /*
     * 静态初始化相关数据库配置文件
     * 1.硬编码配置文件
     * 2.读取配置文件，通过Properties加载
     */
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://127.0.0.1:3306/db_affairmanage";
    private static final String USERNAME="root";
    private static final String PASSWORD="123456";
    
    /**
     *  打开一个数据库连接
     * @return Connection
     */
    public static Connection getConnection(){
        // 声明一个连接对象
        Connection conn = null;
        try {
            // 注册数据库驱动
            Class.forName(DRIVER);
            // 创建一个连接
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    /**
     * 关闭一个连接对象
     * @param connection
     */
    public static void close(Connection conn){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    /**
     * 关闭一个预处理对象
     * @param pstmt
     */
    public static void close(PreparedStatement pstmt){
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 关闭一个结果集对象
     * @param rs
     */
    public static void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
