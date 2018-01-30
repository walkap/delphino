package servlet;

import bean.IssueBean;
import control.IssueHandlerController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AllIssuesServlet")
public class AllIssuesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Servlet");
        response.setContentType("text/html;charset=UTF-8");

        IssueHandlerController controller = new IssueHandlerController();

        ArrayList<IssueBean> issueBeans = controller.getIssueBeans();

        request.setAttribute("issues", issueBeans);

       /* RequestDispatcher view = request.getRequestDispatcher("/pages/viewissue.jsp");
        view.forward(request, response);*/
    }
}
