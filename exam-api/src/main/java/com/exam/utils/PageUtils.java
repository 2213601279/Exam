package com.exam.utils;

public class PageUtils {
    public static int getCurrentPage(Integer currentPage, int total) {
        //计算当前页的值
        int maxPage = total / 5 + 1;
        if (currentPage == null) {
            currentPage = 1;
        } else if (currentPage < 1) {
            currentPage = 1;
        } else if (currentPage > maxPage) {
            currentPage = maxPage;
        }
        return currentPage;
    }
}
