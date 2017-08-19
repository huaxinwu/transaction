/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import com.wxh.bean.Criticism;
/**
 * 批复消息数据操作
 * @author wxh
 * @version $Id: CriticismDAO.java, v 0.1 2017年8月3日 下午10:47:55 wxh Exp $
 */
public interface CriticismDAO {
	/**
	 * 新增批复消息
	 * @param criticism
	 */
	public void addCriticism(Criticism criticism);		
	/**
	 * 按文章ID查找批复
	 * @param messageID
	 * @return Criticism
	 */
	public Criticism findCriticismByMsgID(int messageID);
}
