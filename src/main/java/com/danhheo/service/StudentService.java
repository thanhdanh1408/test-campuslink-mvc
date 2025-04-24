package com.danhheo.service;

import com.danhheo.dao.StudentDAO;
import com.danhheo.model.Student;

import javax.sql.DataSource;
import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService(DataSource dataSource) {
        this.studentDAO = new StudentDAO(dataSource);
    }

    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    public List<Student> searchStudents(String keyword) {
        return studentDAO.searchStudents(keyword);
    }
}