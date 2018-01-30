<%@ page import="bean.RoomBean" %>
<%@ page import="entity.room.Room" %>
<%@ page import="util.RoomTypes" %>
<%@ page import="util.Area" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    RoomBean roomBean = new RoomBean();
    Room room = roomBean.getRoom(Integer.parseInt(request.getParameter("id")));
    String[] types = RoomTypes.getTypes();
    String[] areas = Area.getAreas();
%>

<!DOCTYPE html>
<html lang="en">
<%@include file="../parts/head.jsp" %>
<body>
<div id="wrapper">
    <%@include file="../parts/navigation.jsp" %>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Update room <%=room.getName()%>
                </h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-list-alt fa-fw"></i> Update the room modifying the fields below
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <form role="form" action="/UpdateRoomServlet" method="post">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" id="name" class="form-control"
                                               placeholder="Type the room's name..." disabled
                                               value="<%=room.getName()%>">
                                        <input type="hidden" name="name" value="<%=room.getName()%>">
                                        <p class="help-block">This is the room's name</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="area">Area</label>
                                        <select id="area" class="form-control" name="area"
                                                onchange="setOptionValue(value, this.id)" required>
                                            <% for (String area : areas) { %>
                                            <option value="<%=area%>" <%if (area.equals(room.getBuilding().getArea()))
                                                out.print("selected='selected'"); %>><%=area%>
                                            </option>
                                            <% } %>
                                        </select>
                                        <p class="help-block">This is the area where the room is located</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="board">Board</label>
                                        <input type="text" id="board" class="form-control" name="board"
                                               placeholder="Type the kind of board..." value="<%= room.getBoard()%>">
                                        <p class="help-block">This is the kind of board present in the class</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="computers">Computers</label>
                                        <input type="number" id="computers" class="form-control" name="computers"
                                               placeholder="Type the number of computers..."
                                               value="<%=room.getComputers()%>">
                                        <p class="help-block">This is the number of computers present in the room</p>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label for="type">Room's type</label>
                                        <select id="type" class="form-control" name="type"
                                                onchange="setOptionValue(value, this.id)" required>
                                            <% for (String type : types) { %>
                                            <option value="<%=type%>" <%
                                                if (type.equals(room.getType())) out.print("selected"); %>><%=type%>
                                            </option>
                                            <% } %>
                                        </select>
                                        <p class="help-block">This is the kind of rooms</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="building">Building</label>
                                        <select id="building" class="form-control" name="building"
                                                onchange="setOptionValue(value, this.id)" required>
                                            <option value="<%=room.getBuilding().getName()%>"
                                                    selected><%=room.getBuilding().getArea()%>
                                            </option>
                                        </select>
                                        <p class="help-block">This is the building where the room is located inside the
                                            area</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="seats">Seats</label>
                                        <input type="number" id="seats" class="form-control" name="seats"
                                               placeholder="Type the number of seats..." value="<%=room.getSeats()%>">
                                        <p class="help-block">This is the number of the seats of the room</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="projectors">Projectors</label>
                                        <input type="number" id="projectors" class="form-control" name="projectors"
                                               placeholder="Type the number of projectors..."
                                               value="<%=room.getProjectors()%>">
                                        <p class="help-block">This is the number of the projectors present in the
                                            room</p>
                                    </div>
                                    <div class="form-group">
                                        <div class="checkbox">
                                            <label for="hasDesk">
                                                <input type="checkbox" name="hasDesk" id="hasDesk"
                                                       value="true" <%if(room.hasTeacherDesk()) out.print("checked");%> >Is
                                                the desk present in the room?
                                            </label>
                                        </div>
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
                                <!-- Button trigger modal -->
                                <button class="btn btn-danger" data-toggle="modal" data-target="#myModal">
                                    Delete
                                </button>
                            </div>
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                                 aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                &times;
                                            </button>
                                            <h4 class="modal-title" id="myModalLabel">Delete room <%=room.getName()%></h4>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure you want to delete the room <%=room.getName()%>?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal" style="margin-right: 10px">Close</button>
                                            <form class="pull-right" action="/DeleteRoomServlet" method="post">
                                                <input type="hidden" name="id" value="<%=room.getId()%>">
                                                <button type="submit" class="btn btn-danger">Delete</button>
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
            <!-- /.col-lg-8 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->

<%@include file="../parts/footer-scripts.jsp" %>

<script type="text/javascript">
    function setOptionValue(value, element) {
        var domRef = "select#" + element + " option:selected";
        var select = $(domRef);
        select.val(value).attr('selected', true).siblings('option').removeAttr('selected');
    }
</script>

</body>
</html>
