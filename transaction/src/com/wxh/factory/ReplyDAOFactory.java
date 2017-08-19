/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.ReplyDAO;
import com.wxh.dao.impl.ReplyDAOImpli;

/**
 * ������������ReplyDAO
 * @author wxh
 * @version $Id: ReplyDAOFactory.java, v 0.1 2017��8��3�� ����9:38:15 wxh Exp $
 */
public class ReplyDAOFactory {

    /** 
     * ����ReplyDAO
     * @return ReplyDAO
     */
    public static ReplyDAO getReplyDAOInstance(){
        return new ReplyDAOImpli();
    }
}
