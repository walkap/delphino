package servlet;

import control.BuildingController;
import entity.Building;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GetBuildingsServlet")
public class GetBuildingsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String area = request.getParameter("area");

        BuildingController buildingController = new BuildingController();

        ArrayList<String> buildings = buildingController.getBuildings(area);

        System.out.println("doGet(): " + buildings);

        try {
            for (int i = 0; i < buildings.size(); i++) {

                out.print("<option value = " + buildings.get(i) + ">" + buildings.get(i) + "</option>");
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
