package servlet.templateRoomServlet;

import control.TemplateRoomController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CreateTemplateRoomServlet")
public class CreateTemplateRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int seats = 0;
        String board = "No board";
        int computers = 0;
        int projectors = 0;
        boolean desk;
        int res;

        response.setContentType("text/html");
        String name = request.getParameter("name");


        if (!request.getParameter("seats").isEmpty()) {
            seats = Integer.parseInt(request.getParameter("seats"));
        }

        if (!request.getParameter("board").isEmpty()) {
            board = request.getParameter("board");
        }

        if (!request.getParameter("computers").isEmpty()) {
            computers = Integer.parseInt(request.getParameter("computers"));
        }


        if (!request.getParameter("projectors").isEmpty()) {
            projectors = Integer.parseInt(request.getParameter("projectors"));
        }

        desk = request.getParameter("desk") != null;

        TemplateRoomController tRC = new TemplateRoomController();


        try {
            if (tRC.createTemplateRoom(name, seats, board, projectors, computers, desk)) {
                res = 1;
                request.getSession().setAttribute("res", res);
                response.sendRedirect("/pages/createTemplateRoom.jsp");
                //RequestDispatcher rd=request.getRequestDispatcher("/pages/createTemplateRoom.jsp");
                //rd.forward(request, response);
                System.out.println(tRC.createTemplateRoom(name, seats, board, projectors, computers, desk));
            } else {
                res = 2;
                request.getSession().setAttribute("res", res);
                response.sendRedirect("/pages/createTemplateRoom.jsp");
                //request.getSession().setAttribute();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
