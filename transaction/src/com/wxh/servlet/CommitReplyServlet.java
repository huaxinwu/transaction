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
import com.wxh.bean.Reply;
import com.wxh.dao.ReplyDAO;
import com.wxh.factory.ReplyDAOFactory;

/**
 * �ظ���Ϣ
 * @author wxh
 * @version $Id: CommitReplyServlet.java, v 0.1 2017��8��3�� ����9:44:16 wxh Exp $
 */
@SuppressWarnings("serial")
public class CommitReplyServlet extends HttpServlet {

    /**
    	 * Constructor of the object.
    	 */
    public CommitReplyServlet() {
        super();
    }

    /**
    	 * Destruction of the servlet. <br>
    	 * 
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
    	 * @param \request the request send by the client to the server
    	 * @param response the response send by the server to the client
    	 * @throws ServletException if an error occurred
    	 * @throws IOException if an error occurred
    	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                                                                               throws ServletException,
                                                                               IOException {

        request.setCharacterEncoding("gbk");
        String replyContent = request.getParameter("replyContent");
        int messageID = Integer.parseInt(request.getParameter("messageID"));
        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher = null;
        
        // ��ȡ��ǰ�ĵ�¼Ա����Ϣ��ȷ�����ĸ�Ա�������Ļظ���Ϣ
        Employee employee = (Employee) request.getSession().getAttribute("employee");
        if(employee == null){
            request.setAttribute("error", "Ҫ���лظ���Ϣ���ȱ���������ʶ��");
        }else{
            if(replyContent==null||"".equals(replyContent)){
                request.setAttribute("error", "��������ظ�����");
            }else{
                Reply reply = new Reply();
                reply.setReplyContent(replyContent);
                reply.setMessageID(messageID);
                reply.setEmployeeID(employee.getEmployeeID());
                reply.setReplyTime(new Date());
                
                ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
                replyDAO.addReply(reply);
            }
        }
        // ��ת���ظ���Ϣ�鿴ҳ��
        dispatcher = servletContext.getRequestDispatcher("/GetMessage?messageID="+messageID);
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
