package servlet.templateRoomServlet;

import control.TemplateRoomController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteTemplateRoomServlet")
public class DeleteTemplateRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        TemplateRoomController tRC = new TemplateRoomController();
        int res;

        try {
            tRC.deleteTemplateRoom(name);
            res = 3;
            request.getSession().setAttribute("res",res);
            response.sendRedirect("/pages/viewTemplateRooms.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
