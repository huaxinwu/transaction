/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.EmployeeDAO;
import com.wxh.dao.impl.EmployeeDAOImpl;

/**
 * 工厂方法创建EmployeeDAO
 * @author wxh
 * @version $Id: EmployeeDAOFactory.java, v 0.1 2017年7月19日 下午10:20:45 wxh Exp $
 */
public class EmployeeDAOFactory {

    /**
     *  生产EmployeeDAO 
     * @return EmployeeDAO
     */
    public static EmployeeDAO getEmployeeDAOInstance(){
        return new EmployeeDAOImpl(); 
    }
}
