package dream.development;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Администратор on 20.08.2017.
 */
@WebServlet("/")
public class Login extends HttpServlet {

    public static final Logger LOGGER = LoggerFactory.getLogger(TODO_List.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Hello Method GET. Login Page");
        HttpSession session = request.getSession();

        getResponse(request, response, session);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Hello Method Post. Login Page");
        HttpSession session = request.getSession();

        getResponse(request, response, session);
    }

    private void getResponse(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        LOGGER.info("First Name = " + request.getParameter("first_name"));
        LOGGER.info("Last Name = " + request.getParameter("last_name"));

        request.setAttribute("firstName", request.getParameter("first_name"));
        request.setAttribute("lastName", request.getParameter("last_name"));

        String destination = "/taskList";
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(destination);
        requestDispatcher.forward(request, response);
    }
}
