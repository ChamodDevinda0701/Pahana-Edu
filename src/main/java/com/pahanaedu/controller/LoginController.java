package com.pahanaedu.controller;

import com.pahanaedu.dto.UserDto;
import com.pahanaedu.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private AuthenticationService authService;

    @Override
    public void init() throws ServletException {
        super.init();
        authService = new AuthenticationService(); // Initialize your service here
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to login.jsp page
        request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve username and password from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate user credentials
        UserDto user = authService.authenticate(username, password);

        if (user != null) {
            // Login successful: save user info in session
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", user);

            // Redirect to home/dashboard page after login
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            // Login failed: set error message and forward back to login page
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}


