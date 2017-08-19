/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.dao;

import java.util.List;

import com.wxh.bean.Reply;
import com.wxh.util.Page;

/**
 * 回复消息相关数据操作
 * @author wxh
 * @version $Id: ReplyDAO.java, v 0.1 2017年7月20日 下午11:18:53 wxh Exp $
 */
public interface ReplyDAO {

    /**
     * 新增回复消息
     * @param reply
     */
    public void addReply(Reply reply);
    /**
     * 根据消息ID查询回复消息列表
     * @param messageID
     * @param page
     * @return List
     */
    public List<Reply> findReplyByMsgId(int messageID,Page page);
    /**
     * 根据消息ID查询回复消息总记录数
     * @param messageID
     * @return int
     */
    public int findCountByMsgId(int messageID);
}
