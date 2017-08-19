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

import com.wxh.bean.Criticism;
import com.wxh.dao.CriticismDAO;
import com.wxh.util.DBConnection;
/**
 * ������Ϣ���ݲ���ʵ����
 * @author wxh
 * @version $Id: CriticismDAOImpl.java, v 0.1 2017��8��3�� ����10:47:11 wxh Exp $
 */
public class CriticismDAOImpl implements CriticismDAO{
    @Override
	public void addCriticism(Criticism criticism) {
	    //������Ӷ���
		Connection conn = DBConnection.getConnection();	
		String sql = "insert into tb_criticism(criticismContent,employeeID,criticismTime,messageID) values(?,?,?,?)";
		//����Ԥ�������
		PreparedStatement pstmt = null;					
		try {
		    //���Ԥ������󲢸�ֵ
			pstmt = conn.prepareStatement(sql);		
			//���ò���
			pstmt.setString(1, criticism.getCriticismContent());	
			pstmt.setInt(2, criticism.getEmployeeID());
			pstmt.setTimestamp(3,new Timestamp(criticism.getCriticismTime().getTime()));
			pstmt.setInt(4, criticism.getMessageID());
			//ִ�и���
			pstmt.executeUpdate();								
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
		    //�ر���Դ
			DBConnection.close(pstmt);							
			DBConnection.close(conn);							
		}
	}
    @Override
	public Criticism findCriticismByMsgID(int messageID) {
		Connection conn = DBConnection.getConnection();	
		String sql = "select * from tb_criticism where messageID = ?";
		PreparedStatement pstmt = null;					
		ResultSet rs = null;
		Criticism criticism= new Criticism();
		try {
			pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, messageID);
			//ִ�в�ѯ
			rs = pstmt.executeQuery();				
			if(rs.next()) {
				criticism.setCriticismID(rs.getInt(1));
				criticism.setCriticismContent(rs.getString(2));
				criticism.setEmployeeID(rs.getInt(3));
				criticism.setCriticismTime(rs.getTimestamp(4));
				criticism.setMessageID(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
		    // �ر���Դ
			DBConnection.close(rs);								
			DBConnection.close(pstmt);							
			DBConnection.close(conn);							
		}
		return criticism;
	}
}
