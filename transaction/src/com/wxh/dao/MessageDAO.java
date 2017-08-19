/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import java.util.List;

import com.wxh.bean.Message;
import com.wxh.util.Page;

/**
 * 消息数据操作
 * @author wxh
 * @version $Id: MessageDAO.java, v 0.1 2017年7月19日 下午10:58:57 wxh Exp $
 */
public interface MessageDAO {

    /**
     * 新增消息信息
     * @param message
     */
    public void addMessage(Message message);
    /**
     * 更新消息信息
     * @param message
     */
    public void updateMesage(Message message);
    /**
     * 通过messageID删除消息信息
     * @param messageID
     */
    public void deleteMessageById(int messageID);
    /**
     * 查询所有消息信息
     * @return List
     */
    public List<Message> findAllMessage(Page page);
    /**
     * 通过messageID查询消息信息
     * @param messageID
     * @return Message
     */
    public Message findMessageById(int messageID);
    /**、
     * 查询消息总条数
     * @return int
     */
    public int findAllCount();
}
