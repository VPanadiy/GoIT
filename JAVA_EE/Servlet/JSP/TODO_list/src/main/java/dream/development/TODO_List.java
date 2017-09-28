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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@WebServlet("/taskList")
public class TODO_List extends HttpServlet {

    public static final Logger LOGGER = LoggerFactory.getLogger(TODO_List.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Hello Method POST. TaskList Page");
        HttpSession session = request.getSession();

        getFirstAndLastName(request, session);

        getCounterValue(request);

        List<Task> taskList = (List<Task>) session.getAttribute("list");
        if (request.getParameter("taskName") == null || request.getParameter("taskDescription") == null
                || Objects.equals(request.getParameter("taskName"), "") || Objects.equals(request.getParameter("taskDescription"), "")) {
            LOGGER.info("TaskName = " + request.getParameter("taskName"));
            LOGGER.info("TaskDescription = " + request.getParameter("taskDescription"));

        } else {
            Task task = new Task();

            LOGGER.info("TaskName = " + request.getParameter("taskName"));
            LOGGER.info("TaskDescription = " + request.getParameter("taskDescription"));

            if (taskList != null) {
                task.setId(taskList.size() + 1);
            } else {
                LOGGER.info("taskList is null. Create new ArrayList");
                taskList = new ArrayList<>();
                task.setId(1);
            }

            task.setTaskName(String.valueOf(request.getParameter("taskName")));
            task.setTaskDescription(String.valueOf(request.getParameter("taskDescription")));
            task.setStatus(false);
            task.setDelete(false);

            taskList.add(task);
        }

        removeButton(request, taskList);

        CheckButton(request, taskList);

        request.setAttribute("taskList", taskList);

        String destination = "/taskList.jsp";
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(destination);
        requestDispatcher.forward(request, response);
    }

    private void CheckButton(HttpServletRequest request, List<Task> taskList) {
        if (taskList != null) {
            if (request.getParameter("isDone") == null || Objects.equals(request.getParameter("isDone"), "")) {
                LOGGER.info("isDone is null");
            } else {
                LOGGER.info("isDone value = " + request.getParameter("isDone"));
                Long isDone = Long.valueOf(request.getParameter("isDone"));
                for (Task task : taskList) {
                    if (task.getId() == isDone) {
                        boolean checkStatus = task.isStatus();
                        task.setStatus(!checkStatus);
                    }
                }
            }
        }
    }

    private void removeButton(HttpServletRequest request, List<Task> taskList) {
        if (taskList != null) {
            if (request.getParameter("indexForRemove") == null || Objects.equals(request.getParameter("indexForRemove"), "")) {
                LOGGER.info("indexForRemove is null");
            } else {
                LOGGER.info("indexForRemove value = " + request.getParameter("indexForRemove"));
                Long indexForRemove = Long.valueOf(request.getParameter("indexForRemove"));
                for (Task task : taskList) {
                    if (task.getId() == indexForRemove) {
                        task.setDelete(true);
                    }
                }
            }
        }
    }

    private void getCounterValue(HttpServletRequest request) {
        LOGGER.info("Hello Method \"getCounterValue\"");
        HttpSession session = request.getSession();
        Object o = session.getAttribute("counter");

        Integer counter;
        if (o == null) {
            counter = 0;
        } else {
            counter = Integer.valueOf(o.toString());
        }

        session.setAttribute("time", new Date());

        session.setAttribute("counter", ++counter);
        LOGGER.info("Method \"getCounterValue\" return = " + counter);
    }

    private void getFirstAndLastName(HttpServletRequest request, HttpSession session) {
        LOGGER.info("First Name = " + request.getParameter("first_name"));
        LOGGER.info("Last Name = " + request.getParameter("last_name"));

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        if (firstName != null && lastName != null) {
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
        }
    }
}
