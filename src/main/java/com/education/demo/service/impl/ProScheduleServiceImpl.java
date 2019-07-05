package com.education.demo.service.impl;

import com.education.demo.dao.ProScheduleDao;
import com.education.demo.entity.Page;
import com.education.demo.entity.ProSchedule;
import com.education.demo.service.ProScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProScheduleServiceImpl implements ProScheduleService {
    @Autowired
    private ProScheduleDao proScheduleDao;
    @Override
    public List<ProSchedule> queryProSchedule(ProSchedule proSchedule) {
        return (List<ProSchedule>)proScheduleDao.selectByPage(proSchedule);
    }

    @Override
    public ProSchedule queryProScheduleById(int id) {
        return proScheduleDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationProSchedule(ProSchedule proSchedule) {
        if(0 == proSchedule.getSchId()){
            return proScheduleDao.insert(proSchedule) > 0 ? true : false;
        } else {
            return proScheduleDao.updateByPrimaryKey(proSchedule) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteProSchedule(int id) {
        return proScheduleDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findProSchedule4Page(ProSchedule proSchedule, Page page) {
        proSchedule.setPage(page.getPage());
        proSchedule.setRows(page.getRows());
        page.setRecords(proScheduleDao.selectProScheduleCount());
        page.setGridObjectData(proScheduleDao.selectByPage(proSchedule));
        return page;
    }
}
