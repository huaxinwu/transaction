/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import com.wxh.bean.Criticism;
/**
 * ������Ϣ���ݲ���
 * @author wxh
 * @version $Id: CriticismDAO.java, v 0.1 2017��8��3�� ����10:47:55 wxh Exp $
 */
public interface CriticismDAO {
	/**
	 * ����������Ϣ
	 * @param criticism
	 */
	public void addCriticism(Criticism criticism);		
	/**
	 * ������ID��������
	 * @param messageID
	 * @return Criticism
	 */
	public Criticism findCriticismByMsgID(int messageID);
}
