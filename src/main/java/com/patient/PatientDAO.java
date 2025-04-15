package com.patient;
import java.sql.*;
import java.util.*;

public class PatientDAO {
	public static int addPatient(Patient p) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO patients (name, age, gender, diagnosis, admission_date) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, p.getName());
        ps.setInt(2, p.getAge());
        ps.setString(3, p.getGender());
        ps.setString(4, p.getDiagnosis());
        ps.setString(5, p.getAdmissionDate());
        return ps.executeUpdate();
    }

    public static List<Patient> getAllPatients() throws Exception {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM patients");
        List<Patient> list = new ArrayList<>();
        while (rs.next()) {
            Patient p = new Patient();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setAge(rs.getInt("age"));
            p.setGender(rs.getString("gender"));
            p.setDiagnosis(rs.getString("diagnosis"));
            p.setAdmissionDate(rs.getString("admission_date"));
            list.add(p);
        }
        return list;
    }

    public static Patient getPatientById(int id) throws Exception {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM patients WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Patient p = new Patient();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setAge(rs.getInt("age"));
            p.setGender(rs.getString("gender"));
            p.setDiagnosis(rs.getString("diagnosis"));
            p.setAdmissionDate(rs.getString("admission_date"));
            return p;
        }
        return null;
    }

    public static int updatePatient(Patient p) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE patients SET name=?, age=?, gender=?, diagnosis=?, admission_date=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, p.getName());
        ps.setInt(2, p.getAge());
        ps.setString(3, p.getGender());
        ps.setString(4, p.getDiagnosis());
        ps.setString(5, p.getAdmissionDate());
        ps.setInt(6, p.getId());
        return ps.executeUpdate();
    }

    public static int deletePatient(int id) throws Exception {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM patients WHERE id=?");
        ps.setInt(1, id);
        return ps.executeUpdate();
    }
}
