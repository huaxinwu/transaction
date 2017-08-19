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
 * Ա�����ʶ��:Ա����ź�ϵͳ����������ʶ�𣬵�¼
 * @author wxh
 * @version $Id: StatusRecogniseServlet.java, v 0.1 2017��7��19�� ����10:26:28 wxh Exp $
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
        // ��ȡ�����Ķ���
        ServletContext servletContext = getServletContext();
        
        RequestDispatcher dispatcher = null;
        // �ռ�����
        String employeeID = request.getParameter("employeeID");
        String password = request.getParameter("password");

        // ���û���������ݽ����жϲ�����
        if(employeeID==null|| "".equals(employeeID)){
            request.setAttribute("error", "������Ա�����!");
            dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
        }else{
            if(password==null || "".equals(password)){
                request.setAttribute("error", "������ϵͳ����!");
                dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
            }else{
                // ��ȡemployeeDAOʵ��
                EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
                Employee employee = employeeDAO.findEmployeeById(Integer.parseInt(employeeID));
                if(employee == null|| "".equals(employee)){
                    request.setAttribute("error", "��Ա����Ų�����!");
                    dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
                }else{
                    if(password.equals(employee.getPassword())){
                        // Ա����ź�ϵͳ�����ȷ,����session
                        request.getSession().setAttribute("employee", employee);
                        // ���ʶ��ͨ����������ҳ����
                        response.sendRedirect("index.jsp");
                        return;
                    }else{
                        request.setAttribute("error", "��ϵͳ�����ȷ!");
                        dispatcher = servletContext.getRequestDispatcher("/statusRecognise.jsp");
                    }
                }
            }
        }
        // ������������ת������ͼ(ҳ��)
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
