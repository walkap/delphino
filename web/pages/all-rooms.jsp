<%@ page import="entity.room.Room" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="rooms" scope="session" class="bean.room.AllRoomsBean"/>
<jsp:setProperty name="rooms" property="*"/>

<!DOCTYPE html>
<html lang="en">
<%@include file="../parts/head.jsp" %>

<body>
<div id="wrapper">
    <%@include file="../parts/navigation.jsp" %>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">All rooms</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-list-alt fa-fw"></i> Rooms list
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Name</th>
                                    <th>Building</th>
                                    <th>Area</th>
                                    <th>Type</th>
                                    <th>Seats</th>
                                    <th>Board</th>
                                    <th>Projectors</th>
                                    <th>Computers</th>
                                    <th>Has desk?</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    int i = 1;
                                    for (Room room : rooms.getRooms()) {
                                %>
                                <tr>
                                    <td><%= i %>
                                    </td>

                                    <td><%= room.getName()%>
                                    </td>

                                    <td><%= room.getBuilding().getName() %>
                                    </td>

                                    <td><%= room.getBuilding().getArea() %>
                                    </td>

                                    <td><%= room.getType() %>
                                    </td>

                                    <td><%= room.getSeats() %>
                                    </td>

                                    <td><%= room.getBoard() %>
                                    </td>

                                    <td><%= room.getProjectors() %>
                                    </td>

                                    <td><%= room.getComputers() %>
                                    </td>

                                    <td><%= room.hasTeacherDesk()%>
                                    </td>

                                    <td>
                                        <a href="single-room.jsp?id=<%= room.getId() %>" type="button"
                                           class="btn btn-info btn-block">Edit</a>
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