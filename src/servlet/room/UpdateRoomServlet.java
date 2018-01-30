package servlet.room;

import control.HandleRoom;
import exception.room.InsertRoomException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateRoomServlet")
public class UpdateRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int computers = 0;
        int seats = 0;
        int projectors = 0;
        boolean hasDesk;
        String board = "";

        response.setContentType("text/html");
        String name = request.getParameter("name");
        String building = request.getParameter("building");
        String area = request.getParameter("area");
        String type = request.getParameter("type");

        if (!request.getParameter("board").isEmpty()) {
            board = request.getParameter("board");
        }
        if (!request.getParameter("computers").isEmpty()) {
            computers = Integer.parseInt(request.getParameter("computers"));
        }
        if (!request.getParameter("seats").isEmpty()) {
            seats = Integer.parseInt(request.getParameter("seats"));
        }
        if (!request.getParameter("projectors").isEmpty()) {
            projectors = Integer.parseInt(request.getParameter("projectors"));
        }
        hasDesk = request.getParameter("hasDesk") != null;
        HandleRoom handleRoom = new HandleRoom();
        try {
            handleRoom.updateRoom(name, type, building, area, board, hasDesk, seats, projectors, computers);
            response.sendRedirect("/pages/single-room.jsp?id=" + handleRoom.getRoomByName(name).getId());
        } catch (InsertRoomException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
