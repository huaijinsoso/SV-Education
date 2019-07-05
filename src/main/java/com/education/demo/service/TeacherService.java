package com.education.demo.service;

import com.education.demo.entity.Page;
import com.education.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> queryTeacher(Teacher teacher);

    Teacher queryTeacherById(int id);

    boolean operationTeacher(Teacher teacher);

    boolean deleteTeacher(int id);

    Page findTeacher4Page(Teacher teacher , Page page);
}
