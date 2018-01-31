package servlet.templateRoomServlet;

import control.TemplateRoomController;
import entity.TemplateRoom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetTemplateRoomJSONServlet")
public class GetTemplateRoomJSONServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String template = request.getParameter("template");

        TemplateRoomController trc = new TemplateRoomController();

        TemplateRoom tr = trc.getTemplateRoom(template);

        StringBuilder json = new StringBuilder();

        json.append("{\"name\":\"" + tr.getNameTemplate() + "\",")
                .append("\"seats\":\"" + tr.getSeats() + "\",")
                .append("\"board\":\"" + tr.getBoard() + "\",")
                .append("\"projectors\":\"" + tr.getProjectors() + "\",")
                .append("\"computers\":\"" + tr.getComputers() + "\",")
                .append("\"hasDesk\":" + tr.getDesk())
                .append("}");

        out.print(json);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
