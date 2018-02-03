<%@ page import="entity.Feature" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<jsp:useBean id="features" scope="session" class="bean.FeatureBean"/>
<jsp:setProperty name="features" property="*"/>

<!DOCTYPE html>
<html lang="en">
<%@include file="../parts/head.jsp" %>

<body>
<div id="wrapper">
    <%@include file="../parts/navigation.jsp" %>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Feature</h1>
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
                                    <th>Description</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    int i = 1;
                                    for (Feature feature : features.getAllFeatures()) {
                                %>
                                <tr>
                                    <td><%=i%>
                                    </td>

                                    <td><%=feature.getName()%>
                                    </td>

                                    <td><%=feature.getDescription()%>
                                    </td>

                                    <td>
                                        <a href="editFeature.jsp?name=<%=feature.getName()%>" type="button"
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

<script>

    <%
    int res;
    if (request.getSession().getAttribute("res")!= null){
        res = (int) request.getSession().getAttribute("res");
    }else{
        res = 0;
    }
    if (res == 1)
    { %>
    window.alert('Feature deleted');
    <%}%>
    <% request.getSession().setAttribute("res",0); %>
    <%
    if (res == 2)
    { %>
    window.alert('Feature updated');
    <%}%>
    <% request.getSession().setAttribute("res",0); %>


</script>
</html>