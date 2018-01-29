package servlet.room;

import control.HandleRoom;
import entity.room.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "AllRoomsServlet")
public class AllRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HandleRoom handleRoom = new HandleRoom();

        Vector<Room> rooms = handleRoom.getAllRooms();

        System.out.println("AllRoomsServlet(): " + rooms);

        request.setAttribute("rooms", rooms);

        request.getRequestDispatcher("/all-rooms.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
