package com.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;

import com.Dao.DAO;
import com.Model.UserModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DAO UserDao;
    private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(Servlet.class);

    public void init() throws ServletException {
    	UserDao = new DAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        List<UserModel> listUser = UserDao.selectAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserModel existingUser = UserDao.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        // Extract parameters from the request
        String name = request.getParameter("name"); 
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String contact = request.getParameter("contact");
        String gender = request.getParameter("gender");
        String[] areaOfIntrest = request.getParameterValues("areaOfIntrest");
        String areaOfIntrest1 = (areaOfIntrest != null) ? String.join(", ", areaOfIntrest) : null;
        
        try {
			if(UserDao.validateuseremail(email)) {
				request.setAttribute("error", "Email is already exists.Please try with another email...");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			     dispatcher.forward(request, response);
			     logger.info("Email is already exists.Please try with another email...");
			}else {
			// Create a new User object
			UserModel newUser = new UserModel(name, email, country, contact, gender, areaOfIntrest1);
			// Insert the new user into the database
			UserDao.insertUser(newUser);
			// Redirect to the list page after insertion
			response.sendRedirect("list");
			logger.info("User Inserted Successfully..");
   }
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        // Extract parameters from the request
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String contact = request.getParameter("contact");
        String gender = request.getParameter("gender");
        String[] areaOfIntrest = request.getParameterValues("areaOfIntrest");
        String areaOfIntrest1 = (areaOfIntrest != null) ? String.join(", ", areaOfIntrest) : null;
        UserModel user = new UserModel(id, name, email, country, contact, gender, areaOfIntrest1);
        UserDao.updateUser(user);
        response.sendRedirect("list");
        logger.info("User Record Updated Successfully.");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        // ParseInt is used to convert String to int
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao.deleteUser(id);
        response.sendRedirect("list");
        logger.info("User Record Deleted Successfully..");
    }
}