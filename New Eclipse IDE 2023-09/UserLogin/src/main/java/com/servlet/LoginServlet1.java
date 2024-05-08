package com.servlet;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/login")
public class LoginServlet1 extends HttpServlet {

    private static final String SECRET_KEY = "yourSecretKey"; // Replace with a secure key
    private static final long EXPIRATION_TIME = 60000; // 1 minute in milliseconds

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET requests, if necessary
        response.sendRedirect(request.getContextPath() + "/UserSignin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean isAuthenticated = authenticateUser(email, password);

        // Perform authentication

        if (isAuthenticated) {
            String jwtToken = Jwts.builder()
                    .setSubject(email)
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                    .compact();

            response.setHeader("Authorization", "Bearer " + jwtToken);
            response.sendRedirect(request.getContextPath() + "/Success.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/UserSignin.jsp");
        }
    }

    private boolean authenticateUser(String email, String password) {
        // Replace this with your actual authentication logic (querying a database, calling an authentication service, etc.)
        // For now, let's assume a simple hardcoded check
        return "correctEmail@example.com".equals(email) && "correctPassword".equals(password);
    }
}
