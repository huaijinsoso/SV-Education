package com.education.demo.service.impl;

import com.education.demo.dao.SpecialtyDao;
import com.education.demo.entity.Page;
import com.education.demo.entity.Specialty;
import com.education.demo.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyDao specialtyDao;

    @Override
    public List<Specialty> querySpecialty(Specialty specialty) {
        return (List<Specialty>)specialtyDao.selectByPage(specialty);
    }

    @Override
    public Specialty querySpecialtyById(int id) {
        return specialtyDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationSpecialty(Specialty specialty) {
        if(0 == specialty.getSpeConId()){
            return specialtyDao.insert(specialty) > 0 ? true : false;
        } else {
            return specialtyDao.updateByPrimaryKey(specialty) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteSpecialty(int id) {
        return specialtyDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findSpecialty4Page(Specialty specialty, Page page) {
        specialty.setPage(page.getPage());
        specialty.setRows(page.getRows());
        page.setRecords(specialtyDao.selectSpecialtyCount());
        page.setGridObjectData(specialtyDao.selectByPage(specialty));
        return page;
    }
}
