package com.patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditPatientServlet")
public class EditPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public EditPatientServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
	            Patient p = new Patient();
	            p.setId(Integer.parseInt(request.getParameter("id")));
	            p.setName(request.getParameter("name"));
	            p.setAge(Integer.parseInt(request.getParameter("age")));
	            p.setGender(request.getParameter("gender"));
	            p.setDiagnosis(request.getParameter("diagnosis"));
	            p.setAdmissionDate(request.getParameter("admissionDate"));

	            PatientDAO.updatePatient(p);
	            response.sendRedirect("view_patients.jsp");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		doGet(request, response);
	}

}
