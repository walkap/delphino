<!-- Navigation -->
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.jsp">Delphino</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                </li>
                <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                </li>
                <li class="divider"></li>
                <li><a href="logout.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li class="sidebar-search">
                    <div class="input-group custom-search-form">
                        <input type="text" class="form-control" placeholder="Search...">
                        <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                    </div>
                    <!-- /input-group -->
                </li>
                <li>
                    <a href="index.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                </li>
                <li>
                    <a href="index.jsp"><i class="fa fa-cube fa-fw"></i> Rooms<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="all-rooms.jsp">All rooms</a>
                        </li>


                        <%
                            if(request.getSession().getAttribute("userType") != null){

                                if(request.getSession().getAttribute("userType").equals("admin")){ %>
                        <li>
                            <a href="add-new-room.jsp">Add new room</a>
                        </li>
                        <%      }
                            } %>
                    </ul>
                </li>

                <%
                    if(request.getSession().getAttribute("userType") != null){

                    if(request.getSession().getAttribute("userType").equals("admin")){ %>
                <li>
                    <a href="index.jsp"><i class="fa fa-cube fa-fw"></i> Template Rooms<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="createTemplateRoom.jsp">Create Template Room</a>
                        </li>
                        <li>
                            <a href="viewTemplateRooms.jsp">View, Modify, Delete a Template Room</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.jsp"><i class="fa fa-cube fa-fw"></i> Buildings<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="createBuilding.jsp">Add new building</a>
                        </li>
                        <li>
                            <a href="selectBuilding.jsp">Modify buildings</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="index.jsp"><i class="fa fa-cube fa-fw"></i> Issues<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="createissue.jsp">Add new issue</a>
                        </li>
                        <li>
                            <a href="viewissue.jsp">Update issues</a>
                        </li>
                    </ul>
                </li>

                <% } } %>

            </ul>
        </div>
        <!-- /.sidebar-collapse -->
    </div>
    <!-- /.navbar-static-side -->
</nav>