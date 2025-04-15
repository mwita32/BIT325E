<form action="AddPatientServlet" method="post">
  Name: <input type="text" name="name"/><br/>
  Age: <input type="number" name="age"/><br/>
  Gender: <select name="gender">
    <option>Male</option><option>Female</option>
  </select><br/>
  Diagnosis: <input type="text" name="diagnosis"/><br/>
  Admission Date: <input type="date" name="admissionDate"/><br/>
  <input type="submit" value="Add Patient"/>
</form>
