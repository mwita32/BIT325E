<%@page import="com.patient.PatientDAO" %>
<%@page import="com.patient.Patient" %>
<%
  int id = Integer.parseInt(request.getParameter("id"));
  Patient p = PatientDAO.getPatientById(id);
%>
<form action="EditPatientServlet" method="post">
  <input type="hidden" name="id" value="<%=p.getId()%>"/>
  Name: <input type="text" name="name" value="<%=p.getName()%>"/><br/>
  Age: <input type="number" name="age" value="<%=p.getAge()%>"/><br/>
  Gender: <input type="text" name="gender" value="<%=p.getGender()%>"/><br/>
  Diagnosis: <input type="text" name="diagnosis" value="<%=p.getDiagnosis()%>"/><br/>
  Admission Date: <input type="date" name="admissionDate" value="<%=p.getAdmissionDate()%>"/><br/>
  <input type="submit" value="Update"/>
</form>
