package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import com.dao.userDAO;
import com.model.userModel;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // Object Creation for userDAO class
        userDAO userdao = new userDAO();

        try {
            if (userdao.userExistsByEmail(email)) {
                // Display an alert message using JavaScript
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User with this email already exists. Please login to continue.');");
                out.println("window.location.replace('UserSignin.jsp');");
                out.println("</script>");
            } else {
                userModel usermodel = new userModel(firstName, lastName, contact, address, email, password);
                String result = userdao.insert(usermodel);

                if (result.equals("Data Entered Successfully")) {
                    // Display an alert message using JavaScript
                    response.setContentType("text/html");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('User Registered Successfully.Please login to continue..');");
                    out.println("window.location.replace('UserSignin.jsp');");
                    out.println("</script>");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

