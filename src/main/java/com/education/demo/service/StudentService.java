package com.education.demo.service;

import com.education.demo.entity.Page;
import com.education.demo.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> queryStudent(Student student);

    Student queryStudentById(int id);

    boolean operationStudent(Student student);

    boolean deleteStudent(int id);

    Page findStudent4Page(Student student , Page page);
}
