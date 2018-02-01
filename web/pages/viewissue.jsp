<%@include file="/parts/header-scripts.jsp" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/AllIssuesServlet"/>
<jsp:include page="/ModifyIssueServlet"/>




<!DOCTYPE html>
<html lang="en">

<head>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="../vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="../vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

    <%@include file="../parts/head.jsp" %>
    <body>
    <div id="wrapper">
        <%@include file="../parts/navigation.jsp" %>
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                <h1 class="page-header">Issue Menu</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">

                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="datatable">
                            <thead>
                            <tr>
                                <th>Title</th>
                                <th>State</th>
                                <th>Room</th>
                                <th>Building</th>
                                <th>Area</th>
                                <th>Description</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${issues}" var="issue">
                                    <% int i = 0;
                                        if (i%2==0) {%>
                                    <tr class="even gradeC">
                                        <td class="center">${issue.name}</td>
                                        <td class="center">${issue.state}</td>
                                        <td class="center">${issue.room}</td>
                                        <td class="center">${issue.building}</td>
                                        <td class="center">${issue.area}</td>
                                        <td class="center">${issue.description}</td>

                                    </tr>
                                    <% }else { %>

                                    <tr class="odd gradeX">
                                        <td class="center">${issue.name}</td>
                                        <td class="center">${issue.state}</td>
                                        <td class="center">${issue.room}</td>
                                        <td class="center">${issue.building}</td>
                                        <td class="center">${issue.area}</td>
                                        <td class="center">${issue.description}</td>

                                    </tr>
                                    <% } %>
                                </c:forEach>

                            </tbody>
                        </table>
                        </div>
                        <div id="modify"  style="display:none;" >
                        <form role="form" method="post" action="/ModifyIssueServlet">
                            <input type="text" id="title" name="title" readonly>  </input>
                            <input type="text" id="state" name="state" readonly>  </input>
                            <input type="text" id="room" name="room" readonly> </input>
                            <input type="text" id="building" name="building" readonly>  </input>
                            <input type="text" id="area" name="area" readonly>  </input>
                            <input type="text" id="description" name="description" readonly>  </input>
                            <div class="form-group">
                                <label>Change State or Delete</label>
                                <select class="form-control" id="newstate" name="newstate" required>
                                    <option value="" disabled selected>--Select--</option>
                                    <option value="New">New</option>
                                    <option value="Assigned">Assigned</option>
                                    <option value="In Testing">In Testing</option>
                                    <option value="Resolved">Resolved</option>
                                    <option value="Not Resolvable">Not Resolvable</option>
                                    <option value="delete">Delete Issue</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-default">Submit Changes</button>
                            <button type="reset" class="btn btn-default">Reset</button>
                        </form>
                        </div>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <!-- /.row -->


</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="../vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../dist/js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->

</div>
<div>


    </div>


</body>

<script>

    var title0 = document.getElementById("title")
    var state0 = document.getElementById("state")
    var room0 = document.getElementById("room")
    var building0 = document.getElementById("building")
    var area0 = document.getElementById("area")
    var des0 = document.getElementById("description")

    $(document).ready(function() {

        $('#datatable tbody').on('click', 'tr', function () {

            document.getElementById('modify').style.display = "block";
            var title = document.getElementById("datatable").rows[$(this).index()+1].cells[0].innerHTML;
            var state = document.getElementById("datatable").rows[$(this).index()+1].cells[1].innerHTML;
            var room = document.getElementById("datatable").rows[$(this).index()+1].cells[2].innerHTML;
            var building = document.getElementById("datatable").rows[$(this).index()+1].cells[3].innerHTML;
            var area = document.getElementById("datatable").rows[$(this).index()+1].cells[4].innerHTML;
            var description = document.getElementById("datatable").rows[$(this).index()+1].cells[5].innerHTML;

            title0.value = title;
            des0.value = description;
            room0.value = room;
            building0.value = building;
            area0.value = area;
            state0.value = state;

        })

    });

</script>

</html>