package servlet.room;

import control.HandleRoom;
import exception.room.MandatoryFieldsExceptions;
import exception.room.RoomAlreadyExistsExceptions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddNewRoomServlet")
public class AddNewRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        int computers = 0;
        int seats = 0;
        int projectors = 0;
        boolean hasDesk;
        //Get data from the form
        String name = request.getParameter("name");
        String building = request.getParameter("building");
        String area = request.getParameter("area");
        String type = request.getParameter("type");
        String board = request.getParameter("board");
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
        //Instantiate the controller
        HandleRoom handleRoom = new HandleRoom();
        try {
            //Insert the room
            handleRoom.insertRoom(name, type, building, area, board, hasDesk, seats, projectors, computers);

        } catch (RoomAlreadyExistsExceptions | MandatoryFieldsExceptions e) {
            e.printStackTrace();
        }finally {
            //Redirect the user to the same page refreshed
            response.sendRedirect("/pages/add-new-room.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
