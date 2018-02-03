package servlet.feature;

import control.FeatureController;
import entity.Feature;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreateFeatureServlet")
public class CreateFeatureServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        PrintWriter out = response.getWriter();
        int res;
        FeatureController fC = new FeatureController();
        System.out.println(name);
        System.out.println(description);
        try {
            if(fC.getFeature(name) == null){
                fC.createFeature(name, description);
                /*out.println("<script type=\"text/javascript\">");
                out.println("window.alert('Feature created');");
                out.println("</script>");*/
                res = 1;
                request.getSession().setAttribute("res",res);

            }else{
                /*out.println("<script type=\"text/javascript\">");
                out.println("alert('Feature is present in System, change name');");
                out.println("</script>");*/
                res = 2;
                request.getSession().setAttribute("res",res);

            }

            //request.setAttribute("res",res);
            //request.getRequestDispatcher("/pages/createFeature.jsp").forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            response.sendRedirect("/pages/createFeature.jsp");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
