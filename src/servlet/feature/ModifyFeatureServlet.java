package servlet.feature;

import control.FeatureController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyFeatureServlet")
public class ModifyFeatureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        FeatureController featureController = new FeatureController();

        try {
            featureController.updateFeature(name, description);
            System.out.println(featureController.getFeature(name).getName());
            System.out.println(featureController.getFeature(name).getDescription());

            //response.sendRedirect("/pages/editFeature.jsp?=" + featureController.getFeature(name).getName());
            response.sendRedirect("/pages/viewFeatures.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
