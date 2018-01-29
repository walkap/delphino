package servlet;

import control.BuildingController;
import exception.BuildingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyBuildingServlet")
public class ModifyBuildingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        String area = request.getParameter("oldarea");
        String name = request.getParameter("oldname");
        String newarea = request.getParameter("newarea");
        String newname = request.getParameter("newname");
        try {
            BuildingController controller = new BuildingController();
            controller.modifyBuilding(name, area, newname, newarea);

            response.sendRedirect("/pages/selectBuilding.jsp");
        } catch (BuildingException e) {
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
