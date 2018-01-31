
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
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

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
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
                <h1 class="page-header">Create new issue</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">

                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form" method="post" action ="/AddNewIssueServlet">
                                    <div class="form-group">
                                        <label>Select Area</label>
                                        <select class="form-control" name = "area" id="area" required>
                                            <option value="" disabled selected>--Select--</option>
                                            <option value="Lettere e Filosofia">Lettere e Filosofia</option>
                                            <option value="Ingegneria">Ingegneria</option>
                                            <option value="Scienze Matematiche">Scienze Matematiche</option>
                                            <option value="Medicina">Medicina</option>
                                            <option value="Economia">Economia</option>
                                            <option value="Giurisprudenza">Giurisprudenza</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Select Building</label>
                                        <select class="form-control" name = "building" id="building" required>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Selects Room</label>
                                        <select class="form-control" name = "room" id = "room" required>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Insert title</label>
                                        <input class="form-control" name ="name" required>
                                        <p class="help-block">Example block-level help text here.</p>
                                    </div>
                                    <div class="form-group">
                                        <label>Insert description</label>
                                        <textarea class="form-control" rows="3" name = "description"></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-default">Submit Button</button>
                                    <button type="reset" class="btn btn-default">Reset Button</button>
                                </form>
                            </div>
                            <!-- /.col-lg-6 (nested) -->
                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="../vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../dist/js/sb-admin-2.js"></script>

</body>

<script type="text/javascript">

    $area=$("#area");
    $area.change (
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

    $area=$("#building");
    $area.change (
        function()  {
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/GetRoomsServlet",
                data: {"area" : $('#area').val(), "building" : $('#building').val()},
                success: function(data){
                    $("#room").html(data)
                }
            });
        }
    );

</script>

</html>
