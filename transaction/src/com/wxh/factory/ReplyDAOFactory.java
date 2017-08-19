/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.ReplyDAO;
import com.wxh.dao.impl.ReplyDAOImpli;

/**
 * 工厂方法创建ReplyDAO
 * @author wxh
 * @version $Id: ReplyDAOFactory.java, v 0.1 2017年8月3日 下午9:38:15 wxh Exp $
 */
public class ReplyDAOFactory {

    /** 
     * 生产ReplyDAO
     * @return ReplyDAO
     */
    public static ReplyDAO getReplyDAOInstance(){
        return new ReplyDAOImpli();
    }
}
