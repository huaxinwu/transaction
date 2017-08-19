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

import com.wxh.bean.Reply;
import com.wxh.dao.ReplyDAO;
import com.wxh.util.DBConnection;
import com.wxh.util.Page;

/**
 * �ظ���Ϣ������ݲ���ʵ��
 * @author wxh
 * @version $Id: ReplyDAOImpli.java, v 0.1 2017��7��20�� ����11:24:02 wxh Exp $
 */
public class ReplyDAOImpli implements ReplyDAO {

    
    /**
     * DML:���ݲ�������(insert update delete)---���ݿ�����װJava����
     * DQL:���ݲ�ѯ����(select)-----------------Java�����װ���ݿ����
     * DDL:���ݶ�������(alter create drop truncate )
     * DCL:���ݿ�������(commit grant rollback)
     */
    
    @Override
    public void addReply(Reply reply) {
        Connection conn = DBConnection.getConnection();
        String sql = "insert into tb_reply(replyContent,employeeID,replyTime,messageID) values(?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            // ����ֵ
            pstmt.setString(1, reply.getReplyContent());
            pstmt.setInt(2, reply.getEmployeeID());
            pstmt.setTimestamp(3, new Timestamp(reply.getReplyTime().getTime()));
            pstmt.setInt(4, reply.getMessageID());
            // ִ�в���
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }

    }

    @Override
    public List<Reply> findReplyByMsgId(int messageID, Page page) {
        Connection conn = DBConnection.getConnection();
        String sql = "select replyID,replyContent,employeeID,replyTime,messageID from tb_reply where messageID=? limit ?,?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Reply> replies = new ArrayList<Reply>();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, messageID);
            pstmt.setInt(2, page.getBeginIndex());
            pstmt.setInt(3, page.getEveryPage());
            rs = pstmt.executeQuery();
            while(rs.next()){
                Reply reply = new Reply();
                reply.setReplyID(rs.getInt(1));
                reply.setReplyContent(rs.getString(2));
                reply.setEmployeeID(rs.getInt(3));
                reply.setReplyTime(rs.getDate(4));
                reply.setMessageID(rs.getInt(5));
                // ����һ��һ��������ӵ�������
                replies.add(reply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return replies;
    }

    @Override
    public int findCountByMsgId(int messageID) {
        Connection conn = DBConnection.getConnection();
        String sql = "select count(*) from tb_reply where messageID=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            pstmt= conn.prepareStatement(sql);
            // ���ò���
            pstmt.setInt(1, messageID);
            rs = pstmt.executeQuery();
            if(rs.next()){
               count = rs.getInt(1); 
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBConnection.close(rs);
            DBConnection.close(pstmt);
            DBConnection.close(conn);
        }
        return count;
    }

}
