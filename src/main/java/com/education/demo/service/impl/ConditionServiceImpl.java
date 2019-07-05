package com.education.demo.service.impl;

import com.education.demo.dao.ConditionDao;
import com.education.demo.entity.Condition;
import com.education.demo.entity.Condition;
import com.education.demo.entity.Page;
import com.education.demo.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ConditionServiceImpl implements ConditionService {
    @Autowired
    private ConditionDao conditionDao;
    
    @Override
    public List<Condition> queryCondition(Condition condition) {
        return (List<Condition>)conditionDao.selectByPage(condition);
    }

    @Override
    public Condition queryConditionById(int id) {
        return conditionDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean operationCondition(Condition condition) {
        if(0 == condition.getSchoolConId()){
            return conditionDao.insert(condition) > 0 ? true : false;
        } else {
            return conditionDao.updateByPrimaryKey(condition) > 0 ? true : false;
        }
    }

    @Override
    public boolean deleteCondition(int id) {
        return conditionDao.deleteByPrimaryKey(id)> 0 ? true : false;
    }

    @Override
    public Page findCondition4Page(Condition condition, Page page) {
        condition.setPage(page.getPage());
        condition.setRows(page.getRows());
        page.setRecords(conditionDao.selectConditionCount());
        page.setGridObjectData(conditionDao.selectByPage(condition));
        return page;
    }
}
