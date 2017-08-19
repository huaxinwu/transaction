/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import java.util.List;

import com.wxh.bean.Message;
import com.wxh.util.Page;

/**
 * ��Ϣ���ݲ���
 * @author wxh
 * @version $Id: MessageDAO.java, v 0.1 2017��7��19�� ����10:58:57 wxh Exp $
 */
public interface MessageDAO {

    /**
     * ������Ϣ��Ϣ
     * @param message
     */
    public void addMessage(Message message);
    /**
     * ������Ϣ��Ϣ
     * @param message
     */
    public void updateMesage(Message message);
    /**
     * ͨ��messageIDɾ����Ϣ��Ϣ
     * @param messageID
     */
    public void deleteMessageById(int messageID);
    /**
     * ��ѯ������Ϣ��Ϣ
     * @return List
     */
    public List<Message> findAllMessage(Page page);
    /**
     * ͨ��messageID��ѯ��Ϣ��Ϣ
     * @param messageID
     * @return Message
     */
    public Message findMessageById(int messageID);
    /**��
     * ��ѯ��Ϣ������
     * @return int
     */
    public int findAllCount();
}
