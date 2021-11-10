package org.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userFirstName = request.getParameter("user_first_name");
        String userLastName = request.getParameter("user_last_name");
        String userGender = request.getParameter("user_gender");
        String userPass = request.getParameter("user_pass");
        boolean checkBox = request.getParameter("check")!= null;

        if (userFirstName.isEmpty() || userLastName.isEmpty() || userGender.isEmpty() ||
                userPass.isEmpty()) {
            RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/jsp/errorentryfield.jsp");
            req.include(request, response);
        } else if (userPass.length() < 6) {
            RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/jsp/errorpassword.jsp");
            req.forward(request, response);
        } else if (userFirstName.chars().anyMatch(Character::isDigit) || userLastName.chars().anyMatch(Character::isDigit)) {
            RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/jsp/errorname.jsp");
            req.forward(request, response);
        } else if (!checkBox) {
            RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/jsp/errorcheckbox.jsp");
            req.forward(request, response);
        } else {
            RequestDispatcher req = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
            req.forward(request, response);
        }
    }
}