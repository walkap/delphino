<%
    request.getSession().invalidate();
    response.sendRedirect("login.jsp");
%>