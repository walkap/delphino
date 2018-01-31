<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.TemplateRoom" %>


<jsp:useBean id="templateRooms" scope="session" class="bean.TemplateRoomBean"/>
<jsp:setProperty name="templateRooms" property="*"/>

<%
    TemplateRoom templateRoom = templateRooms.viewTemplateRoom(request.getParameter("name"));

%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<%@include file="../parts/head.jsp" %>
<body>
<div id="wrapper">
    <%@include file="../parts/navigation.jsp" %>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Update Template Room "<%= templateRoom.getNameTemplate() %>"
                </h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" action="<c:url value="/ModifyTemplateRoomServlet"/>" method="post">
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" id="name" class="form-control" disabled
                                               value="<%=templateRoom.getNameTemplate()%>">
                                        <input type="hidden" name="name" value="<%=templateRoom.getNameTemplate()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="board">Board</label>
                                        <input type="text" id="board" class="form-control" name="board"
                                               placeholder="Type the kind of board..."
                                               value="<%= templateRoom.getBoard()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="computers">Computers</label>
                                        <input type="number" id="computers" class="form-control" name="computers"
                                               placeholder="Type the number of computers..."
                                               value="<%=templateRoom.getComputers()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="seats">Seats</label>
                                        <input type="number" id="seats" class="form-control" name="seats"
                                               placeholder="Type the number of seats..."
                                               value="<%=templateRoom.getSeats()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="projectors">Projectors</label>
                                        <input type="number" id="projectors" class="form-control" name="projectors"
                                               placeholder="Type the number of projectors..."
                                               value="<%=templateRoom.getProjectors()%>">
                                    </div>
                                    <div class="form-group">
                                        <div class="checkbox">
                                            <label for="desk">
                                                <input type="checkbox" name="hasDesk" id="desk"
                                                       value="true"
                                                    <%if(templateRoom.getDesk()) out.print("checked");%> >desk
                                            </label>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 col-lg-10 pull-right">
                                        <div class="pull-right">
                                            <button type="reset" class="btn btn-default">Reset</button>
                                            <button type="submit" class="btn btn-default">Update</button>
                                        </div>
                                    </div>
                                </form>
                                <div class="col-sm-12 col-lg-2 pull-left">
                                    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                        Delete
                                    </button>
                                </div>
                                <!-- Modal -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                                     aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-hidden="true">
                                                    &times;
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel">Delete Template
                                                    Room <%=templateRoom.getNameTemplate()%>
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                Delete the Template Room <%=templateRoom.getNameTemplate()%> ?
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal"
                                                        style="margin-right: 10px">Close
                                                </button>
                                                <form class="pull-right"
                                                      action="<c:url value="/DeleteTemplateRoomServlet"/>"
                                                      method="post">
                                                    <input type="hidden" name="name"
                                                           value="<%=templateRoom.getNameTemplate()%>">
                                                    <button type="submit" class="btn btn-primary">Delete</button>
                                                </form>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal-dialog -->
                                </div>
                                <!-- /.modal -->
                            </div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->

    <%@include file="../parts/footer-scripts.jsp" %>

</body>
</html>
