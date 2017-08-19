/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxh.bean.Criticism;
import com.wxh.bean.Message;
import com.wxh.bean.Reply;
import com.wxh.dao.CriticismDAO;
import com.wxh.dao.MessageDAO;
import com.wxh.dao.ReplyDAO;
import com.wxh.factory.CriticismDAOFactory;
import com.wxh.factory.MessageDAOFactory;
import com.wxh.factory.ReplyDAOFactory;
import com.wxh.util.Page;
import com.wxh.util.PageUtil;

/**
 * 单条消息详情
 * @author wxh
 * @version $Id: GetMessageServlet.java, v 0.1 2017年7月20日 下午11:08:56 wxh Exp $
 */
@SuppressWarnings("serial")
public class GetMessageServlet extends HttpServlet {

    /**
    	 * Constructor of the object.
    	 */
    public GetMessageServlet() {
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

        
        // 收集参数
        int messageID = Integer.parseInt(request.getParameter("messageID"));
        
        // 根据消息ID查询单条消息信息
        MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
        Message message = messageDAO.findMessageById(messageID);
        
        // 将消息保存到request中
        request.setAttribute("message", message);
        
        // 获得该消息对应的所有回复
        int currentPage = 0;
        String currentPageStr = request.getParameter("currentPage");
        if(currentPageStr==null ||"".equals(currentPageStr)){
            currentPage = 1;
        }else {
            currentPage = Integer.parseInt(currentPageStr);
        }
        ReplyDAO replyDAO = ReplyDAOFactory.getReplyDAOInstance();
        // 每页显示5条数据
        Page page = PageUtil.createPage(5, replyDAO.findCountByMsgId(messageID), currentPage);
        List<Reply> repliys = replyDAO.findReplyByMsgId(messageID, page);
        
        request.setAttribute("replyList", repliys);
        request.setAttribute("page", page);
        
        
        // 批复人相关信息
        CriticismDAO criticismDAO = CriticismDAOFactory.getCriticismDAOInstance();
        Criticism criticism = criticismDAO.findCriticismByMsgID(messageID);
        request.setAttribute("criticism", criticism);
        
        /// 上下文对象
        ServletContext servletContext = getServletContext();
        // 跳转到单条消息页面
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/showMsg.jsp");
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
