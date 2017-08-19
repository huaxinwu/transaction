/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.CriticismDAO;
import com.wxh.dao.impl.CriticismDAOImpl;
/**
 * ������������CriticismDAO
 * @author wxh
 * @version $Id: CriticismDAOFactory.java, v 0.1 2017��8��3�� ����10:44:50 wxh Exp $
 */
public class CriticismDAOFactory {
	/**
	 * ����CriticismDAO 
	 * @return CriticismDAO
	 */
	public static CriticismDAO getCriticismDAOInstance(){	
		return new CriticismDAOImpl();						
	}
}
