package servlet.feature;

import control.FeatureController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateFeatureServlet")
public class CreateFeatureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        FeatureController featureController = new FeatureController();
        System.out.println(name);
        System.out.println(description);
        try {
            featureController.createFeature(name, description);


            response.sendRedirect("/pages/createFeature.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
