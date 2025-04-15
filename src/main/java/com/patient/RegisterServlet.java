package com.patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegisterServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        try (Connection con = DBConnection.getConnection()) {
	            String checkSql = "SELECT * FROM users WHERE username=?";
	            PreparedStatement checkStmt = con.prepareStatement(checkSql);
	            checkStmt.setString(1, username);
	            ResultSet rs = checkStmt.executeQuery();

	            if (rs.next()) {
	                response.getWriter().println("<h3>Username already exists.</h3>");
	            } else {
	                String insertSql = "INSERT INTO users (username, password) VALUES (?, ?)";
	                PreparedStatement insertStmt = con.prepareStatement(insertSql);
	                insertStmt.setString(1, username);
	                insertStmt.setString(2, password);
	                int result = insertStmt.executeUpdate();

	                if (result > 0) {
	                    response.sendRedirect("login.jsp");
	                } else {
	                    response.getWriter().println("<h3>Registration failed. Try again.</h3>");
	                }
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("Database error: " + e.getMessage());
	        }
		doGet(request, response);
	}

}
