package com.synergix.service;

import com.synergix.model.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "studentData", eager = true)
@SessionScoped
public class StudentService implements Serializable {
    private static final long serialVersionUID = 1L;

        public List<Student> getStudentsList() throws SQLException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = JdbcConnection.getConnection();
        String stm = "select * from student";
        List<Student> students = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(stm);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setSname(resultSet.getString(2));
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return students;
    }
}
