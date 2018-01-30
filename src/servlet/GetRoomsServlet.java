package servlet;

import control.BuildingController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GetRoomsServlet")
public class GetRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String area = request.getParameter("area");
        String building = request.getParameter("building");

        BuildingController buildingController = new BuildingController();

        ArrayList<String> rooms = buildingController.getRoomsFromBuilding(area, building);

        try {
            out.print("<option value=\" \" disabled selected>--Select--</option>");
            for (int i = 0; i < rooms.size(); i++) {

                out.print("<option value = " + rooms.get(i) + ">" + rooms.get(i) + "</option>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
