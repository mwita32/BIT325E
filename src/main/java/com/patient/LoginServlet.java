package com.patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        try (Connection con = DBConnection.getConnection()) {
	            String sql = "SELECT * FROM users WHERE username=? AND password=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, username);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                ww session = request.getSession();
	                session.setAttribute("username", username);
	                response.sendRedirect("view_patients.jsp");
	            } else {
	                response.getWriter().println("<h3>Login Failed. Invalid credentials.</h3>");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("Database error: " + e.getMessage());
	        }
		doGet(request, response);
	}

}
