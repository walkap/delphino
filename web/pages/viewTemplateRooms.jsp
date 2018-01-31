<%@ page import="entity.TemplateRoom" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="templateRooms" scope="session" class="bean.TemplateRoomBean"/>
<jsp:setProperty name="templateRooms" property="*"/>

<!DOCTYPE html>
<html lang="en">
<%@include file="../parts/head.jsp" %>

<body>
<div id="wrapper">
    <%@include file="../parts/navigation.jsp" %>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Template Rooms</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">

                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Seats</th>
                                    <th>Board</th>
                                    <th>Projectors</th>
                                    <th>Computers</th>
                                    <th>Desk</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    int i = 1;
                                    for (TemplateRoom templateRoom : templateRooms.viewAllTemplateRooms()) {
                                %>
                                <tr>
                                    <td><%= i %>
                                    </td>

                                    <td><%= templateRoom.getNameTemplate()%>
                                    </td>

                                    <td><%= templateRoom.getSeats() %>
                                    </td>

                                    <td><%= templateRoom.getBoard() %>
                                    </td>

                                    <td><%= templateRoom.getProjectors() %>
                                    </td>

                                    <td><%= templateRoom.getComputers() %>
                                    </td>

                                    <td><%= templateRoom.getDesk()%>
                                    </td>

                                    <td>
                                        <a href="editTemplateRoom.jsp?name=<%= templateRoom.getNameTemplate() %>" type="button"
                                           class="btn btn-default">Edit</a>
                                    </td>

                                </tr>

                                <% i++;
                                } %>

                                </tbody>
                            </table>
                            <!-- /.table-responsive -->

                        </div>
                        <!-- /.table-responsive -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-8 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<%@include file="../parts/footer-scripts.jsp" %>
</body>
</html>