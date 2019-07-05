package com.education.demo.service.impl;

import com.education.demo.dao.SchoolUserDao;
import com.education.demo.entity.Page;
import com.education.demo.entity.SchoolUser;
import com.education.demo.service.SchoolUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolUserServiceImpl implements SchoolUserService {

    @Autowired
    private SchoolUserDao schoolUserDao;
    
    @Override
    public List<SchoolUser> querySchoolUser(SchoolUser schoolUser) {
        return (List<SchoolUser>)schoolUserDao.selectByPage(schoolUser);
    }

    @Override
    public SchoolUser querySchoolUserById(int id) {
        return schoolUserDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationSchoolUser(SchoolUser schoolUser) {
        if(0 == schoolUser.getSuserId()){
            return schoolUserDao.insert(schoolUser) > 0 ? true : false;
        } else {
            return schoolUserDao.updateByPrimaryKey(schoolUser) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteSchoolUser(int id) {
        return schoolUserDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findSchoolUser4Page(SchoolUser schoolUser, Page page) {
        schoolUser.setPage(page.getPage());
        schoolUser.setRows(page.getRows());
        page.setRecords(schoolUserDao.selectSchoolUserCount());
        page.setGridObjectData(schoolUserDao.selectByPage(schoolUser));
        return page;
    }
}
