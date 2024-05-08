package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.dao.EmployeeDAO;
import com.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
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
                    insertEmployee(request, response);
                    break;
                case "/delete":
                    deleteEmployee(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        List<Employee> listEmployee = employeeDAO.selectAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int Employee_No = Integer.parseInt(request.getParameter("Employee_No"));
        Employee existingEmployee = employeeDAO.selectEmployee(Employee_No);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String First_Name = request.getParameter("First_Name");
        String Last_Name = request.getParameter("Last_Name");
        String Designation = request.getParameter("Designation");
        String DOB = request.getParameter("DOB");
        String Email = request.getParameter("Email");
        String Mobile_No = request.getParameter("Mobile_No");
        Employee newEmployee = new Employee(First_Name, Last_Name, Designation, DOB, Email, Mobile_No);
        employeeDAO.insertEmployee(newEmployee);
        response.sendRedirect("list");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        String First_Name = request.getParameter("First_Name");
        String Last_Name = request.getParameter("Last_Name");
        String Designation = request.getParameter("Designation");
        String DOB = request.getParameter("DOB");
        String Email = request.getParameter("Email");
        String Mobile_No = request.getParameter("Mobile_No");
        int Employee_No = Integer.parseInt(request.getParameter("Employee_No"));
        Employee updatedEmployee = new Employee(Employee_No,First_Name, Last_Name, Designation, DOB, Email, Mobile_No);
        employeeDAO.updateEmployee(updatedEmployee);
        response.sendRedirect("list");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int Employee_No = Integer.parseInt(request.getParameter("Employee_No"));
        employeeDAO.deleteUser(Employee_No);
        response.sendRedirect("list");
    }
}
