package servlet.feature;

import control.FeatureController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteFeatureServlet")
public class DeleteFeatureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int res;

        System.out.println("DESCRIZIONE" + description);

        FeatureController fC = new FeatureController();

        try {
            fC.deleteFeature(name, description);
            System.out.println("NOME" + name);
            System.out.println("DESCRIZIONE" + description);
            res = 1;
            request.getSession().setAttribute("res",res);
            response.sendRedirect("/pages/viewFeatures.jsp");


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
