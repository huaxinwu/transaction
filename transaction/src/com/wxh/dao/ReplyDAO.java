/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import java.util.List;

import com.wxh.bean.Reply;
import com.wxh.util.Page;

/**
 * �ظ���Ϣ������ݲ���
 * @author wxh
 * @version $Id: ReplyDAO.java, v 0.1 2017��7��20�� ����11:18:53 wxh Exp $
 */
public interface ReplyDAO {

    /**
     * �����ظ���Ϣ
     * @param reply
     */
    public void addReply(Reply reply);
    /**
     * ������ϢID��ѯ�ظ���Ϣ�б�
     * @param messageID
     * @param page
     * @return List
     */
    public List<Reply> findReplyByMsgId(int messageID,Page page);
    /**
     * ������ϢID��ѯ�ظ���Ϣ�ܼ�¼��
     * @param messageID
     * @return int
     */
    public int findCountByMsgId(int messageID);
}
