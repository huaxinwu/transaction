/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wxh.bean.Message;
import com.wxh.dao.MessageDAO;
import com.wxh.util.DBConnection;
import com.wxh.util.Page;

/**
 * ��Ϣ���ݲ���ʵ��
 * @author wxh
 * @version $Id: MessageDAOImpl.java, v 0.1 2017��7��19�� ����11:00:11 wxh Exp $
 */
public class MessageDAOImpl implements MessageDAO {

    @Override
    public void addMessage(Message message) {
        Connection conn = DBConnection.getConnection();
        String sql = "insert into tb_message(messageTitle,messageContent,employeeID,publishTime) values(?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            // ����ֵ
            pstmt.setString(1, message.getMessageTitle());
            pstmt.setString(2, message.getMessageContent());
            pstmt.setInt(3, message.getEmployeeID());
            pstmt.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));
            // ִ�в������
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            // �ر���Դ
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
    }

    @Override
    public void updateMesage(Message message) {
        // TODO Auto-generated method stub
        Connection conn = DBConnection.getConnection();
        String sql = "update tb_message set messageTitle=?,messageContent=?,employeeID=?,publishTime=?  where messageID="+message.getMessageID();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            // ����ֵ
            pstmt.setString(1,  message.getMessageTitle());
            pstmt.setString(2, message.getMessageContent());
            pstmt.setInt(3, message.getEmployeeID());
            pstmt.setTimestamp(4, new Timestamp(message.getPublishTime().getTime()));
            // ִ�и��²���
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            // �ر���Դ
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
    }

    @Override
    public void deleteMessageById(int messageID) {
        Connection conn = DBConnection.getConnection();
        String sql = "delete from tb_message where messageID="+messageID;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            // û�в�����������
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            // �ر���Դ
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        
    }

    
    @Override
    public List<Message> findAllMessage(Page page) {
        Connection conn = DBConnection.getConnection();
        String sql = "select messageID,messageTitle,messageContent,employeeID,publishTime from tb_message order by publishTime desc limit ?,?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Message> messages = new ArrayList<Message>();
        try {
            pstmt = conn.prepareStatement(sql);
            // ��ѯ��ʼ����
            pstmt.setInt(1, page.getBeginIndex());
            // ÿҳ��ʾ��������¼
            pstmt.setInt(2, page.getEveryPage());
            // ִ�в�ѯ
            rs = pstmt.executeQuery();
            while(rs.next()){
                Message message = new Message();
                message.setMessageID(rs.getInt(1));
                message.setMessageTitle(rs.getString(2));
                message.setMessageContent(rs.getString(3));
                message.setEmployeeID(rs.getInt(4));
                message.setPublishTime(rs.getDate(5));
                // ��ӵ�������
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            // �ر���Դ
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        
        return messages;
    }

    @Override
    public Message findMessageById(int messageID) {
        Connection conn = DBConnection.getConnection();
        String sql = "select messageID,messageTitle,messageContent,employeeID,publishTime from tb_message where messageID= "+messageID;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Message message = null;
        try {
            pstmt = conn.prepareStatement(sql);
            // ִ�в�ѯ
            rs = pstmt.executeQuery();
            if(rs.next()){
                message = new Message();
                message.setMessageID(rs.getInt(1));
                message.setMessageTitle(rs.getString(2));
                message.setMessageContent(rs.getString(3));
                message.setEmployeeID(rs.getInt(4));
                message.setPublishTime(rs.getDate(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            // �ر���Դ
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return message;
    }

    @Override
    public int findAllCount() {
        Connection conn = DBConnection.getConnection();
        String sql = "select count(*) from tb_message";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()){
                // �����л�ȡ�ܼ�¼��
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            // �ر���Դ
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        
        return count;
    }

}
