<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<jsp:useBean id="loginBean" scope="session" class="bean.LoginBean"/>

<jsp:setProperty name="loginBean" property="*"/>

<!DOCTYPE html>
<html lang="en">

<%@include file="/parts/head.jsp"%>

<body>

<div class="container">

    <div class="row">

        <div class="col-md-4 col-md-offset-4">

            <hr style="background: transparent">
            <%
                if (request.getParameter("email") != null && request.getParameter("password") != null) {

                    if (loginBean.validate(request.getParameter("email"), request.getParameter("password"))) {

                        %><jsp:forward page="index.jsp"/><%

                    } else {

                        %><div class="alert alert-danger">Wrong data</div><%

                    }

                } else {

                    %><div class="alert alert-warning mt-2">Not logged in</div><%

                }
            %>

            <div class="login-panel panel panel-default">

                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="login.jsp" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="E-mail" id="email" name="email" type="email"
                                       autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" id="password" name="password"
                                       type="password">
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <div>
                                <input value="Login" class="btn btn-lg btn-success btn-block" type="submit">
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/parts/footer-scripts.jsp"%>

</body>

</html>
