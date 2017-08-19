/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxh.bean.Message;
import com.wxh.dao.MessageDAO;
import com.wxh.factory.MessageDAOFactory;
import com.wxh.util.Page;
import com.wxh.util.PageUtil;

/**
 * ��ʾ��Ϣ�б�
 * @author wxh
 * @version $Id: GetMessageListServlet.java, v 0.1 2017��7��20�� ����10:41:56 wxh Exp $
 */
@SuppressWarnings("serial")
public class GetMessageListServlet extends HttpServlet {

    /**
    	 * Constructor of the object.
    	 */
    public GetMessageListServlet() {
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

        
        int currentPage = 0;
        // ��ȡ��ǰҳ��
        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr == null || "".equals(currentPageStr)){
            // ���ǰ̨����ĵ�ǰҳ��Ϊ�ջ��߿��ַ��������õ�ǰҳ��Ϊ��ҳ
            currentPage = 1;
        }else{
            // ����ת��
            currentPage = Integer.parseInt(currentPageStr);
        }
        
        // ��ȡ��ҳ������Ϣ�б�����
        MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
        // ÿҳ��ʾ5����¼
        Page page = PageUtil.createPage(5, messageDAO.findAllCount(), currentPage);
        
        List<Message> messages = messageDAO.findAllMessage(page);
        
        // ����request�У���ҳ��ʹ��
        request.setAttribute("messageList", messages);
        request.setAttribute("page", page);
        
        // �����Ķ���
        ServletContext servletContext = getServletContext();
        // ��ת����Ϣ�б�ҳ��
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/msgList.jsp");
        // ת��request��response����ǰ̨
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
