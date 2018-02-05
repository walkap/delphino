package servlet.room;

import control.HandleRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteRoomServlet")
public class DeleteRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get the id from the session
        int id = Integer.parseInt(request.getParameter("id"));
        //Call the controller
        HandleRoom handleRoom = new HandleRoom();
        try {
            //Delete the room by id
            handleRoom.deleteRoom(handleRoom.getRoomById(id));
            //Redirect to the all rooms page
            response.sendRedirect("/pages/all-rooms.jsp");
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
