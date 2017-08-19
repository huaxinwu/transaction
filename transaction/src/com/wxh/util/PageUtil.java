/**
 * wxh Inc.
 * Copyright (c) 2016-2017 All Rights Reserved.
 */
package com.wxh.util;
/**
 * 分页辅助类:创建分页，获取每页的记录数，获取总页数，获取总记录数，获取起始索引位置，是否有上一页，是否有下一页
 * @author wxh
 * @version $Id: PageUtil.java, v 0.1 2017年7月18日 下午9:55:34 wxh Exp $
 */
public class PageUtil {

    /**
     * 根据每页显示多少条记录数，总记录数，当前页码，获取分页信息
     * @param everyPage
     * @param totalCount
     * @param currentPage
     * @return Page
     */
    public static Page createPage(int everyPage,int totalCount,int currentPage){
        everyPage = getEveryPage(everyPage);
        currentPage = getCurrentPage(currentPage);
        int totalPage = getTotalPage(everyPage, totalCount);
        int beginIndex = getBeginIndex(everyPage, currentPage);
        boolean hasPrePage = getPrePage(currentPage);
        boolean hasNextPage = getNextPage(totalPage, currentPage);
        return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage);
    }
    
    /** 
     * 获取每页显示多少条记录
     * @param everyPage
     * @return
     */
    public static int getEveryPage(int everyPage){
        return everyPage == 0 ? 10 : everyPage;
    }
    /**
     * 获取当前页码
     * @param currentPage
     * @return
     */
    public static int getCurrentPage(int currentPage){
        return currentPage == 0 ? 1 : currentPage;
    }
    
    /**
     * 获取总页数
     * @param everyPage
     * @param totalCount
     * @return
     */
    public static int getTotalPage(int everyPage,int totalCount){
        return totalCount % everyPage == 0 ? totalCount / everyPage : totalCount / everyPage +1;
    }
    /**
     * 获取起始索引位置
     * @param everyPage
     * @param currentPage
     * @return
     */
    public static int getBeginIndex(int everyPage,int currentPage){
        return (currentPage - 1) * everyPage;
    }
    
    /**
     * 是否有上一页
     * @param currentPage
     * @return
     */
    public static boolean getPrePage(int currentPage){
        return currentPage == 1 ? false : true;
    }
    /**
     * 是否有下一页
     * @param totalPage
     * @param currentPage
     * @return
     */
    public static boolean getNextPage(int totalPage,int currentPage){
        return currentPage == totalPage || totalPage == 0 ? false : true;
    }
}
