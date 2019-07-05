package com.education.demo.service.impl;

import com.education.demo.dao.SchoolDao;
import com.education.demo.entity.Page;
import com.education.demo.entity.School;
import com.education.demo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    private SchoolDao schoolDao;
    @Override
    public List<School> querySchool(School school) {
        return (List<School>)schoolDao.selectByPage(school);
    }

    @Override
    public School querySchoolById(int id) {
        return schoolDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationSchool(School school) {
        if(0 == school.getSchoolId()){
            return schoolDao.insert(school) > 0 ? true : false;
        } else {
            return schoolDao.updateByPrimaryKey(school) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteSchool(int id) {
        return schoolDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findSchool4Page(School school, Page page) {
        school.setPage(page.getPage());
        school.setRows(page.getRows());
        page.setRecords(schoolDao.selectSchoolCount());
        page.setGridObjectData(schoolDao.selectByPage(school));
        return page;
    }
}
