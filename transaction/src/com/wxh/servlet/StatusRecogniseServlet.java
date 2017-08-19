/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxh.bean.Employee;
import com.wxh.dao.EmployeeDAO;
import com.wxh.factory.EmployeeDAOFactory;

/**
 * 员工身份识别:员工编号和系统口令进行身份识别，登录
 * @author wxh
 * @version $Id: StatusRecogniseServlet.java, v 0.1 2017年7月19日 下午10:26:28 wxh Exp $
 */
@SuppressWarnings("serial")
public class StatusRecogniseServlet extends HttpServlet {

    /**
    	 * Constructor of the object.
    	 */
    public StatusRecogniseServlet() {
        super();
    }

    /**
    	 * Destruction of the servlet. <br>
    	 */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
    	 * The doGet method of the servlet. <br>
    	 *
    	 * This method is called when a form has its tag value method equals to get.
    	 * 
    	 * @param request the request send by the client to the server
    	 * @param response the response send by the server to the client
    	 * @throws ServletException if an error occurred
    	 * @throws IOException if an error occurred
    	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                                                                               throws ServletException,
                                                                             IOException {
        // 获取上下文对象
        ServletContext servletContext = getServletContext();
        
        RequestDispatcher dispatcher = null;
        // 收集参数
        String employeeID = request.getParameter("employeeID");
        String password = request.getParameter("password");

        // 对用户输入的数据进行判断并处理
        if(employeeID==null|| "".equals(employeeID)){
            request.setAttribute("error", "请输入员工编号!");
            dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
        }else{
            if(password==null || "".equals(password)){
                request.setAttribute("error", "请输入系统口令!");
                dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
            }else{
                // 获取employeeDAO实例
                EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
                Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));
                if(employee == null|| "".equals(employee)){
                    request.setAttribute("error", "该员工编号不存在!");
                    dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
                }else{
                    if(password.equals(employee.getPassword())){
                        // 员工编号和系统口令都正确,存入session
                        request.getSession().setAttribute("employee", employee);
                        // 身份识别通过，进行主页界面
                        response.sendRedirect("index.jsp");
                        return;
                    }else{
                        request.setAttribute("error", "该系统口令不正确!");
                        dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
                    }
                }
            }
        }
        // 控制器将数据转发到视图(页面)
        dispatcher.forward(request, response);
    }

    /**
    	 * The doPost method of the servlet. <br>
    	 *
    	 * This method is called when a form has its tag value method equals to post.
    	 * 
    	 * @param request the request send by the client to the server
    	 * @param response the response send by the server to the client
    	 * @throws ServletException if an error occurred
    	 * @throws IOException if an error occurred
    	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
                                                                                throws ServletException,
                                                                                IOException {

        doGet(request, response);
    }

    /**
    	 * Initialization of the servlet. <br>
    	 *
    	 * @throws ServletException if an error occurs
    	 */
    public void init() throws ServletException {
        // Put your code here
    }

}
