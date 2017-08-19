/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.factory;

import com.wxh.dao.EmployeeDAO;
import com.wxh.dao.impl.EmployeeDAOImpl;

/**
 * ������������EmployeeDAO
 * @author wxh
 * @version $Id: EmployeeDAOFactory.java, v 0.1 2017��7��19�� ����10:20:45 wxh Exp $
 */
public class EmployeeDAOFactory {

    /**
     *  ����EmployeeDAO 
     * @return EmployeeDAO
     */
    public static EmployeeDAO getEmployeeDAOInstance(){
        return new EmployeeDAOImpl(); 
    }
}
