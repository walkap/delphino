package servlet;

import control.BuildingController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteBuildingServlet")
public class DeleteBuildingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        String area = request.getParameter("area");
        String name = request.getParameter("building");

        BuildingController controller = new BuildingController();
        controller.deleteBuilding(name, area);

        response.sendRedirect("/pages/selectBuilding.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
