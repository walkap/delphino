<%@include file="/parts/header-scripts.jsp" %>
<%@ page import="entity.TemplateRoom" %>
<jsp:useBean id="templateRooms" scope="session" class="bean.TemplateRoomBean"/>
<jsp:setProperty name="templateRooms" property="*"/>
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
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Add new room</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-list-alt fa-fw"></i> Fill the form below to insert a new room
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <%
                            String message = "";
                            boolean success = false;
                            if(request.getSession().getAttribute("successMessage") != null){
                                if(request.getSession().getAttribute("successMessage").equals("ok")){
                                    message = "The room has been successfully added!";
                                    success = true;
                                }else if(request.getSession().getAttribute("successMessage").equals("not")){
                                    message = "Something wen wrong! The room has not been added!";
                                }
                            }%>
                        <% if(!message.equals("")){%>
                            <%if (success){%>
                                <div class="alert alert-success"><%=message%></div>
                            <%}else{ %>
                                <div class="alert alert-danger"><%=message%></div>
                            <%}%>
                        <%}%>
                        <% request.getSession().removeAttribute("successMessage");%>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label for="template">Template Room</label>
                                    <select id="template" class="form-control" name="template">
                                        <%
                                            for (TemplateRoom templateRoom : templateRooms.viewAllTemplateRooms()) {%>
                                        <option value="<%=templateRoom.getNameTemplate()%>"><%=templateRoom.getNameTemplate()%></option>
                                        <% } %>
                                    </select>
                                    <p class="help-block">Please select a template room if you want to pre-fill the some fields below</p>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <form role="form" action="/AddNewRoomServlet" method="post">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" id="name" class="form-control" name="name"
                                               placeholder="Type the room's name..." required>
                                        <p class="help-block">This is the room's name</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="area">Area</label>
                                        <select id="area" class="form-control" name="area" required>
                                            <option value="" disabled selected>--Select--</option>
                                            <option value="Lettere e Filosofia">Lettere e Filosofia</option>
                                            <option value="Ingegneria">Ingegneria</option>
                                            <option value="Scienze Matematiche">Scienze Matematiche</option>
                                            <option value="Medicina">Medicina</option>
                                            <option value="Economia">Economia</option>
                                            <option value="Giurisprudenza">Giurisprudenza</option>
                                        </select>
                                        <p class="help-block">Select the area you want to relate the room</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="board">Board</label>
                                        <input type="text" id="board" class="form-control" name="board"
                                               placeholder="Type the kind of board...">
                                        <p class="help-block">Type the kind of board present in the room, if there is no
                                            board at all let the field empty</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="computers">Computers</label>
                                        <input type="number" id="computers" class="form-control" name="computers"
                                               placeholder="Type the number of computers...">
                                        <p class="help-block">Type the number of the computers present in the room</p>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label for="type">Room's type</label>
                                        <select id="type" class="form-control" name="type" required>
                                            <option value="ClassRoom">ClassRoom</option>
                                            <option value="Laboratory">Laboratory</option>
                                            <option value="CongressHall">Congress Hall</option>
                                        </select>
                                        <p class="help-block">Select the type of the room</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="building">Building</label>
                                        <select id="building" class="form-control" name="building" required>
                                        </select>
                                        <p class="help-block">Select the building you want to relate the room</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="seats">Seats</label>
                                        <input type="number" id="seats" class="form-control" name="seats"
                                               placeholder="Type the number of seats...">
                                        <p class="help-block">This is the number of the seats of the room</p>
                                    </div>
                                    <div class="form-group">
                                        <label for="projectors">Projectors</label>
                                        <input type="number" id="projectors" class="form-control" name="projectors"
                                               placeholder="Type the number of projectors...">
                                        <p class="help-block">Type the number of the seats present in the room</p>
                                    </div>
                                    <div class="form-group">
                                        <div class="checkbox">
                                            <label for="hasDesk">
                                                <input type="checkbox" name="hasDesk" id="hasDesk" value="true">Is
                                                the desk present in the room?
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="pull-right">
                                        <button type="submit" class="btn btn-default">Submit</button>
                                        <button type="reset" class="btn btn-default">Reset</button>
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

<script type="text/javascript">
    $("#template").change(function () {
       $.ajax({
           type: "POST",
           url: "http://localhost:8080/GetTemplateRoomJSONServlet",
           data: {"template" : $('#template').val()},
           success: function (data) {
               var obj = JSON.parse(data);
               $("#board").val(obj.board);
               $("#computers").val(obj.computers);
               $("#seats").val(obj.seats);
               $("#projectors").val(obj.projectors);

               if(obj.hasDesk){
                   $("#hasDesk").attr("checked", true);
               }else{
                   $("#hasDesk").attr("checked", false);
               }
           }
       })
    });

    $("#area").change (
        function()  {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/GetBuildingsServlet",
                data: {"area" : $('#area').val()},
                success: function(data){
                    $("#building").html(data)
                }
            });
        }
    );



</script>
</body>
</html>