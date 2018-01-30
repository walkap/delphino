package servlet;

import bean.IssueBean;
import control.IssueHandlerController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ModifyIssueServlet")
public class ModifyIssueServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        String area = request.getParameter("area");
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        String description = request.getParameter("description");
        String name = request.getParameter("title");
        String newstate = request.getParameter("newstate");

        IssueBean bean = new IssueBean(name,area,building,room,description);
        IssueHandlerController controller = new IssueHandlerController();

        if (newstate.equals("delete")) {

            controller.deleteIssue(bean);

        } else {

            controller.updateIssue(bean, newstate);
        }

        response.sendRedirect("/pages/viewissue.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
