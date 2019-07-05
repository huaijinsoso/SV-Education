package com.education.demo.service.impl;

import com.education.demo.dao.StudentDao;
import com.education.demo.entity.Student;
import com.education.demo.entity.Page;
import com.education.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> queryStudent(Student student) {
        return (List<Student>)studentDao.selectByPage(student);
    }

    @Override
    public Student queryStudentById(int id) {
        return studentDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationStudent(Student student) {
        if(0 == student.getStudentId()){
            return studentDao.insert(student) > 0 ? true : false;
        } else {
            return studentDao.updateByPrimaryKey(student) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findStudent4Page(Student student, Page page) {
        student.setPage(page.getPage());
        student.setRows(page.getRows());
        page.setRecords(studentDao.selectStudentCount());
        page.setGridObjectData(studentDao.selectByPage(student));
        return page;
    }
}
