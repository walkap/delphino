package servlet;

import bean.IssueBean;
import control.IssueHandlerController;
import exception.IssueException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddNewIssueServlet")
public class AddNewIssueServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");


        String area = request.getParameter("area");
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        String description = request.getParameter("description");
        String name = request.getParameter("name");

        IssueBean bean = new IssueBean(name,area,building,room,description);

        IssueHandlerController controller = new IssueHandlerController();
        try {
            controller.addNewIssue(bean);
        }catch(IssueException e) {
            request.getSession().setAttribute("alertIssue", "true");
        }

        response.sendRedirect("/pages/createissue.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
