<!DOCTYPE html>
<html lang="en">

<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></SCRIPT>
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
                <h1 class="page-header">Modify building</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-6">

                <div class="panel panel-default">

                    <div class="panel-heading">
                        Modify Building
                    </div>

                    <div class="panel-body">

                        <div class="row">

                            <div class="col-lg-12">
                    <form role="form" action="/DeleteBuildingServlet" method="post">
                        <fieldset>
                            <div class="form-group">
                                <label>Seleziona MacroArea</label>
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
                                    <div class="form-group">
                                        <label>Seleziona Edificio</label>
                                        <select class="form-control" name = "building" id="building" required>
                                        </select>
                                    </div>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <div>
                                <input name = "delete" value ="delete" id="delete" class="btn btn-lg btn-success btn-block" onclick="deletePressed" type="submit">
                            </div>
                            </fieldset>
                    </form>
                <!-- Change this to a button or input when using this as a form -->
                <div>
                </div>
                            <input value = "modify" class="btn btn-lg btn-success btn-block" type="button" onclick="showDiv()">
                            <div id="modify"  style="display:none;" >
                                <form role="form" action="/ModifyBuildingServlet" method="post">
                                    <input type="text" id="oldarea" name="oldarea" readonly><br>
                                    <input type="text" id="oldname" name="oldname" readonly><br>

                                Select new name :
                                <input type="text" name="newname" id ="newname" required> </br>
                                Select new Area :<br>
                            <select class="form-control" name = "newarea" id="newarea" required>
                                <option value="" disabled selected>--Select--</option>
                                <option value="Lettere e Filosofia">Lettere e Filosofia</option>
                                <option value="Ingegneria">Ingegneria</option>
                                <option value="Scienze Matematiche">Scienze Matematiche</option>
                                <option value="Medicina">Medicina</option>
                                <option value="Economia">Economia</option>
                                <option value="Giurisprudenza">Giurisprudenza</option>
                            </select>
                                    <input value = "Submit changes" class="btn btn-lg btn-success btn-block" type="submit">

                               </form>
                            </div>

                            </div>
            </div>
        </div>
    </div>
</div>
</div>
    </div>
</div>


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
    function showDiv() {
        var area = document.getElementById("area").value
        var building = document.getElementById("building").value

        document.getElementById('modify').style.display = "block";
        var oldarea = document.getElementById("oldarea")
        var oldname = document.getElementById("oldname")
        oldarea.value = area
        oldname.value = building

    }
</script>

</html>