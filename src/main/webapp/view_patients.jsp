<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*" %>
<%@ page import="com.patient.PatientDAO, com.patient.Patient" %>

<%
    // Use the existing session object
    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>View Patients</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

    <!-- Welcome Message and Logout -->
    <div class="mb-4">
        <h4>
            Welcome, <%= session.getAttribute("username") %> |
            <a href="LogoutServlet" class="btn btn-outline-danger btn-sm">Logout</a>
        </h4>
    </div>

    <!-- Heading and Add Button -->
    <div class="d-flex justify-content-between mb-3">
        <h2>Patient List</h2>
        <a href="add_patient.jsp" class="btn btn-success">➕ Add New Patient</a>
    </div>

    <!-- Patient Table -->
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th><th>Name</th><th>Age</th><th>Gender</th>
                <th>Diagnosis</th><th>Admission Date</th><th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Patient> list = PatientDAO.getAllPatients();
            for (Patient p : list) {
        %>
            <tr>
                <td><%= p.getId() %></td>
                <td><%= p.getName() %></td>
                <td><%= p.getAge() %></td>
                <td><%= p.getGender() %></td>
                <td><%= p.getDiagnosis() %></td>
                <td><%= p.getAdmissionDate() %></td>
                <td>
                    <a class="btn btn-sm btn-primary" href="edit_patient.jsp?id=<%= p.getId() %>">Edit</a>
                    <a class="btn btn-sm btn-danger" href="DeletePatientServlet?id=<%= p.getId() %>" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>
