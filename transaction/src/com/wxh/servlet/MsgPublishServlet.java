/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxh.bean.Employee;
import com.wxh.bean.Message;
import com.wxh.dao.MessageDAO;
import com.wxh.factory.MessageDAOFactory;

/**
 * 发布消息：用户输入消息标题、消息内容
 * @author wxh
 * @version $Id: MsgPublishServlet.java, v 0.1 2017年7月20日 下午10:10:49 wxh Exp $
 */
@SuppressWarnings("serial")
public class MsgPublishServlet extends HttpServlet {

    /**
    	 * Constructor of the object.
    	 */
    public MsgPublishServlet() {
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
        // 设置请求参数编码为GBK
        request.setCharacterEncoding("gbk");
        // 收集参数(消息标题、消息内容)_
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        // 上下文对象
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = null;
        // 获取当前登录员工，确定是哪个员工发布的消息
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if(employee==null){
            request.setAttribute("error", "要发布消息先进行身份识别！");
            dispatcher = servletContext.getRequestDispatcher("/publishNewMsg.jsp");
        }else{
            if(title==null ||"".equals(title)){
                request.setAttribute("error", "请输入消息标题!");
                dispatcher = servletContext.getRequestDispatcher("/publishNewMsg.jsp");
            }else{
                //将用户输入数据封装到对象中
                Message message = new Message();
                message.setMessageTitle(title);
                message.setMessageContent(content);
                message.setEmployeeID(employee.getEmployeeID());
                message.setPublishTime(new Date());
                
                // 数据访问接口将数据插入到数据库表中
                MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
                messageDAO.addMessage(message);
                // 跳转回消息发布页面
                dispatcher = servletContext.getRequestDispatcher("/GetMessageList");
            }
        }
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
