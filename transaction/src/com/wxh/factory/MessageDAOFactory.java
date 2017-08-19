/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.MessageDAO;
import com.wxh.dao.impl.MessageDAOImpl;

/**
 * ������������MessageDAO
 * @author wxh
 * @version $Id: MessageDAOFactory.java, v 0.1 2017��7��19�� ����11:00:40 wxh Exp $
 */
public class MessageDAOFactory {

    /**
     * ����MessageDAO
     * @return MessageDAO
     */
    public static MessageDAO getMessageDAOInstance(){
        return new MessageDAOImpl();
    }
}
