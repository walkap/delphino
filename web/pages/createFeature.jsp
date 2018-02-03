<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/parts/header-scripts.jsp" %>

<%
    if(!isAdmin && request.getSession().getAttribute("isLoggedIn") != null){
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
<%@include file="../parts/head.jsp" %>
<body>
<div id="wrapper">
    <%@include file="../parts/navigation.jsp" %>
    <div id="page-wrapper" style="min-height: 639px;">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Create Feature</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Template Room
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form role="form" action="<c:url value="/CreateFeatureServlet"/>" method="post">
                                    <div class="form-group">
                                        <label>Name</label>
                                        <input id="name" name="name" type="text" class="form-control"
                                               placeholder="Name of Feature" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Description</label>
                                        <input id="description" name="description" type="text" class="form-control"
                                               placeholder="Description of feature" required>
                                    </div>
                                    <button type="reset" class="btn btn-default">Cancel</button>
                                    <button type="submit" class="btn btn-primary">Confirm</button>

                                </form>
                            </div>
                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-6 -->
        </div>
        <!-- /.row -->
    </div>
</div>
<!-- /#wrapper -->


</body>

<script>

    <%
    int res;
    if (request.getSession().getAttribute("res")!= null){
        res = (int) request.getSession().getAttribute("res");
    }else{
        res = 0;
    }
    if (res == 1)
    { %>
            window.alert('Feature created');
    <%}%>
    <% request.getSession().setAttribute("res",0); %>

    <%if (res == 2)
    { %>
            alert('Feature is present in System, change name');
    <%}%>
    <% request.getSession().setAttribute("res",0); %>


</script>
</html>
