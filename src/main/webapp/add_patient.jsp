<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Patient</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            padding: 40px;
        }
        .form-container {
            background: #fff;
            border-radius: 10px;
            padding: 20px 30px;
            width: 400px;
            margin: auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label, input, select {
            display: block;
            width: 100%;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            background: #28a745;
            color: white;
            border: none;
            padding: 10px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
        }
        input[type="submit"]:hover {
            background: #218838;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Add Patient</h2>
    <form action="AddPatientServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" required />

        <label for="age">Age:</label>
        <input type="number" name="age" required />

        <label for="gender">Gender:</label>
        <select name="gender" required>
            <option value="">Select Gender</option>
            <option>Male</option>
            <option>Female</option>
        </select>

        <label for="diagnosis">Diagnosis:</label>
        <input type="text" name="diagnosis" required />

        <label for="admissionDate">Admission Date:</label>
        <input type="date" name="admissionDate" required />

        <input type="submit" value="Add Patient"/>
    </form>
</div>

</body>
</html>
