package com.education.demo.service.impl;

import com.education.demo.dao.CooperationDao;
import com.education.demo.entity.Cooperation;
import com.education.demo.entity.Page;
import com.education.demo.service.CooperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CooperationServiceImpl implements CooperationService {
    @Autowired
    private CooperationDao cooperationDao;
    @Override
    public List<Cooperation> queryCooperation(Cooperation cooperation) {
        return (List<Cooperation>)cooperationDao.selectByPage(cooperation);
    }

    @Override
    public Cooperation queryCooperationById(int id) {
        return cooperationDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationCooperation(Cooperation cooperation) {
        if(0 == cooperation.getCooperationId()){
            return cooperationDao.insert(cooperation) > 0 ? true : false;
        } else {
            return cooperationDao.updateByPrimaryKey(cooperation) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteCooperation(int id) {
        return cooperationDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findCooperation4Page(Cooperation cooperation, Page page) {
        cooperation.setPage(page.getPage());
        cooperation.setRows(page.getRows());
        page.setRecords(cooperationDao.selectCooperationCount());
        page.setGridObjectData(cooperationDao.selectByPage(cooperation));
        return page;
    }
}
