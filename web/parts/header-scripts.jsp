<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    boolean isAdmin = false;
    if(request.getSession().getAttribute("userType") != null){
        isAdmin = request.getSession().getAttribute("userType").equals("admin");
    }

    if(request.getSession().getAttribute("isLoggedIn") == null){
        response.sendRedirect("login.jsp");
    }
%>