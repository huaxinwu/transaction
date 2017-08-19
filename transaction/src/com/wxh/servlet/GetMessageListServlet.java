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
 * 显示消息列表
 * @author wxh
 * @version $Id: GetMessageListServlet.java, v 0.1 2017年7月20日 下午10:41:56 wxh Exp $
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
        // 获取当前页码
        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr == null || "".equals(currentPageStr)){
            // 如果前台传入的当前页码为空或者空字符串，设置当前页码为首页
            currentPage = 1;
        }else{
            // 类型转换
            currentPage = Integer.parseInt(currentPageStr);
        }
        
        // 获取分页对象、消息列表数据
        MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
        // 每页显示5条记录
        Page page = PageUtil.createPage(5, messageDAO.findAllCount(), currentPage);
        
        List<Message> messages = messageDAO.findAllMessage(page);
        
        // 存入request中，供页面使用
        request.setAttribute("messageList", messages);
        request.setAttribute("page", page);
        
        // 上下文对象
        ServletContext servletContext = getServletContext();
        // 跳转到消息列表页面
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/msgList.jsp");
        // 转发request，response对象到前台
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
