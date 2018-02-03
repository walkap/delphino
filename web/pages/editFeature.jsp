<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Feature" %>


<jsp:useBean id="features" scope="session" class="bean.FeatureBean"/>
<jsp:setProperty name="features" property="*"/>

<%
    Feature feature = features.getFeature(request.getParameter("name"));
    //System.out.println(feature.getName());
    //System.out.println(feature.getDescription());

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
                <h1 class="page-header">Update Feature "<%=feature.getName()%>"
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
                                <form role="form" action="<c:url value="/ModifyFeatureServlet"/>" method="post">
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" id="name" class="form-control" disabled
                                               value="<%=feature.getName()%>">
                                        <input type="hidden" name="name" value="<%=feature.getName()%>">
                                    </div>
                                    <div class="form-group">
                                        <label for="description">Description</label>
                                        <input type="text" id="description" class="form-control" name="description"
                                               placeholder="Description"
                                               value="<%=feature.getDescription()%>">
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
                                                <h4 class="modal-title" id="myModalLabel">Delete Feature
                                                    Room <%=feature.getName()%>
                                                </h4>
                                            </div>
                                            <div class="modal-body">
                                                Delete the Feature <%=feature.getName()%> ?
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal"
                                                        style="margin-right: 10px">Close
                                                </button>
                                                <form class="pull-right"
                                                      action="<c:url value="/DeleteFeatureServlet"/>"
                                                      method="post">
                                                    <input type="hidden" name="name"
                                                           value="<%=feature.getName()%>">
                                                    <input type="hidden" name="description"
                                                            value="<%=feature.getDescription()%>">
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
