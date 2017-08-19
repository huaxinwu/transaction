/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.CriticismDAO;
import com.wxh.dao.impl.CriticismDAOImpl;
/**
 * 工厂方法创建CriticismDAO
 * @author wxh
 * @version $Id: CriticismDAOFactory.java, v 0.1 2017年8月3日 下午10:44:50 wxh Exp $
 */
public class CriticismDAOFactory {
	/**
	 * 生产CriticismDAO 
	 * @return CriticismDAO
	 */
	public static CriticismDAO getCriticismDAOInstance(){	
		return new CriticismDAOImpl();						
	}
}
