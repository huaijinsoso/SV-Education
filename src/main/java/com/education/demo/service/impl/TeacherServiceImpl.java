package com.education.demo.service.impl;

import com.education.demo.dao.TeacherDao;
import com.education.demo.entity.Page;
import com.education.demo.entity.Teacher;
import com.education.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> queryTeacher(Teacher teacher) {
        return (List<Teacher>)teacherDao.selectByPage(teacher);
    }

    @Override
    public Teacher queryTeacherById(int id) {
        return teacherDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationTeacher(Teacher teacher) {
        if(0 == teacher.getTeacherId()){
            return teacherDao.insert(teacher) > 0 ? true : false;
        } else {
            return teacherDao.updateByPrimaryKey(teacher) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteTeacher(int id) {
        return teacherDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findTeacher4Page(Teacher teacher, Page page) {
        teacher.setPage(page.getPage());
        teacher.setRows(page.getRows());
        page.setRecords(teacherDao.selectTeacherCount());
        page.setGridObjectData(teacherDao.selectByPage(teacher));
        return page;
    }
}
