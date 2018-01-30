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
                <h1 class="page-header">Update room <%=room.getName()%></h1>
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
                                        <input type="text" id="name" class="form-control" name="name"
                                               placeholder="Type the room's name..." required value="<%=room.getName()%>">
                                        <p class="help-block">This is the room's name</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="area">Area</label>
                                        <select id="area" class="form-control" name="area" onchange="setOptionValue(value, this.id)" required>
                                            <% for(String area : areas){ %>
                                            <option value="<%=area%>" <% if(area.equals(room.getBuilding().getArea()))out.print("selected='selected'"); %>><%=area%></option>
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
                                               placeholder="Type the number of computers..." value="<%=room.getComputers()%>">
                                        <p class="help-block">This is the number of computers present in the room</p>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label for="type">Room's type</label>
                                        <select id="type" class="form-control" name="type" onchange="setOptionValue(value, this.id)" required>
                                            <% for(String type : types){ %>
                                               <option value="<%=type%>" <% if(type.equals(room.getType()))out.print("selected"); %>><%=type%></option>
                                            <% } %>
                                        </select>
                                        <p class="help-block">This is the kind of rooms</p>
                                    </div>

                                    <!-- TODO dynamic list -->
                                    <div class="form-group">
                                        <label for="building">Building</label>
                                        <select id="building" class="form-control" name="building" onchange="setOptionValue(value, this.id)" required>
                                            <option value="<%=room.getBuilding().getName()%>" selected><%=room.getBuilding().getArea()%></option>
                                        </select>
                                        <p class="help-block">This is the building where the room is located inside the area</p>
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
                                               placeholder="Type the number of projectors..." value="<%=room.getProjectors()%>">
                                        <p class="help-block">This is the number of the projectors present in the room</p>
                                    </div>
                                    <div class="form-group">
                                        <div class="checkbox">
                                            <label for="hasDesk">
                                                <input type="checkbox" name="hasDesk" id="hasDesk" value="true" <%if(room.hasTeacherDesk()) out.print("checked");%> >Is
                                                the desk present in the room?
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="pull-right">
                                        <button type="submit" class="btn btn-default">Update</button>
                                        <button type="reset" class="btn btn-default">RFeset</button>
                                    </div>
                                </div>
                            </form>
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

<script type="text/javascript" >
    function setOptionValue(value, element){
        var domRef = "select#" + element + " option:selected";
        var select = $(domRef);
        select.val(value).attr('selected', true).siblings('option').removeAttr('selected');
    }
</script>

</body>
</html>
