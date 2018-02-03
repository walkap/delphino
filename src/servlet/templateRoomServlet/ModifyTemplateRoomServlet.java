package servlet.templateRoomServlet;

import control.TemplateRoomController;
import entity.TemplateRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyTemplateRoomServlet")
public class ModifyTemplateRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int seats = 0;
        String board = "No Board";
        int projectors = 0;
        int computers = 0;
        boolean desk;
        TemplateRoomController tRC = new TemplateRoomController();
        int res;



        response.setContentType("text/html");
        String name = request.getParameter("name");

        if (!request.getParameter("seats").isEmpty()) {
            seats = Integer.parseInt(request.getParameter("seats"));
        }
        if (!request.getParameter("board").isEmpty()) {
            board = request.getParameter("board");
        }
        if (!request.getParameter("projectors").isEmpty()) {
            projectors = Integer.parseInt(request.getParameter("projectors"));
        }
        if (!request.getParameter("computers").isEmpty()) {
            computers = Integer.parseInt(request.getParameter("computers"));
        }
        desk = request.getParameter("desk") != null;


        try {
            TemplateRoom templateRoom = new TemplateRoom(name, seats, board,
                    projectors, computers, desk);
            res = tRC.modifyTemplateRoom(templateRoom);
            request.getSession().setAttribute("res",res);
            response.sendRedirect("/pages/editTemplateRoom.jsp?name=" + tRC.getTemplateRoom(name).getNameTemplate());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
