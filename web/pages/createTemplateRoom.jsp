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
                <h1 class="page-header">Create Template Room</h1>
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
                                <form role="form" action="<c:url value="/CreateTemplateRoomServlet"/>" method="post">
                                    <div class="form-group">
                                        <label>Name</label>
                                        <input id="name" name="name" type="text" class="form-control"
                                               placeholder="Name of Template Room" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Seats</label>
                                        <input id="seats" name="seats" type="text" class="form-control"
                                               placeholder="Numbers of seats">
                                    </div>
                                    <div class="form-group">
                                        <label>Board</label>
                                        <input id="board" name="board" type="text" class="form-control"
                                               placeholder="Name of board">
                                    </div>
                                    <div class="form-group">
                                        <label>Projectors</label>
                                        <input id="projectors" name="projectors" type="text" class="form-control"
                                               placeholder="Numbers of projectors">
                                    </div>
                                    <div class="form-group">
                                        <label>Computers</label>
                                        <input id="computers" name="computers" type="text" class="form-control"
                                               placeholder="Numbers of computers">
                                    </div>
                                    <div class="form-group">
                                        <label>Desk</label>
                                        <div class="checkbox">
                                            <label>
                                                <input id="desk" name="desk" type="checkbox">
                                            </label>
                                        </div>

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
</html>
