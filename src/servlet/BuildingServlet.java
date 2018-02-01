package servlet;

import control.BuildingController;
import exception.BuildingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BuildingServlet")
public class BuildingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String area = request.getParameter("area");
            String name = request.getParameter("name");

                try {

                    BuildingController controller = new BuildingController();
                    controller.createNewBuilding(name, area);


                } catch (BuildingException e) {

                    request.getSession().setAttribute("alertBuilding","true");
                   /* RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/createBuilding.jsp");
                    rd.forward(request, response);*/

                }finally {

                    response.sendRedirect("/pages/createBuilding.jsp");
                    out.close();

                }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
